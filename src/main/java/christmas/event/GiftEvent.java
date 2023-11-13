package christmas.event;

public class GiftEvent implements Event {
    private static final int DISCOUNT_PRICE = 25000;
    private static final String EVENT_NAME = "증정 이벤트";

    @Override
    public String getEventName() {
        return EVENT_NAME;
    }

    @Override
    public int calculateDiscount() {
        return DISCOUNT_PRICE;
    }
}
