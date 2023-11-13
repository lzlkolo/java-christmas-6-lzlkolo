package christmas.event;

import christmas.domain.Order;

public class WeekdayEvent implements Event {
    private final static int DISCOUNT_PRICE = 2023;
    private final static String DISCOUNT_CATEGORY = "디저트";
    private final static String EVENT_NAME = "평일 할인";
    private final Order order;

    public WeekdayEvent(Order order) {
        this.order = order;
    }

    @Override
    public String getEventName() {
        return EVENT_NAME;
    }

    @Override
    public int calculateDiscount() {
        int dessertQuantity = order.getCategoryQuantity(DISCOUNT_CATEGORY);
        int discount = dessertQuantity * DISCOUNT_PRICE;

        return discount;
    }
}
