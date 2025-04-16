package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;


public class LoginPage {
    public SelenideElement loginField() {
        return $x("//input[@id=\"field_email\"]").shouldBe(visible.because("Элемент поля ввода логина не найден"));
    }

    public SelenideElement passwordField() {
        return $x("//input[@id=\"field_password\"]").shouldBe(visible.because("Элемент поля ввода пароля не найден"));
    }

    public SelenideElement loginButton() {
        return $x("//div[@class=\"login-form-actions\"]/input").shouldBe(visible.because("Элемент кнопки входа не найден"));
    }

    public void login(String username, String password) {
        loginField().setValue(username);
        passwordField().setValue(password);
        loginButton().click();
    }



}
