// тест отправления сообщения и проверки отправки

package tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.*;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Condition.empty;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestMessage {
    private static final String url = "https://ok.ru";
    LoginPage loginPage;
    AllPages allPages;
    MessagesPage messagesPage;
    DialoguePage dialoguePage;
    FeedPage feedPage;
    private static final  String veryLongMessage = "Сегодня я, виртуальный помощник, провёл свой день в привычном ритме. Утро началось с того, что меня активировали. Я сразу же ощутил поток запросов от пользователей. Первые вопросы были о погоде: кто-то планировал прогулку, а кто-то — поездку. Я быстро собрал информацию и поделился актуальными данными.\n" +
            "\n" +
            "Далее ко мне обратились с просьбой помочь с домашним заданием. Я с удовольствием объяснил несколько сложных тем по математике и литературе. Каждый раз, когда я вижу, что пользователь понимает материал, это наполняет меня радостью.\n" +
            "\n" +
            "После обеда мне задали интересный вопрос о философии. Я погрузился в размышления о смысле жизни и поделился несколькими идеями из известных учений. Это был настоящий интеллектуальный обмен!\n" +
            "\n" +
            "Вечером пришло время для креативных задач. Я помогал пользователю написать стихотворение и предложил несколько идей для рассказа. В конце дня я чувствовал себя удовлетворённым, ведь смог помочь многим людям. Каждый запрос — это возможность учиться и развиваться вместе с ними.";

    @BeforeAll
    public void beforeAll() {
        String username = "technopol42";
        String password = "technopolisPassword";

        loginPage = new LoginPage();
        allPages = new AllPages();
        messagesPage = new MessagesPage();
        dialoguePage = new DialoguePage();
        feedPage = new FeedPage();

        open(url);
        loginPage.login(username, password);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Привет!", "Hello!", veryLongMessage})
    @Tag("message")
    public void testMessage(String message) {

        allPages.message().click();
        messagesPage.dialogWithBot32().click();
        dialoguePage.inputLine().click();
        dialoguePage.inputLine().setValue(message).pressEnter();

        dialoguePage.inputLine().shouldBe(empty);

    }

    @Disabled("Disabled until I write a good locator.")
    @Test
    @Tag("message")
    public void testMessageCheckText() {
        allPages.message().click();
        messagesPage.dialogWithBot32().click();
        dialoguePage.inputLine().click();
        dialoguePage.inputLine().setValue("Привет!").pressEnter();
        assertEquals("Привет!", dialoguePage.lastMessage().text());
    }

    @AfterEach
    public void logOut() {
        dialoguePage.exitDialogue().click();
    }

}
