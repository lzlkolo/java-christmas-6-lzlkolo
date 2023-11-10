package christmas.event;

import christmas.domain.Order;

public interface Event {
    int calculateDiscount(Order order);
}