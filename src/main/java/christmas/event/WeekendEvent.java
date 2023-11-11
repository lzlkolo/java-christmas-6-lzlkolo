package christmas.event;

import christmas.domain.Order;

public class WeekendEvent implements Event{
    private final static int DISCOUNT_PRICE = 2023;
    private final static String DISCOUNT_CATEGORY = "메인";

    @Override
    public int calculateDiscount(Order order) {
        int dessertQuantity = order.getCategoryQuantity(DISCOUNT_CATEGORY);
        int discount = dessertQuantity * DISCOUNT_PRICE;

        return discount;
    }
}
