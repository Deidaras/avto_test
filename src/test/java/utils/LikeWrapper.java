package utils;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.visible;

public class LikeWrapper {
    private final SelenideElement element;
    private final ElementsCollection collection;
    private final int index;

    private LikeWrapper(SelenideElement element) {
        this.element = element;
        this.collection = null;
        this.index = -1;
    }

    private LikeWrapper(ElementsCollection collection, int index) {
        this.element = null;
        this.collection = collection;
        this.index = index;
    }

    public static LikeWrapper of(SelenideElement element) {
        return new LikeWrapper(element);
    }

    public static LikeWrapper of(ElementsCollection collection, int index) {
        return new LikeWrapper(collection, index);
    }

    public boolean isActive() {
        return getElement()
            .getAttribute("class")
                .contains("__active");
    };

    public LikeWrapper waitUntilLoaded() {
        getElement().shouldBe(visible.because("Элемент лайка не найден"));
        return this;
    };

    private LikeWrapper checkIfActive() {
        if (!isActive()) {
            throw new AssertionError("Лайк должен быть активным!");
        }
        return this;
    }


    private SelenideElement getElement() {
        if (element != null) {
            return element;
        } else if (collection != null && index >=0) {
            return collection.get(index);
        }
        throw new IllegalStateException("Элемента нет");
    }

    public LikeWrapper click() {
        getElement().click();
        return this;
    }
    public void shouldBeActive() {
        getElement().shouldHave((cssClass("__active")));
    }
    public void shouldNotBeActive() {
        getElement().shouldNotHave((cssClass("__active")));
    }



}
