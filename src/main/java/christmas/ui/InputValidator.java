package christmas.ui;

import java.util.HashMap;
import java.util.Map;

public class InputValidator {
    private static final int FIRST_DAY_OF_MONTH = 1;
    private static final int LAST_DAY_OF_MONTH = 31;

    public int validateDateInput(String input) throws IllegalArgumentException {
        try {
            int visitDate = Integer.parseInt(input);

            if (!checkRange(visitDate)) {
                throw new IllegalArgumentException(ErrorMessage.DATE_ERROR.getMessage());
            }

            return visitDate;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.DATE_ERROR.getMessage());
        }
    }

    private boolean checkRange(int visitDate) {
        return visitDate >= FIRST_DAY_OF_MONTH && visitDate <= LAST_DAY_OF_MONTH;
    }

    public Map<String, Integer> validateOrderInput(String input) throws IllegalArgumentException {
        Map<String, Integer> orderItems = orderParser(input);
        return orderItems;
    }

    private Map<String, Integer> orderParser(String input) throws IllegalArgumentException {
        Map<String, Integer> orderItems = new HashMap<>();

        String[] orderItem = input.split(",");

        for (String orderLine : orderItem) {
            String[] orderToken = orderLine.split("-");
            parseAndAddOrderItem(orderItems, orderToken);
        }

        if (orderItem.length != orderItems.size()) {
            throw new IllegalArgumentException(ErrorMessage.ORDER_ERROR.getMessage());
        }

        return orderItems;
    }

    private void parseAndAddOrderItem(Map<String, Integer> orderItems, String[] orderToken) throws IllegalArgumentException {
        try {
            validateInputFormat(orderToken);

            String menuName = orderToken[0];
            validateMenuName(menuName);

            int quantity = Integer.parseInt(orderToken[1]);
            validateQuantity(quantity);

            orderItems.put(menuName, quantity);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ORDER_ERROR.getMessage());
        }
    }

    private void validateInputFormat(String[] parts) throws IllegalArgumentException {
        if (parts.length != 2) {
            throw new IllegalArgumentException(ErrorMessage.ORDER_ERROR.getMessage());
        }
    }

    private void validateMenuName(String menuName) throws IllegalArgumentException {
        if (!menuName.matches("^[가-힣]*$")) {
            throw new IllegalArgumentException(ErrorMessage.ORDER_ERROR.getMessage());
        }
    }

    private void validateQuantity(int quantity) throws IllegalArgumentException {
        if (quantity < 1) {
            throw new IllegalArgumentException(ErrorMessage.ORDER_ERROR.getMessage());
        }
    }
}
