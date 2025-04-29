package tests;

import org.junit.jupiter.api.Test;
import pages.*;

public class TestUnlike extends BaseTest {

    @Test
    public void testUnlike() {
        FeedPage feedPage = new FeedPage();

        feedPage.firstLikeCheck();
        feedPage.firstLikeClick();
        feedPage.firstLikeStatusCheck();

        feedPage.firstLikeClick();
        feedPage.firstUnlikeStatusCheck();
    }
}

