package tests;

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
    FeedPage feedPage;

    @BeforeEach
    public void before() {
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

    @Test
    public void testLike() {

        if (!feedPage.likeFirstNews().getAttribute("class").contains("__active")) {
            feedPage.likeFirstNews().click();
            feedPage.activeLikeFirstNews().shouldHave(cssClass("__active"));
            feedPage.likeFirstNews().click();
            feedPage.activeLikeFirstNews().shouldNotHave((cssClass("__active")));
        } else {
            feedPage.likeFirstNews().click();
            feedPage.activeLikeFirstNews().shouldNotHave((cssClass("__active")));
        }

    }

}

