package christmas.event;

import christmas.domain.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpecialEventTest {
    @DisplayName("특별 할인 이벤트")
    @Test
    public void specialEventTest() {
        SpecialEvent specialEvent = new SpecialEvent();
        Order order = new Order(Map.of("크리스마스파스타", 1));

        int actualDiscountPrice = specialEvent.calculateDiscount(order);
        int expectedDiscountPrice = 1000;

        assertEquals(expectedDiscountPrice, actualDiscountPrice);
    }
}
