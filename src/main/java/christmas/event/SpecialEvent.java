package christmas.event;

import christmas.domain.Order;

public class SpecialEvent implements Event {
    private final static int DISCOUNT_PRICE = 1000;

    @Override
    public int calculateDiscount(Order order) {
        return DISCOUNT_PRICE;
    }
}
