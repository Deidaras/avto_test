package tests;

import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import pages.*;

import static org.junit.jupiter.api.Assertions.fail;

public class TestLike extends BaseTest {
    FeedPage feedPage;
    private int index = -1;

    @Test
    public void testLike() {
        feedPage = new FeedPage();

        ElementsCollection collectionLikes = feedPage.collectionLikes();

        if (collectionLikes.isEmpty()) {
            fail("На странице нет неактивных лайков");
            return;
        }

        int elementsToCheck = Math.min(10, collectionLikes.size());
        for (int i = 0; i < elementsToCheck; i++) {
            if (!feedPage.collectionLikeStatusElementActive(i)) {
                feedPage.collectionLikeStatusElementClick(i);
                index = i;
                break;
            }
        }

        feedPage.collectionLikeShouldHaveLike(index);

        if (index == -1) {
            fail("Не найдено не активных лайков");
        }
    }

    @AfterEach
        public void deleteLikes() {
        feedPage.collectionLikeStatusElementClick(index);
        }
}
