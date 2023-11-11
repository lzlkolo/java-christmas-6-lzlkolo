package christmas.event;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ChristmasEventTest {
    @DisplayName("크리스마스 할인 이벤트")
    @ParameterizedTest
    @CsvSource({
            "2023-12-01, 1000",
            "2023-12-10, 1900",
            "2023-12-25, 3400"
    })
    public void christmasEventTest(String visitDateStringFormat, int expectedDiscountPrice) {
        LocalDate visitDate = LocalDate.parse(visitDateStringFormat);
        ChristmasEvent christmasEvent = new ChristmasEvent(visitDate);

        int actualDiscountPrice = christmasEvent.calculateDiscount();

        assertEquals(expectedDiscountPrice, actualDiscountPrice);
    }
}