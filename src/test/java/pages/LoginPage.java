package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class LoginPage extends LoadableComponent<LoginPage> {
    private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);

    private static final By LOGINFIELD = By.xpath("//input[@id=\"field_email\"]");
    private static final By PASSWORDFIELD = By.xpath("//input[@id=\"field_password\"]");
    private static final By LOGINBUTTON = By.xpath("//div[@class=\"login-form-actions\"]/input");

    @Override
    protected void isLoaded() throws Error {
        verifyElementIsVisible("Login field", $(LOGINFIELD));
        verifyElementIsVisible("Password field", $(PASSWORDFIELD));
        verifyElementIsVisible("Login button", $(LOGINBUTTON));
        logger.info("LoginPage is loaded!");
    }

    public SelenideElement loginField() {
        return $(LOGINFIELD).shouldBe(visible.because("Элемент поля ввода логина не найден"));
    }

    public SelenideElement passwordField() {
        return $(PASSWORDFIELD).shouldBe(visible.because("Элемент поля ввода пароля не найден"));
    }

    public SelenideElement loginButton() {
        return $(LOGINBUTTON).shouldBe(visible.because("Элемент кнопки входа не найден"));
    }

    public void login(String username, String password) {
        loginField().setValue(username);
        passwordField().setValue(password);
        loginButton().click();
    }
}
