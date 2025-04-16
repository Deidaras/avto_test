package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class DialoguePage {
    public SelenideElement inputLine() {
        return $x("//div[@class=\"js-lottie-observer\"]").shouldBe(visible.because("Элемент кнопки строки для ввода не найден"));
    }
    public void inputLineClick() {
        inputLine().click();
    }
    public void inputLineEnter(String message) {
        inputLine().setValue(message).pressEnter();
    }
    public void inputLineEmpty() {
        inputLine().shouldBe(empty);
    }

    public SelenideElement exitDialogue() {
        return $x("//div[@data-l=\"t,closeLayer\"]");
    }
    public void exitDialogueClick() {
        exitDialogue().shouldBe(visible.because("Элемент кнопки выхода из диалога не найден")).click();
    }

}
