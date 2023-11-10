package christmas.event;

import christmas.domain.Order;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ChristmasEvent implements Event {
    private final LocalDate visitDate;

    public ChristmasEvent(LocalDate visitDate) {
        this.visitDate = visitDate;
    }

    @Override
    public int calculateDiscount(Order order) {
        LocalDate eventStartDate = LocalDate.of(2023, 12, 1);

        int daysDifference = calculateDaysDifference(eventStartDate, visitDate);
        int discountPrice = calculateDiscountPrice(daysDifference);

        return discountPrice;
    }

    private static int calculateDaysDifference(LocalDate eventStartDate, LocalDate targetDate) {
        return (int) ChronoUnit.DAYS.between(eventStartDate, targetDate);
    }

    private static int calculateDiscountPrice(int daysDifference) {
        return Math.max(0, 1000 + (daysDifference * 100));
    }
}
