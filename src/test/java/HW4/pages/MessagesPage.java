package HW4.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class MessagesPage {
    public SelenideElement dialogWithBot32() {
        return $x("//msg-chats-list-item[@data-item-id=\"3359955742\"]");
    }


}
