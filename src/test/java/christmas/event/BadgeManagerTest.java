package christmas.event;

import christmas.domain.Badge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BadgeManagerTest {
    @DisplayName("총할인 금액에 따른 배지 부여 테스트")
    @ParameterizedTest
    @CsvSource({
            "4999, 없음",
            "5000, 별",
            "9999, 별",
            "10000, 트리",
            "19999, 트리",
            "20000, 산타"
    })
    public void awardBadgeTest(int totalDiscount, String expectedBadge) {
        BadgeManager badgeManager = new BadgeManager();
        Badge badge = badgeManager.getBadge(totalDiscount);

        String actualBadge = badge.getBadge();

        assertEquals(expectedBadge, actualBadge);
    }
}
