package tests;

import org.junit.jupiter.api.Test;
import pages.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestUnlike extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(TestLike.class);

    @Test
    public void testUnlike() {
        logger.info("Запуск TestUnlike, загрузка FeedPage");
        FeedPage feedPage = new FeedPage().get();

        logger.info("Проверка активности первого лайка и деактивация при необходимости");
        feedPage.firstLikeCheckAndDeactivate();
        logger.info("Активация лайка и проверка его активности");
        feedPage.collectionLikeClick(0);
        feedPage.collectionShouldBeActive(0);

        logger.info("Клик на лайк и проверка, что он неактивен");
        feedPage.collectionLikeClick(0);
        feedPage.collectionShouldNotBeActive(0);
    }
}

