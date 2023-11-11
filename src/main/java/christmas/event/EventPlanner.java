package christmas.event;

import christmas.domain.Order;

import java.time.DayOfWeek;
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
        events.add(new ChristmasEvent(visitDate));

        if (isWeekday(visitDate)) {
            events.add(new WeekdayEvent());
        }
        if (isWeekend(visitDate)) {
            events.add(new WeekendEvent());
        }
        if (isSpecialDate(visitDate)) {
            events.add(new SpecialEvent());
        }
        return events;
    }

    private boolean isWeekday(LocalDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek != DayOfWeek.SATURDAY && dayOfWeek != DayOfWeek.SUNDAY;
    }

    private boolean isWeekend(LocalDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
    }

    private boolean isSpecialDate(LocalDate date) {
        List<Integer> specialDates = new ArrayList<>(List.of(3, 10, 17, 24, 25, 31));
        return specialDates.contains(date.getDayOfMonth());
    }
}
