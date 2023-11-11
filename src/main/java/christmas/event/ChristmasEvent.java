package christmas.event;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ChristmasEvent implements Event {
    private final LocalDate visitDate;

    public ChristmasEvent(LocalDate visitDate) {
        this.visitDate = visitDate;
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
