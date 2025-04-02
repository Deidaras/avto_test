package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import pages.*;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Selenide.open;

public class TestLike {
    private static final String url = "https://ok.ru";
    LoginPage loginPage;
    AllPages allPages;
    MessagesPage messagesPage;
    DialoguePage dialoguePage;
    FeedPage feedPage;
    private int index;

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

        index = 1;
        boolean foundNonActive = false;

        while (index < feedPage.collectionLikes().size() && !foundNonActive) {
            if (!feedPage.collectionsActiveLike().get(index).getAttribute("class").contains("__active")) {
                feedPage.collectionsActiveLike().get(index).click();
                foundNonActive = true;
            }
            index++;
        }
        index -=1;
        feedPage.collectionsActiveLike().get(index).shouldHave((cssClass("__active")));

    }

    @AfterEach
        public void deleteLikes() {
        feedPage.collectionsActiveLike().get(index).click();
        }
}
