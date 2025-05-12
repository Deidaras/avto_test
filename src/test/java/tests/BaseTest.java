package tests;

import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.BeforeAll;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public abstract class BaseTest {
    private static String url;
    private static String username;
    private static String password;

    public static final Dotenv dotenv = Dotenv.configure()
            .load();

    @BeforeAll
    public static void setup() {

//        url = System.getenv("BASE_URL");
//        username = System.getenv("USERNAME");
//        password = System.getenv("PASSWORD");

        url = dotenv.get("BASE_URL");
        username = dotenv.get("USERNAMEOK");
        password = dotenv.get("PASSWORDOK");

        assertNotNull(url, "BASE_URL не задан в .env файле");
        assertNotNull(username, "USERNAME не задан в .env файле");
        assertNotNull(password, "PASSWORD не задан в .env файле");

        open(url);
        new LoginPage()
                .get()
                .login(username, password);
    }
}
