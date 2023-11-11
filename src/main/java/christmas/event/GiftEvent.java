package christmas.event;

import christmas.domain.Order;

public class GiftEvent implements Event {
    private final static int DISCOUNT_PRICE = 25000;

    @Override
    public int calculateDiscount(Order order) {
        return DISCOUNT_PRICE;
    }
}
