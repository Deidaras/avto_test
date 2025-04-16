package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.FeedPage;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TestLogin extends BaseTest {
    private static final String expectedUsername = "technopol42 technopol42";

    private static final String feedMenuRus = "Лента";
    private static final String hobbyMenuRus = "Увлечения";
    private static final String friendMenuRus = "Друзья";
    private static final String photoMenuRus = "Фото";
    private static final String groupMenuRus = "Группы";
    private static final String gamesMenuRus = "Игры";
    private static final String giftsMenuRus = "Подарки";
    private static final String recommendMenuRus = "Рекомендации";
    private static final String appsMenuRus = "Приложения";
    private static final String datingMenuRus = "Знакомства в ОК";

    @DisplayName("Login Test")
    @Test
    public void testSuccessfulLogin() {
        FeedPage feedPage = new FeedPage();

        assertAll("Menu",
                // check user's name
                () -> assertEquals(expectedUsername, feedPage.userNameGetText()),
                // check visible first news
                feedPage::firstNewsVisible,
                // check menu buttons
                () -> assertEquals(feedMenuRus, feedPage.feedButtonGetText()),
                () -> assertEquals(hobbyMenuRus, feedPage.hobbyButtonGetText()),
                () -> assertEquals(friendMenuRus, feedPage.friendButtonGetText()),
                () -> assertEquals(photoMenuRus, feedPage.photoButtonGetText()),
                () -> assertEquals(groupMenuRus, feedPage.groupButtonGetText()),
                () -> assertEquals(gamesMenuRus, feedPage.gamesButtonGetText()),
                () -> assertEquals(giftsMenuRus, feedPage.giftsButtonGetText()),
                () -> assertEquals(recommendMenuRus, feedPage.recommendButtonGetText()),
                () -> assertEquals(appsMenuRus, feedPage.appsButtonGetText()),
                () -> assertEquals(datingMenuRus, feedPage.datingButtonGetText())
        );

    }
}
