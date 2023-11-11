package christmas.event;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpecialEventTest {
    @DisplayName("특별 할인 이벤트")
    @Test
    public void specialEventTest() {
        SpecialEvent specialEvent = new SpecialEvent();

        int actualDiscountPrice = specialEvent.calculateDiscount();
        int expectedDiscountPrice = 1000;

        assertEquals(expectedDiscountPrice, actualDiscountPrice);
    }
}
