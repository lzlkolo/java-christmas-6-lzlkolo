package christmas.event;

import christmas.domain.Badge;
import christmas.domain.Order;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class EventPlanner {
    private static final int ELIGIBLE_ORDER_AMOUNT = 120000;
    private static final int GIFT_PRICE = 25000;
    private static final List<Integer> SPECIAL_DATES = List.of(3, 10, 17, 24, 25, 31);

    private final List<Event> events = new ArrayList<>();
    private final LocalDate visitDate;
    private final Order order;
    private final int totalOrderPrice;

    public EventPlanner(LocalDate visitDate, Order order, int totalOrderPrice) {
        this.visitDate = visitDate;
        this.order = order;
        this.totalOrderPrice = totalOrderPrice;
        initializeEvents();
    }

    public Map<String, Integer> applyEvents() {
        Map<String, Integer> appliedEvents = new LinkedHashMap<>();

        for (Event event : events) {
            String eventName = event.getEventName();
            int discount = event.calculateDiscount();
            if (discount > 0) {
                appliedEvents.put(eventName, discount);
            }
        }

        return appliedEvents;
    }

    public int calculateTotalDiscount(Map<String, Integer> appliedEvents) {
        int totalDiscount = 0;

        for (Map.Entry<String, Integer> event : appliedEvents.entrySet()) {
            totalDiscount += event.getValue();
        }

        return totalDiscount;
    }

    public int calculatePaymentPrice(int totalOrderPrice, int totalDiscount, boolean hasGiftEvent) {
        int giftPrice = 0;

        if (hasGiftEvent) {
            giftPrice = GIFT_PRICE;
        }

        return totalOrderPrice - totalDiscount + giftPrice;
    }

    public String awardBadge(int totalDiscount) {
        BadgeManager badgeManager = new BadgeManager();
        Badge badge = badgeManager.getBadge(totalDiscount);
        return badge.getBadge();
    }

    public boolean hasGiftEvent() {
        for (Event event : events) {
            if (event instanceof GiftEvent) {
                return true;
            }
        }
        return false;
    }

    private List<Event> initializeEvents() {
        addChristmasEvent();
        addWeekdayEvent();
        addWeekendEvent();
        addSpecialEvent();
        addGiftEvent();
        return events;
    }

    private void addChristmasEvent() {
        events.add(new ChristmasEvent(visitDate));
    }

    private void addWeekdayEvent() {
        if (isWeekday(visitDate)) {
            events.add(new WeekdayEvent(order));
        }
    }

    private void addWeekendEvent() {
        if (isWeekend(visitDate)) {
            events.add(new WeekendEvent(order));
        }
    }

    private void addSpecialEvent() {
        if (isSpecialDate(visitDate)) {
            events.add(new SpecialEvent());
        }
    }

    private void addGiftEvent() {
        if (isEligibleForGift()) {
            events.add(new GiftEvent());
        }
    }

    private boolean isWeekday(LocalDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek != DayOfWeek.FRIDAY && dayOfWeek != DayOfWeek.SATURDAY;
    }

    private boolean isWeekend(LocalDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY;
    }

    private boolean isSpecialDate(LocalDate date) {
        return SPECIAL_DATES.contains(date.getDayOfMonth());
    }

    private boolean isEligibleForGift() {
        return totalOrderPrice >= ELIGIBLE_ORDER_AMOUNT;
    }
}
