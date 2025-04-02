package tests;

import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.FeedPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

//тест для авторизации, проверяет только то, тот ли человек зашёл,
// проверяя имя ожидаемое и то, что отображается на странице

public class TestLogin {
    private static String url = "https://ok.ru";
    private static String expectedUsername = "technopol42 technopol42";
    private static String username = "technopol42";
    private static String password = "technopolisPassword";

    @Test
    public void testSuccessfulLogin() {
        open(url);

        LoginPage loginPage = new LoginPage();
        FeedPage feedPage = new FeedPage();

        loginPage.login(username, password);

        assertEquals(expectedUsername, feedPage.getLoggedInUserName());
    }
}
