package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public interface Header {
    default SelenideElement message() {
        return $x("//*[@class=\"toolbar_nav_i_ic\"]");
    }
    default void messageClick() {
        message().shouldBe(visible.because("Элемент кнопки сообщений не найден")).click();
    }
}
