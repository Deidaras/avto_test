package HW4.tests;

import HW4.pages.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Selenide.open;

public class TestLike {
    private static final String url = "https://ok.ru";
    LoginPage loginPage;
    AllPages allPages;
    MessagesPage messagesPage;
    DialoguePage dialoguePage;
    UserPage userPage;
    private int index;

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

        index = 1;
        boolean foundNonActive = false;

        while (index < userPage.collectionLikes().size() && !foundNonActive) {
            if (!userPage.collectionsActiveLike().get(index).getAttribute("class").contains("__active")) {
                userPage.collectionsActiveLike().get(index).click();
                foundNonActive = true;
            }
            index++;
        }
        index -=1;
        userPage.collectionsActiveLike().get(index).shouldHave((cssClass("__active")));

    }

    @AfterEach
        public void deleteLikes() {
        userPage.collectionsActiveLike().get(index).click();
        }
}
