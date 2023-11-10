package christmas.event;

import christmas.domain.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ChristmasEventTest {
    Map<String, Integer> orderItems = new HashMap<>(Map.of("크리스마스파스타", 1));

    @DisplayName("크리스마스 할인 이벤트")
    @ParameterizedTest
    @CsvSource({
            "2023-12-01, 1000",
            "2023-12-10, 1900",
            "2023-12-25, 3400"
    })
    public void christmasEventTest(String visitDateStringFormat, int expectedDiscountAmount) {
        LocalDate visitDate = LocalDate.parse(visitDateStringFormat);
        ChristmasEvent christmasEvent = new ChristmasEvent(visitDate);

        Order order = new Order(orderItems);

        int discountAmount = christmasEvent.calculateDiscount(order);
        assertEquals(discountAmount, expectedDiscountAmount);
    }
}