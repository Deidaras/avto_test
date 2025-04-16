package tests;

import org.junit.jupiter.api.BeforeAll;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.open;

public abstract class BaseTest {
    private static final String url = "https://ok.ru";
    private static final String username = "technopol42";
    private static final String password = "technopolisPassword";

    @BeforeAll
    public static void setup() {
        open(url);
        new LoginPage().login(username, password);
    }
}
