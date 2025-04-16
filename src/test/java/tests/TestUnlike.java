package tests;

import org.junit.jupiter.api.Test;
import pages.*;

public class TestUnlike extends BaseTest {

    @Test
    public void testLike() {
        FeedPage feedPage = new FeedPage();

        if (!feedPage.activeLikeStatusFirstNews()) {
            feedPage.firstNewsClick();
            feedPage.statusLike(feedPage.firstNews());
        }
        feedPage.firstNewsClick();
        feedPage.statusLike(feedPage.firstNews());
    }
}

