package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;


public class LoginPage {
    public SelenideElement loginField() {
        return $x("//input[@id=\"field_email\"]");
    }

    public SelenideElement passwordField() {
        return $x("//input[@id=\"field_password\"]");
    }

    public SelenideElement loginButton() {
        return $x("//div[@class=\"login-form-actions\"]/input");
    }

    public void login(String username, String password) {
        loginField().setValue(username);
        passwordField().setValue(password);
        loginButton().click();
    }



}
