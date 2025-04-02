package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.AllPages;
import pages.LoginPage;
import pages.FeedPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

//тест для авторизации, проверяет только то, тот ли человек зашёл,
// проверяя имя ожидаемое и то, что отображается на странице

public class TestLogin {
    private static String url = "https://ok.ru";
    private static String expectedUsername = "technopol42 technopol42";
    private static String username = "technopol42";
    private static String password = "technopolisPassword";
    private static String feedMenuRus = "Лента";
    private static String hobbyMenuRus = "Увлечения";
    private static String friendMenuRus = "Друзья";
    private static String photoMenuRus = "Фото";
    private static String groupMenuRus = "Группы";
    private static String gamesMenuRus = "Игры";
    private static String giftsMenuRus = "Подарки";
    private static String recommendMenuRus = "Рекомендации";
    private static String appsMenuRus = "Приложения";
    private static String datingMenuRus = "Знакомства в ОК";

    @DisplayName("Login Test")
    @Test
    public void testSuccessfulLogin() {
        open(url);

        LoginPage loginPage = new LoginPage();
        FeedPage feedPage = new FeedPage();
        AllPages allPages = new AllPages();

        loginPage.login(username, password);

        assertAll("Menu",
                // check user's name
                () -> assertEquals(expectedUsername, feedPage.userName().text()),
                // check visible first news
                () -> feedPage.firstNews().shouldBe(visible),
                // check menu buttons
                () -> assertEquals(feedMenuRus, allPages.feedButton().text()),
                () -> assertEquals(hobbyMenuRus, allPages.hobbyButton().text()),
                () -> assertEquals(friendMenuRus, allPages.friendButton().text()),
                () -> assertEquals(photoMenuRus, allPages.photoButton().text()),
                () -> assertEquals(groupMenuRus, allPages.groupButton().text()),
                () -> assertEquals(gamesMenuRus, allPages.gamesButton().text()),
                () -> assertEquals(giftsMenuRus, allPages.giftsButton().text()),
                () -> assertEquals(recommendMenuRus, allPages.recommendButton().text()),
                () -> assertEquals(appsMenuRus, allPages.appsButton().text()),
                () -> assertEquals(datingMenuRus, allPages.datingButton().text())
        );

    }
}
