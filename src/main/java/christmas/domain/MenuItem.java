package christmas.domain;

public enum MenuItem {

    MUSHROOM_SOUP("애피타이저", "양송이수프", 6000),
    TAPAS("애피타이저", "타파스", 5500),
    CAESAR_SALAD("애피타이저", "시저샐러드", 8000),

    STEAK("메인", "티본스테이크", 55000),
    BBQ_RIB("메인", "바비큐립", 54000),
    SEAFOOD_PASTA("메인", "해산물파스타", 35000),
    CHRISTMAS_PASTA("메인", "크리스마스파스타", 25000),

    CHOCO_CAKE("디저트", "초코케이크", 15000),
    ICE_CREAM("디저트", "아이스크림", 5000),

    ZERO_COKE("음료", "제로콜라", 3000),
    RED_WINE("음료", "레드와인", 60000),
    CHAMPAGNE("음료", "샴페인", 25000);

    private final String category;
    private final String name;
    private final int price;

    MenuItem(String category, String name, int price) {
        this.category = category;
        this.name = name;
        this.price = price;
    }

    public static String getCategoryByName(String menuName) {
        for (MenuItem menuItem : values()) {
            if (menuItem.name.equals(menuName)) {
                return menuItem.category;
            }
        }
        return null;
    }

    public static int getPriceByName(String menuName) {
        for (MenuItem menuItem : values()) {
            if (menuItem.name.equals(menuName)) {
                return menuItem.price;
            }
        }
        return 0;
    }
}
