package christmas.event;

public class SpecialEvent implements Event {
    private final static int DISCOUNT_PRICE = 1000;

    @Override
    public int calculateDiscount() {
        return DISCOUNT_PRICE;
    }
}
