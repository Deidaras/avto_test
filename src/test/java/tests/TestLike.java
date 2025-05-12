package tests;

import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import pages.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.fail;

public class TestLike extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(TestLike.class);
    FeedPage feedPage;
    private int index = -1;

    @Test
    public void testLike() {
        logger.info("Запуск теста TestLike, загрузка FeedPage");
        feedPage = new FeedPage().get();

        logger.info("Создание коллекции лайков");
        ElementsCollection collectionLikes = feedPage.collectionLikes();

        if (collectionLikes.isEmpty()) {
            logger.error("На странице нет неактивных лайков - тест не может быть выполнен");
            fail("На странице нет неактивных лайков");
            return;
        }

        index = feedPage.findAndClickFirstInactiveLike(10);

        if (index == -1) {
            logger.error("Не найдено неактивных лайков среди элементов");
            fail("Не найдено не активных лайков");
        }

        logger.debug("Проверяем, что лайк #{} теперь активен", index);
        feedPage.collectionShouldBeActive(index);
        logger.info("Тест testLike успешно завершен");
    }

    @AfterEach
        public void deleteLikes() {
            if (index != -1) {
                logger.info("Удаляем лайк #{} в блоке @AfterEach", index);
                feedPage.collectionLikeClick(index);
            } else {
                logger.warn("Нет лайков для удаления (index = -1)");
            }
        }
}
