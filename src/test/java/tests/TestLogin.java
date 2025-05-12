package tests;

import model.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.FeedPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.junit.jupiter.api.Assertions.*;

class TestLogin extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(TestLogin.class);

    private static final String expectedUsername = dotenv.get("EXPECTEDUSERNAME");

    Menu menu = new Menu(
            "Лента",
            "Увлечения",
            "Друзья",
            "Фото",
            "Группы",
            "Игры",
            "Подарки",
            "Рекомендации",
            "Приложения",
            "Знакомства в ОК"
            );

    @DisplayName("Login Test")
    @Test
    public void testSuccessfulLogin() {
        logger.info("Запуск теста входа, загрузка FeedPage");
        FeedPage feedPage = new FeedPage().get();

        logger.info("Проверка наличия имени пользователя в файле .env");
        assertNotNull(expectedUsername, "EXPECTEDUSERNAME не задан в .env");

        assertAll("Проверка страницы",
                () -> {
                    logger.info("Проверка имени пользователя");
                    assertEquals(expectedUsername, feedPage.userNameGetText());
                },
                () -> {
                    logger.info("Проверка соответствия меню");
                    assertAll("Пункты меню",
                            () -> {
                                Menu actualMenu = new Menu(
                                        feedPage.feedButtonGetText(),
                                        feedPage.hobbyButtonGetText(),
                                        feedPage.friendButtonGetText(),
                                        feedPage.photoButtonGetText(),
                                        feedPage.groupButtonGetText(),
                                        feedPage.gamesButtonGetText(),
                                        feedPage.giftsButtonGetText(),
                                        feedPage.recommendButtonGetText(),
                                        feedPage.appsButtonGetText(),
                                        feedPage.datingButtonGetText()
                                );
                                assertEquals(menu, actualMenu);
                            }

                    );
                }
        );

    }
}
