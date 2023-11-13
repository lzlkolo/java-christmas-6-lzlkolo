package christmas.event;

import christmas.domain.Order;

public class WeekendEvent implements Event{
    private static final int DISCOUNT_PRICE = 2023;
    private static final String DISCOUNT_CATEGORY = "메인";
    private static final String EVENT_NAME = "주말 할인";
    private final Order order;

    public WeekendEvent(Order order) {
        this.order = order;
    }

    @Override
    public String getEventName() {
        return EVENT_NAME;
    }

    @Override
    public int calculateDiscount() {
        int mainQuantity = order.getCategoryQuantity(DISCOUNT_CATEGORY);
        int discount = mainQuantity * DISCOUNT_PRICE;

        return discount;
    }
}
