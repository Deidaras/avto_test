// тест отправления сообщения и проверки отправки

package tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestMessage extends BaseTest{
    private static final Logger logger = LoggerFactory.getLogger(TestMessage.class);
    private static final  String veryLongMessage = """
            Сегодня я, виртуальный помощник, провёл свой день в привычном ритме. Утро началось с того, что меня активировали. Я сразу же ощутил поток запросов от пользователей. Первые вопросы были о погоде: кто-то планировал прогулку, а кто-то — поездку. Я быстро собрал информацию и поделился актуальными данными.\\n
            Далее ко мне обратились с просьбой помочь с домашним заданием. Я с удовольствием объяснил несколько сложных тем по математике и литературе. Каждый раз, когда я вижу, что пользователь понимает материал, это наполняет меня радостью.\\n
            После обеда мне задали интересный вопрос о философии. Я погрузился в размышления о смысле жизни и поделился несколькими идеями из известных учений. Это был настоящий интеллектуальный обмен!\\n
            Вечером пришло время для креативных задач. Я помогал пользователю написать стихотворение и предложил несколько идей для рассказа. В конце дня я чувствовал себя удовлетворённым, ведь смог помочь многим людям. Каждый запрос — это возможность учиться и развиваться вместе с ними.""";

    private DialoguePage dialoguePage;

//    @Disabled("Disabled because I would like to check another test")
    @ParameterizedTest
    @ValueSource(strings = {"Привет!", "Hello!", veryLongMessage})
    @Tag("message")
    public void testMessage(String message) {
        logger.info("Запуск теста сообщений, загрузка FeedPage");
        FeedPage feedPage = new FeedPage().get();
        feedPage.messageClick();

        MessagesPage messagesPage = new MessagesPage();
        messagesPage.dialogWithBot32Click();

        dialoguePage = new DialoguePage().get();
        dialoguePage.inputLineClick();
        logger.info("Отправка сообщения");
        dialoguePage.inputLineEnter(message);

        logger.info("Проверка, что строка ввода пуста");
        dialoguePage.inputLineEmpty();

    }

    @Disabled("Disabled until I write a good locator.")
    @Test
    @Tag("message")
    public void testMessageCheckText() {
        logger.info("Запуск теста сообщений, загрузка FeedPage в тесте с сравниванием");
        FeedPage feedPage = new FeedPage().get();
        feedPage.messageClick();

        MessagesPage messagesPage = new MessagesPage();
        messagesPage.dialogWithBot32Click();

        DialoguePage dialoguePage = new DialoguePage().get();
        dialoguePage.inputLineClick();
        dialoguePage.inputLineEnter("Привет!");
        dialoguePage.compareLastMessageAndSent("Привет!");
    }

    @AfterEach
    public void exitMessage() {
        logger.info("Выход из окна с сообщениями");
        dialoguePage.exitDialogueClick();
    }

}
