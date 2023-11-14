package christmas.event;

import christmas.domain.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Map;

import static java.util.Map.entry;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EventPlannerTest {
    private LocalDate visitDate;
    private Order order;
    private int totalOrderPrice;
    private EventPlanner eventPlanner;

    @BeforeEach
    void setUp() {
        visitDate = LocalDate.of(2023, 12, 3);

        Map<String, Integer> orderItems = Map.ofEntries(
                entry("티본스테이크", 1),
                entry("바비큐립", 1),
                entry("초코케이크", 2),
                entry("제로콜라", 1)
        );

        order = new Order(orderItems);
        totalOrderPrice = order.calculateTotalPrice();
        eventPlanner = new EventPlanner(visitDate, order, totalOrderPrice);
    }

    @DisplayName("이벤트 적용 테스트")
    @Test
    void applyEventsTest() {
        Map<String, Integer> actualAppliedEvents = eventPlanner.applyEvents();

        Map<String, Integer> expectedAppliedEvents = Map.ofEntries(
                entry("크리스마스 디데이 할인", 1200),
                entry("평일 할인", 4046),
                entry("특별 할인", 1000),
                entry("증정 이벤트", 25000)
        );

        assertEquals(expectedAppliedEvents, actualAppliedEvents);
    }

    @DisplayName("할인 금액 계산 테스트")
    @Test
    void calculateTotalDiscountTest() {
        Map<String, Integer> appliedEvents = eventPlanner.applyEvents();
        int actualTotalDiscount = eventPlanner.calculateTotalDiscount(appliedEvents);
        int expectedTotalDiscount = 31246;

        assertEquals(expectedTotalDiscount, actualTotalDiscount);
    }

    @DisplayName("결제금액 계산 테스트")
    @Test
    void calculatePaymentPriceTest() {
        Map<String, Integer> appliedEvents = eventPlanner.applyEvents();
        int totalDiscount = eventPlanner.calculateTotalDiscount(appliedEvents);

        int actualPaymentPrice = eventPlanner.calculatePaymentPrice(totalOrderPrice, totalDiscount, eventPlanner.hasGiftEvent());
        int expectedPaymentPrice = 135754;

        assertEquals(expectedPaymentPrice, actualPaymentPrice);
    }

    @DisplayName("증정 이벤트 유무 확인 테스트")
    @Test
    void hasGiftEventTest() {
        boolean hasGiftEvent = eventPlanner.hasGiftEvent();

        assertTrue(hasGiftEvent, "GiftEvent가 예상대로 존재해야 합니다.");
    }
}
