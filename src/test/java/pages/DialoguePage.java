package pages;

import com.codeborne.selenide.ElementsCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DialoguePage extends LoadableComponent<DialoguePage> {
    private static final Logger logger = LoggerFactory.getLogger(DialoguePage.class);
    private static final By INPUTLINE = By.xpath("//div[@class=\"js-lottie-observer\"]");
    private static final By EXITDIALOGUE = By.xpath("//div[@data-l=\"t,closeLayer\"]");
    private final ElementsCollection MESSAGES = $$("//msg-message//div[@class=\"txt-okmsg\"]/span");

    @Override
    protected void isLoaded() throws Error {
        verifyElementIsVisible("Input line", $(INPUTLINE));
        verifyElementIsVisible("Exit dialogue", $(EXITDIALOGUE));
        logger.info("DialoguePage is loaded!");
    }

    public void inputLineClick() {
        $(INPUTLINE).shouldBe(visible.because("Элемент кнопки строки для ввода не найден")).click();
    }
    public void inputLineEnter(String message) {
        $(INPUTLINE)
                .shouldBe(visible.because("Элемент кнопки строки для ввода не найден"))
                .setValue(message)
                .pressEnter();
    }
    public void inputLineEmpty() {
        $(INPUTLINE).shouldBe(visible.because("Элемент кнопки строки для ввода не найден")).shouldBe(empty);
    }

    public void exitDialogueClick() {
        $(EXITDIALOGUE).shouldBe(visible.because("Элемент кнопки выхода из диалога не найден")).click();
    }

    public void compareLastMessageAndSent(String expectedMessage) {
        MESSAGES.last().shouldBe(visible.because("Элемент последнего сообщения не найден"));
        logger.debug("Сравнение текста последнего сообщения и отправленного");
        assertEquals(expectedMessage, MESSAGES.last().text());
    }

}
