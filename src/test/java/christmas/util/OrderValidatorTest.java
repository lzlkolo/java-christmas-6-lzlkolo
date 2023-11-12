package christmas.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static java.util.Map.entry;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class OrderValidatorTest {
    private OrderValidator orderValidator;

    @BeforeEach
    void setUp() {
        orderValidator = new OrderValidator();
    }

    @DisplayName("주문 정상 테스트")
    @Test
    void validOrder() {
        Map<String, Integer> orderItems = Map.ofEntries(
                entry("초코케이크", 1),
                entry("레드와인", 2)
        );
        assertDoesNotThrow(() -> orderValidator.validateOrder(orderItems));
    }

    @DisplayName("주문 예외 테스트 - 메뉴에 없는 메뉴를 주문한 경우")
    @Test
    void orderByMenuExistence() {
        Map<String, Integer> orderItems = Map.ofEntries(
                entry("딸기케이크", 1)
        );

        assertThatThrownBy(() -> orderValidator.validateOrder(orderItems))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("주문 예외 테스트 - 음료만 주문한 경우")
    @Test
    void orderByOnlyBeverage() {
        Map<String, Integer> orderItems = Map.ofEntries(
                entry("레드와인", 1)
        );

        assertThatThrownBy(() -> orderValidator.validateOrder(orderItems))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("주문 예외 테스트 - 개별 메뉴 개수가 20개 초과하는 경우")
    @Test
    void orderByEachMenuQuantityOutOfRange() {
        Map<String, Integer> orderItems = Map.ofEntries(
                entry("딸기케이크", 21)
        );

        assertThatThrownBy(() -> orderValidator.validateOrder(orderItems))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("주문 예외 테스트 - 전체 메뉴 개수가 20개 초과하는 경우")
    @Test
    void orderByTotalMenuQuantityOutOfRange() {
        Map<String, Integer> orderItems = Map.ofEntries(
                entry("딸기케이크", 1),
                entry("레드와인", 20)
        );

        assertThatThrownBy(() -> orderValidator.validateOrder(orderItems))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
