package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class DialoguePage {
    private static final By INPUTLINE = By.xpath("//div[@class=\"js-lottie-observer\"]");
    private static final By EXITDIALOGUE = By.xpath("//div[@data-l=\"t,closeLayer\"]");


    public void inputLineClick() {
        $(INPUTLINE).shouldBe(visible.because("Элемент кнопки строки для ввода не найден")).click();
    }
    public void inputLineEnter(String message) {
        $(INPUTLINE).shouldBe(visible.because("Элемент кнопки строки для ввода не найден")).setValue(message).pressEnter();
    }
    public void inputLineEmpty() {
        $(INPUTLINE).shouldBe(visible.because("Элемент кнопки строки для ввода не найден")).shouldBe(empty);
    }

    public void exitDialogueClick() {
        $(EXITDIALOGUE).shouldBe(visible.because("Элемент кнопки выхода из диалога не найден")).click();
    }

}
