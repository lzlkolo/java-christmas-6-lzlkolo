package christmas.event;

import christmas.domain.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static java.util.Map.entry;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeekdayEventTest {


    @Test
    @DisplayName("평일 할인 이벤트 - 디저트 메뉴가 있는 경우")
    public void weekdayEventWithDessertTest() {
        WeekdayEvent weekdayEvent = new WeekdayEvent();

        Map<String, Integer> orderItems = Map.ofEntries(
                entry("크리스마스파스타", 1),
                entry("초코케이크", 2)
        );

        Order order = new Order(orderItems);

        int actualDiscountPrice = weekdayEvent.calculateDiscount(order);
        int expectedDiscountPrice = 4046;

        assertEquals(expectedDiscountPrice, actualDiscountPrice);
    }

    @Test
    @DisplayName("평일 할인 이벤트 - 디저트 메뉴가 없는 경우")
    public void weekdayEventWithoutDessertTest() {
        WeekdayEvent weekdayEvent = new WeekdayEvent();

        Map<String, Integer> orderItems = Map.ofEntries(
                entry("크리스마스파스타", 1),
                entry("레드와인", 2)
        );

        Order order = new Order(orderItems);

        int actualDiscountPrice = weekdayEvent.calculateDiscount(order);
        int expectedDiscountPrice = 0;

        assertEquals(expectedDiscountPrice, actualDiscountPrice);
    }
}
