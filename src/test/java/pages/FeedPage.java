package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pages.components.Header;
import pages.components.Sidebar;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class FeedPage implements Header, Sidebar {

    public SelenideElement userName() {
        return $x("//div[@class=\"tico ellip\"]");
    }
    public String userNameGetText() {
        return (userName().shouldBe(visible.because("Элемент имени юзера не найден")).text());
    }

    public SelenideElement firstNews() {
        return $x("//div[contains(@class, \"feed\") and contains(@class, \"__header-redesign\")]");
    }
    public void firstNewsVisible() {
        firstNews().shouldBe(visible.because("Элемент первой новости не найден"));
    }
    public void firstNewsClick() {
        firstNews().shouldBe(visible.because("Элемент первой новости не найден")).click();
    }

    // локатор для взаимодействия с первым лайком
    public SelenideElement likeFirstNews() {
        return $x("//span[@data-like-icon=\"like\"]");
    }

    // локатор для определения активности первого лайка
    public boolean activeLikeStatusFirstNews() {
        return $x("//span[@data-like-icon=\"like\"]/..").shouldBe(visible.because("Элемент лайка при проверке активности лайка не найден")).getAttribute("class").contains("__active");
    }
    // проверка элемента коллекции на активность
    public boolean statusLike(SelenideElement element) {
        return (element.getAttribute("class").contains("__active"));
    }


    // локатор для коллекции лайков на странице
    public ElementsCollection collectionLikes() {
        return $$x("//span[@data-like-icon=\"like\"]").shouldHave(sizeGreaterThanOrEqual(0));
    }
    // локатор коллекции определения статусов лайков на странице
    public ElementsCollection collectionLikeStatus() {
        return $$x("//span[@data-like-icon=\"like\"]/..").shouldHave(sizeGreaterThanOrEqual(0));
    }

    // проверить активность лайка по индексу возвращает boolean
    public Boolean collectionLikeStatusElementActive(Integer index) {
        return (collectionLikeStatus().get(index).shouldBe(visible.because("Элемент лайка при проверке активности лайка не найден")).getAttribute("class").contains("__active"));
    }
    // кликнуть на лайк по индексу
    public void collectionLikeStatusElementClick(Integer index) {
        collectionLikes().get(index).shouldBe(visible.because("Элемент лайка для клика не найден")).click();
    }
    // проверка через shouldHave активности лайка
    public void collectionLikeShouldHaveLike(Integer index) {
        collectionLikeStatus().get(index).shouldBe(visible.because("Элемент лайка для проверки активности лайка не найден")).shouldHave((cssClass("__active")));
    }
    //
    public SelenideElement profileSettings() {
        return  $x("//button[contains(@class,\"toolbar_ucard\")]");
    }
}
