package christmas.domain;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private Map<String, Integer> orderItems;

    public Order(Map<String, Integer> orderItems) {
        this.orderItems = new HashMap<>(orderItems);
    }

    public int getCategoryQuantity(String category) {
        return orderItems.entrySet()
                .stream()
                .filter(entry -> MenuItem.getCategoryByName(entry.getKey()).equals(category))
                .mapToInt(Map.Entry::getValue)
                .sum();
    }
}
