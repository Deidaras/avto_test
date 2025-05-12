package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MessagesPage {
    private static final By DIALOGWITHBOT32 = By.xpath("//msg-chats-list-item[@data-item-id=\"3359955742\"]");


    public void dialogWithBot32Click() {
        $(DIALOGWITHBOT32)
                .shouldBe(visible.because("Элемент кнопки диалога с ботом technopol32 technopol32 не найден"))
                .click();
    }

}
