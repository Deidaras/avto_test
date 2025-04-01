package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import pages.*;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Selenide.open;

public class TestUnlike {
    private static final String url = "https://ok.ru";
    LoginPage loginPage;
    AllPages allPages;
    MessagesPage messagesPage;
    DialoguePage dialoguePage;
    UserPage userPage;

    @BeforeEach
    public void before() {
        String username = "technopol42";
        String password = "technopolisPassword";

        loginPage = new LoginPage();
        allPages = new AllPages();
        messagesPage = new MessagesPage();
        dialoguePage = new DialoguePage();
        userPage = new UserPage();

        open(url);
        loginPage.login(username, password);
    }

    @Test
    public void testLike() {

        if (!userPage.likeFirstNews().getAttribute("class").contains("__active")) {
            userPage.likeFirstNews().click();
            userPage.activeLikeFirstNews().shouldHave(cssClass("__active"));
            userPage.likeFirstNews().click();
            userPage.activeLikeFirstNews().shouldNotHave((cssClass("__active")));
        } else {
            userPage.likeFirstNews().click();
            userPage.activeLikeFirstNews().shouldNotHave((cssClass("__active")));
        }

    }

}

