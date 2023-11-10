package christmas.domain;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private Map<String, Integer> orderItems;

    public Order(Map<String, Integer> orderItems) {
        this.orderItems = new HashMap<>(orderItems);
    }
}
