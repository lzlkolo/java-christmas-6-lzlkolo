package christmas.event;

public class GiftEvent implements Event {
    private final static int DISCOUNT_PRICE = 25000;

    @Override
    public int calculateDiscount() {
        return DISCOUNT_PRICE;
    }
}
