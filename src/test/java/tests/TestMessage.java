// тест отправления сообщения и проверки отправки

package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.*;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Condition.empty;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TestMessage {
    private static final String url = "https://ok.ru";
    private static final String message = "Привет!";
    LoginPage loginPage;
    AllPages allPages;
    MessagesPage messagesPage;
    DialoguePage dialoguePage;

    @BeforeEach
    public void before() {
        String username = "technopol42";
        String password = "technopolisPassword";

        loginPage = new LoginPage();
        allPages = new AllPages();
        messagesPage = new MessagesPage();
        dialoguePage = new DialoguePage();


        open(url);
        loginPage.login(username, password);
    }


    @Test
    public void testMessage() {

        allPages.message().click();
        messagesPage.dialogWithBot32().click();
        dialoguePage.inputLine().click();
        dialoguePage.inputLine().setValue(message).pressEnter();

        dialoguePage.inputLine().shouldBe(empty);
//        assertEquals(message, dialoguePage.lastMessage().getAttribute("textContent").trim(), "Text of message is not correct");

        // не смогла написать хороший локатор для проверки текста последнего сообщения
        // и ожидаемого, буду рада, если подскажете

    }

}
