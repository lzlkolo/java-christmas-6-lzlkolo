package christmas.event;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GiftEventTest {
    @DisplayName("증정 이벤트")
    @Test
    public void GiftEventTest() {
        GiftEvent giftEvent = new GiftEvent();

        int actualDiscountPrice = giftEvent.calculateDiscount();
        int expectedDiscountPrice = 25000;

        assertEquals(expectedDiscountPrice, actualDiscountPrice);
    }
}
