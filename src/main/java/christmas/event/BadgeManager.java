package christmas.event;

import christmas.domain.Badge;

public class BadgeManager {
    public Badge getBadge(int totalDiscount) {
        return Badge.getBadgeByTotalDiscount(totalDiscount);
    }
}
