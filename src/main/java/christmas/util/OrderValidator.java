package christmas.util;

import christmas.domain.MenuItem;
import christmas.ui.ErrorMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderValidator {
    private final int MIN_QUANTITY = 1;
    private final int MAX_QUANTITY = 20;
    private final String BEVERAGE_CATEGORY = "음료";

    public void validateOrder(Map<String, Integer> orderItems) throws IllegalArgumentException {
        for (String menuName : orderItems.keySet()) {
            validateMenuExistence(menuName);
        }

        validateOnlyBeverage(orderItems);
        validateEachMenuQuantity(orderItems);
        validateTotalMenuQuantity(orderItems);
    }

    private void validateMenuExistence(String menuName) throws IllegalArgumentException{
        if (MenuItem.getCategoryByName(menuName) == null) {
            throw new IllegalArgumentException(ErrorMessage.ORDER_ERROR.getMessage());
        }
    }

    private void validateOnlyBeverage(Map<String, Integer> orderItems) throws IllegalArgumentException {
        List<String> category = new ArrayList<>();

        for (String menuName : orderItems.keySet()) {
            category.add(MenuItem.getCategoryByName(menuName));
        }

        if (category.size() == 1 && category.contains(BEVERAGE_CATEGORY)) {
            throw new IllegalArgumentException(ErrorMessage.ORDER_ERROR.getMessage());
        }
    }

    private void validateEachMenuQuantity(Map<String, Integer> orderItems) throws IllegalArgumentException {
        for (int quantity : orderItems.values()) {
            if (quantity < MIN_QUANTITY || quantity > MAX_QUANTITY) {
                throw new IllegalArgumentException(ErrorMessage.ORDER_ERROR.getMessage());
            }
        }
    }

    private void validateTotalMenuQuantity(Map<String, Integer> orderItems) throws IllegalArgumentException {
        int totalQuantity = orderItems.values().stream().mapToInt(Integer::intValue).sum();
        if (totalQuantity < MIN_QUANTITY || totalQuantity > MAX_QUANTITY) {
            throw new IllegalArgumentException(ErrorMessage.ORDER_ERROR.getMessage());
        }
    }
}
