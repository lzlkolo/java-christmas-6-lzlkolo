package christmas.controller;

import christmas.domain.Order;
import christmas.event.EventPlanner;
import christmas.ui.InputView;
import christmas.ui.OutputMessage;
import christmas.ui.OutputView;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.displayMessage(OutputMessage.WELCOME_MESSAGE.getMessage());

        int dayOfMonth = getValidDate();
        Map<String, Integer> orderItems = getValidOrder();

        displayEventPreview(dayOfMonth, orderItems);
    }

    private int getValidDate() {
        int dayOfMonth = 0;
        boolean isValid = false;

        while (!isValid) {
            try {
                dayOfMonth = inputView.getVisitDate();
                isValid = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return dayOfMonth;
    }

    private Map<String, Integer> getValidOrder() {
        Map<String, Integer> orderItems = new HashMap<>();
        boolean isValid = false;

        while (!isValid) {
            try {
                orderItems = inputView.getOrder();
                isValid = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return orderItems;
    }

    private void displayEventPreview(int dayOfMonth, Map<String, Integer> orderItems) {
        String date = createDate(dayOfMonth);
        outputView.displayMessage(date + OutputMessage.PREVIEW_MESSAGE.getMessage());

        outputView.displayOrder(orderItems);

        Order order = new Order(orderItems);
        int totalOrderPrice = order.calculateTotalPrice();
        outputView.displayTotalOrderPrice(totalOrderPrice);

        LocalDate visitDate = LocalDate.of(LocalDate.now().getYear(), Month.DECEMBER, dayOfMonth);
        EventPlanner eventPlanner = new EventPlanner(visitDate, order, totalOrderPrice);

        displayEventDetails(eventPlanner, totalOrderPrice);
    }

    private void displayEventDetails(EventPlanner eventPlanner, int totalOrderPrice) {
        boolean hasGiftEvent = eventPlanner.hasGiftEvent();
        outputView.displayGiftEvent(hasGiftEvent);

        Map<String, Integer> appliedEvents = eventPlanner.applyEvents();
        outputView.displayEventPreview(appliedEvents);

        int totalDiscount = eventPlanner.calculateTotalDiscount(appliedEvents);
        outputView.displayTotalDiscount(totalDiscount);

        int paymentPrice = totalOrderPrice - totalDiscount;

        if (hasGiftEvent) {
            paymentPrice = totalOrderPrice - totalDiscount + 25000;
        }
        outputView.displayPaymentPrice(paymentPrice);

        displayBadge(eventPlanner, totalDiscount);
    }

    private void displayBadge(EventPlanner eventPlanner, int totalDiscount) {
        String badge = eventPlanner.awardBadge(totalDiscount);
        outputView.displayBadge(badge);
    }

    private String createDate(int dayOfMonth) {
        return String.format("12월 %d일", dayOfMonth);
    }
}
