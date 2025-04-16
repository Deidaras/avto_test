package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public interface Sidebar {

    default SelenideElement feedButton() {
        return $x("//a[@data-l=\"t,userMain\"]");
    }
    default String feedButtonGetText() {
        return (feedButton().shouldBe(visible.because("Элемент кнопки новостей не найден")).text());
    }


    default SelenideElement hobbyButton() {
        return $x("//a[@data-l=\"t,hobby\"]");
    }
    default String hobbyButtonGetText() {
        return (hobbyButton().shouldBe(visible.because("Элемент кнопки хобби не найден")).text());
    }


    default SelenideElement friendButton() {
        return $x("//a[@data-l=\"t,userFriend\"]");
    }
    default String friendButtonGetText() {
        return (friendButton().shouldBe(visible.because("Элемент кнопки друзей не найден")).text());
    }


    default SelenideElement photoButton() {
        return $x("//a[@data-l=\"t,userPhotos\"]");
    }
    default String photoButtonGetText() {
        return (photoButton().shouldBe(visible.because("Элемент кнопки фото не найден")).text());
    }


    default SelenideElement groupButton() {
        return $x("//a[@data-l=\"t,userAltGroup\"]");
    }
    default String groupButtonGetText() {
        return (groupButton().shouldBe(visible.because("Элемент кнопки групп не найден")).text());
    }


    default SelenideElement gamesButton() {
        return $x("//a[@data-l=\"t,appsShowcaseHD\"]");
    }
    default String gamesButtonGetText() {
        return (gamesButton().shouldBe(visible.because("Элемент кнопки игр не найден")).text());
    }


    default SelenideElement giftsButton() {
        return $x("//a[@data-l=\"t,giftsFront\"]");
    }
    default String giftsButtonGetText() {
        return (giftsButton().shouldBe(visible.because("Элемент кнопки подарков не найден")).text());
    }


    default SelenideElement recommendButton() {
        return $x("//a[@data-l=\"t,discovery\"]");
    }
    default String recommendButtonGetText() {
        return (recommendButton().shouldBe(visible.because("Элемент кнопки рекомендаций не найден")).text());
    }


    default SelenideElement appsButton() {
        return $x("//a[@data-l=\"t,bizApps\"]");
    }
    default String appsButtonGetText() {
        return (appsButton().shouldBe(visible.because("Элемент кнопки приложений не найден")).text());
    }

    default SelenideElement datingButton() {
        return $x("//a[@data-l=\"t,appsDating\"]");
    }
    default String datingButtonGetText() {
        return (datingButton().shouldBe(visible.because("Элемент кнопки знакомств не найден")).text());
    }

}
