package christmas.event;

public class SpecialEvent implements Event {
    private static final int DISCOUNT_PRICE = 1000;
    private static final String EVENT_NAME = "특별 할인";

    @Override
    public String getEventName() {
        return EVENT_NAME;
    }

    @Override
    public int calculateDiscount() {
        return DISCOUNT_PRICE;
    }
}
