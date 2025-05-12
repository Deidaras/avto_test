package pages.components;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public interface Sidebar {
    By USERNAME = By.xpath("//div[@class=\"tico ellip\"]");
    By FEED_BUTTON = By.xpath("//a[@data-l=\"t,userMain\"]");
    By HOBBY_BUTTON = By.xpath("//a[@data-l=\"t,hobby\"]");
    By FRIEND_BUTTON = By.xpath("//a[@data-l=\"t,userFriend\"]");
    By PHOTO_BUTTON = By.xpath("//a[@data-l=\"t,userPhotos\"]");
    By GROUP_BUTTON = By.xpath("//a[@data-l=\"t,userAltGroup\"]");
    By GAMES_BUTTON = By.xpath("//a[@data-l=\"t,appsShowcaseHD\"]");
    By GIFTS_BUTTON = By.xpath("//a[@data-l=\"t,giftsFront\"]");
    By RECOMMEND_BUTTON = By.xpath("//a[@data-l=\"t,discovery\"]");
    By APPS_BUTTON = By.xpath("//a[@data-l=\"t,bizApps\"]");
    By DATING_BUTTON = By.xpath("//a[@data-l=\"t,appsDating\"]");

    default String userNameGetText() {
        return ($(USERNAME).shouldBe(visible.because("Элемент имени юзера не найден")).text());
    }

    default String feedButtonGetText() {
        return ($(FEED_BUTTON).shouldBe(visible.because("Элемент кнопки новостей не найден")).text());
    }

    default String hobbyButtonGetText() {
        return ($(HOBBY_BUTTON).shouldBe(visible.because("Элемент кнопки хобби не найден")).text());
    }

    default String friendButtonGetText() {
        return ($(FRIEND_BUTTON).shouldBe(visible.because("Элемент кнопки друзей не найден")).text());
    }

    default String photoButtonGetText() {
        return ($(PHOTO_BUTTON).shouldBe(visible.because("Элемент кнопки фото не найден")).text());
    }

    default String groupButtonGetText() {
        return ($(GROUP_BUTTON).shouldBe(visible.because("Элемент кнопки групп не найден")).text());
    }

    default String gamesButtonGetText() {
        return ($(GAMES_BUTTON).shouldBe(visible.because("Элемент кнопки игр не найден")).text());
    }

    default String giftsButtonGetText() {
        return ($(GIFTS_BUTTON).shouldBe(visible.because("Элемент кнопки подарков не найден")).text());
    }

    default String recommendButtonGetText() {
        return ($(RECOMMEND_BUTTON).shouldBe(visible.because("Элемент кнопки рекомендаций не найден")).text());
    }

    default String appsButtonGetText() {
        return ($(APPS_BUTTON).shouldBe(visible.because("Элемент кнопки приложений не найден")).text());
    }

    default String datingButtonGetText() {
        return ($(DATING_BUTTON).shouldBe(visible.because("Элемент кнопки знакомств не найден")).text());
    }

}
