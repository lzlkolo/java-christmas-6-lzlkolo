package christmas.domain;

public enum Badge {
    NO_BADGE("없음", 0, 0),
    STAR("별", 5000, 9999),
    TREE("트리", 10000, 19999),
    SANTA("산타", 20000, Integer.MAX_VALUE);

    private final String badgeName;
    private final int minPrice;
    private final int maxPrice;

    Badge(String badgeName, int minPrice, int maxPrice) {
        this.badgeName = badgeName;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    public static Badge getBadgeByTotalDiscount(int totalDiscount) {
        for (Badge badge : values()) {
            if (totalDiscount >= badge.minPrice && totalDiscount <= badge.maxPrice) {
                return badge;
            }
        }
        return NO_BADGE;
    }
}
