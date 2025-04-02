package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class AllPages {
    public SelenideElement message() {
        return $x("//*[@class=\"toolbar_nav_i_ic\"]");
    }
    public SelenideElement feedButton() {
        return $x("//a[@data-l=\"t,userMain\"]");
    }

    public SelenideElement hobbyButton() {
        return $x("//a[@data-l=\"t,hobby\"]");
    }

    public SelenideElement friendButton() {
        return $x("//a[@data-l=\"t,userFriend\"]");
    }

    public SelenideElement photoButton() {
        return $x("//a[@data-l=\"t,userPhotos\"]");
    }

    public SelenideElement groupButton() {
        return $x("//a[@data-l=\"t,userAltGroup\"]");
    }

    public SelenideElement gamesButton() {
        return $x("//a[@data-l=\"t,appsShowcaseHD\"]");
    }
    public SelenideElement giftsButton() {
        return $x("//a[@data-l=\"t,giftsFront\"]");
    }
    public SelenideElement recommendButton() {
        return $x("//a[@data-l=\"t,discovery\"]");
    }
    public SelenideElement appsButton() {
        return $x("//a[@data-l=\"t,bizApps\"]");
    }

    public SelenideElement datingButton() {
        return $x("//a[@data-l=\"t,appsDating\"]");
    }

}
