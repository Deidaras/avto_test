package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class MessagesPage {
    public SelenideElement dialogWithBot32() {
        return $x("//msg-chats-list-item[@data-item-id=\"3359955742\"]").shouldBe(visible.because("Элемент кнопки диалога с ботом technopol32 technopol32 не найден"));
    }

    public void dialogWithBot32Click() {
        dialogWithBot32().click();
    }


}
