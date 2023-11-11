package christmas;

import christmas.domain.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderTest {
    @DisplayName("카테고리 개수 계산 테스트")
    @Test
    public void orderTestByGetCategory() {
        Order order = new Order(Map.of("크리스마스파스타", 1));

        int actualQuantity = order.getCategoryQuantity("메인");
        int expectedQuantity = 1;

        assertEquals(expectedQuantity, actualQuantity);
    }

    @DisplayName("총주문 금액 계산 테스트")
    @Test
    public void orderTestByGetTotalPrice() {
        Order order = new Order(Map.of("크리스마스파스타", 1));

        int actualPrice = order.calculateTotalPrice();
        int expectedPrice = 25000;

        assertEquals(expectedPrice, actualPrice);
    }
}