package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class AllPages {
    public SelenideElement message() {
        return $x("//*[@class=\"toolbar_nav_i_ic\"]");
    }
}
