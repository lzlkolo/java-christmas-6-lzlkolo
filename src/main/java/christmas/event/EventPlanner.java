package christmas.event;

import christmas.domain.Order;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EventPlanner {
    private final static List<Integer> SPECIAL_DATES = List.of(3, 10, 17, 24, 25, 31);

    private final LocalDate visitDate;
    private final Order order;
    private final List<Event> events;

    public EventPlanner(LocalDate visitDate, Order order) {
        this.visitDate = visitDate;
        this.order = order;
        this.events = initializeEvents();
    }

    public int calculateTotalDiscount() {
        int totalDiscount = 0;
        List<Event> events = initializeEvents();

        for (Event event : events) {
            totalDiscount += event.calculateDiscount(order);
        }

        return totalDiscount;
    }

    private List<Event> initializeEvents() {
        List<Event> events = new ArrayList<>();
        events.add(new ChristmasEvent(visitDate));
        addWeekdayEvent();
        addWeekendEvent();
        addSpecialEvent();
        return events;
    }

    private void addWeekdayEvent() {
        if (isWeekday(visitDate)) {
            events.add(new WeekdayEvent());
        }
    }

    private void addWeekendEvent() {
        if (isWeekend(visitDate)) {
            events.add(new WeekendEvent());
        }
    }

    private void addSpecialEvent() {
        if (isSpecialDate(visitDate)) {
            events.add(new SpecialEvent());
        }
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
        return SPECIAL_DATES.contains(date.getDayOfMonth());
    }
}
