package christmas.event;

import christmas.domain.Order;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EventPlanner {
    private final LocalDate visitDate;
    private final Order order;

    public EventPlanner(LocalDate visitDate, Order order) {
        this.visitDate = visitDate;
        this.order = order;
    }

    public int calculateTotalDiscount() {
        int totalDiscount = 0;
        List<Event> events = addEventsByCondition();

        for (Event event : events) {
            totalDiscount += event.calculateDiscount(order);
        }

        return totalDiscount;
    }

    private List<Event> addEventsByCondition() {
        List<Event> events = new ArrayList<>();

        return events;
    }
}
