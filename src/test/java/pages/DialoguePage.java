package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class DialoguePage {
    public SelenideElement inputLine() {
        return $x("//div[@class=\"js-lottie-observer\"]");
    }

    public SelenideElement exitDialogue() {
        return $x("//div[@data-l=\"t,closeLayer\"]");
    }

}
