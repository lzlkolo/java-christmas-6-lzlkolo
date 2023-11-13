package christmas.event;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ChristmasEvent implements Event {
    private static final String EVENT_NAME = "크리스마스 디데이 할인";
    private final LocalDate visitDate;

    public ChristmasEvent(LocalDate visitDate) {
        this.visitDate = visitDate;
    }

    @Override
    public String getEventName() {
        return EVENT_NAME;
    }

    @Override
    public int calculateDiscount() {
        LocalDate eventStartDate = LocalDate.of(2023, 12, 1);

        int daysDifference = calculateDaysDifference(eventStartDate, visitDate);
        int discount = Math.max(0, 1000 + (daysDifference * 100));

        return discount;
    }

    private static int calculateDaysDifference(LocalDate eventStartDate, LocalDate targetDate) {
        return (int) ChronoUnit.DAYS.between(eventStartDate, targetDate);
    }
}
