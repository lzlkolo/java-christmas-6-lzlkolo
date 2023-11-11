package christmas.event;

import christmas.domain.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static java.util.Map.entry;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeekendEventTest {

    @Test
    @DisplayName("주말 할인 이벤트 - 메인 메뉴가 있는 경우")
    public void weekendEventWithMainTest() {
        Map<String, Integer> orderItems = Map.ofEntries(
                entry("크리스마스파스타", 1),
                entry("초코케이크", 2)
        );

        Order order = new Order(orderItems);
        WeekendEvent weekendEvent = new WeekendEvent(order);

        int actualDiscountPrice = weekendEvent.calculateDiscount();
        int expectedDiscountPrice = 2023;

        assertEquals(expectedDiscountPrice, actualDiscountPrice);
    }

    @Test
    @DisplayName("주말 할인 이벤트 - 메인 메뉴가 없는 경우")
    public void weekendEventWithoutMainTest() {
        Map<String, Integer> orderItems = Map.ofEntries(
                entry("초코케이크", 1),
                entry("레드와인", 2)
        );

        Order order = new Order(orderItems);
        WeekendEvent weekendEvent = new WeekendEvent(order);

        int actualDiscountPrice = weekendEvent.calculateDiscount();
        int expectedDiscountPrice = 0;

        assertEquals(expectedDiscountPrice, actualDiscountPrice);
    }
}

