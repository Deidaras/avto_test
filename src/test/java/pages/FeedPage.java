package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class FeedPage {
    public SelenideElement userName() {
        return $x("//div[@class=\"tico ellip\"]");
    }

    public SelenideElement firstNews() {
        return $x("//div[contains(@class, \"feed\") and contains(@class, \"__header-redesign\")]");
    }

    // локатор для взаимодействия с первым лайком
    public SelenideElement likeFirstNews() {
        return $x("//span[@data-like-icon=\"like\"]");
    }

    // локатор для определения активности первого лайка
    public SelenideElement activeLikeFirstNews() {
        return $x("//span[@data-like-icon=\"like\"]/..");
    }
    // локатор для коллекции лайков на странице
    public ElementsCollection collectionLikes() {
        return $$x("//span[@data-like-icon=\"like\"]");
    }

    // локатор коллекции определения статусов лайков на странице
    public ElementsCollection collectionsActiveLike() {
        return $$x("//span[@data-like-icon=\"like\"]/..");
    }

    public SelenideElement profileSettings() {
        return  $x("//button[contains(@class,\"toolbar_ucard\")]");
    }



}
