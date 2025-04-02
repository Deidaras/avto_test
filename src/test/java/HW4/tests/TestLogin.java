package HW4.tests;

import org.junit.jupiter.api.Test;
import HW4.pages.LoginPage;
import HW4.pages.UserPage;

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
        UserPage userPage = new UserPage();

        loginPage.login(username, password);

        assertEquals(expectedUsername, userPage.getLoggedInUserName());
    }
}
