package pages.components;


import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public interface Header {
    By MESSAGE = By.xpath("//*[@class=\"toolbar_nav_i_ic\"]");

    default void messageClick() {
        $(MESSAGE).shouldBe(visible.because("Элемент кнопки сообщений не найден")).click();
    }
}
