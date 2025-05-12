package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.visible;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class LoadableComponent<T extends LoadableComponent<T>> {
    private static final Logger logger = LoggerFactory.getLogger(FeedPage.class);

    public T get() {
        isLoaded();
        try {
            return (T) this;
        } catch (Exception e) {
            throw new RuntimeException("Failed to cast to component type", e);
        }
    }

//    protected abstract void load();

    protected abstract void isLoaded() throws Error;

    protected void verifyElementIsVisible(String elementName, SelenideElement element) {
        logger.info(elementName + " is loading");
        element.shouldBe(visible.because(elementName + " should be visible"));
    }
}
