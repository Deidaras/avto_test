package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.components.Header;
import pages.components.Sidebar;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class FeedPage implements Header, Sidebar {
//    private static final Logger LOGGER = Logger.getLogger();
    private static final By USERNAME = By.xpath("//div[@class=\"tico ellip\"]");
    private static final By FIRSTNEW = By.xpath("//div[contains(@class, \"feed\") and contains(@class, \"__header-redesign\")]");
    private static final By FIRSTLIKE = By.xpath("//span[@data-like-icon=\"like\"]");
    private static final By FIRSTLIKESTATUS = By.xpath("//span[@data-like-icon=\"like\"]/..");

    // имя юзера на боковом меню
    public String userNameGetText() {
        return ($(USERNAME).shouldBe(visible.because("Элемент имени юзера не найден")).text());
    }
    // видимость первой новости
    public void firstNewsVisible() {
        $(FIRSTNEW).shouldBe(visible.because("Элемент первой новости не найден"));
    }


    // нажать на первый лайк
    public void firstLikeClick() {
        $(FIRSTLIKE).shouldBe(visible.because("Элемент первого лайка не найден")).click();
    }
    // статус первого лайка, true - нажат, false - нет
    public boolean activeLikeStatusFirst() {
        return ($(FIRSTLIKESTATUS).shouldBe(visible.because("Элемент лайка при проверке активности лайка не найден")).getAttribute("class").contains("__active"));
    }
    // статус первого лайка через shouldHave
    public void firstLikeStatusCheck() {
        $(FIRSTLIKESTATUS).shouldBe(visible.because("Элемент лайка при проверке активности лайка не найден")).shouldHave((cssClass("__active")));
    }
    public void firstUnlikeStatusCheck() {
        $(FIRSTLIKESTATUS).shouldBe(visible.because("Элемент лайка при проверке активности лайка не найден")).shouldNotHave((cssClass("__active")));
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

    public void firstLikeCheck() {
        if (activeLikeStatusFirst()) {
            firstLikeClick();
        }
    }
}
