package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.components.Header;
import pages.components.Sidebar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.LikeWrapper;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.*;


public class FeedPage extends LoadableComponent<FeedPage> implements Header, Sidebar {
    private static final Logger logger = LoggerFactory.getLogger(FeedPage.class);
    private static final By FIRSTNEW = By.xpath("//div[contains(@class, \"feed\") and contains(@class, \"__header-redesign\")]");
    private static final By FIRSTLIKE = By.xpath("//span[@data-like-icon=\"like\"]");
    private static final By FIRSTLIKESTATUS = By.xpath("//span[@data-like-icon=\"like\"]/..");
    private static final By PROFILESETTINGS = By.xpath("//button[contains(@class,\"toolbar_ucard\")]");
    private static final By COLLECTION_LIKES = By.xpath("//span[@data-like-icon=\"like\"]");
    private static final By COLLECTION_LIKE_STATUS = By.xpath("//span[@data-like-icon=\"like\"]/..");

    @Override
    protected void isLoaded() throws Error {
        verifyElementIsVisible("Username", $(USERNAME));
        verifyElementIsVisible("First News", $(FIRSTNEW));
        logger.info("FeedPage is loaded!");
    }

    public void firstLikeCheckAndDeactivate() {
        LikeWrapper like = getLike(0);
        if (like.waitUntilLoaded().isActive()) {
            like.waitUntilLoaded().click();
        }
    }

    public LikeWrapper getLike(Object like) {
        if (like instanceof SelenideElement) {
            return LikeWrapper.of((SelenideElement) like);
        } else if (like instanceof Integer) {
            return LikeWrapper.of(collectionLikeStatus(), (int) like);
        }
        throw new IllegalArgumentException("Неправильный тип лайка");
    }

    public int findAndClickFirstInactiveLike (int maxElements) {
        int elementsToCheck = Math.min(10, collectionLikes().size());
        logger.debug("Будем проверять первые {} элементов из {}", elementsToCheck, collectionLikes().size());
        for (int i = 0; i < elementsToCheck; i++) {
            logger.debug("Проверяем лайк #{}", i);
            if (!collectionLikeActive(i)) {
                logger.info("Найден неактивный лайк #{} - кликаем по нему", i);
                collectionLikeClick(i);
                return i;
            }
        }
        return -1;
    }

    public ElementsCollection collectionLikes() {
        return $$(COLLECTION_LIKES).shouldHave(sizeGreaterThan(0));
    }
    public ElementsCollection collectionLikeStatus() {
        return $$(COLLECTION_LIKE_STATUS).shouldHave(sizeGreaterThan(0));
    }


    // проверить активность лайка по индексу возвращает boolean
    public Boolean collectionLikeActive(int index) {
        LikeWrapper like = getLike(index);
        return like.waitUntilLoaded().isActive();
    }
    // кликнуть на лайк по индексу
    public void collectionLikeClick(Integer index) {
        LikeWrapper like = getLike(index);
        like.waitUntilLoaded().click();
    }
    // проверка через shouldHave активности лайка
    public void collectionShouldBeActive(int index) {
        LikeWrapper like = getLike(index);
        like.waitUntilLoaded().shouldBeActive();
    }
    public void collectionShouldNotBeActive(int index) {
        LikeWrapper like = getLike(index);
        like.waitUntilLoaded().shouldNotBeActive();
    }
}
