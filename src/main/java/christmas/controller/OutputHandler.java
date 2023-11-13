package christmas.controller;

import christmas.event.EventPlanner;
import christmas.ui.OutputMessage;
import christmas.ui.OutputView;

import java.util.Map;

public class OutputHandler {
    private final OutputView outputView;

    public OutputHandler(OutputView outputView) {
        this.outputView = outputView;
    }

    public void displayWelcomeMessage() {
        outputView.displayMessage(OutputMessage.WELCOME_MESSAGE.getMessage());
    }

    public void displayPreviewMessage(int dayOfMonth) {
        String date = dateFormat(dayOfMonth);
        outputView.displayMessage(date + OutputMessage.PREVIEW_MESSAGE.getMessage());
    }

    public void displayOrderDetails(Map<String, Integer> orderItems, int totalOrderPrice) {
        outputView.displayOrder(orderItems);
        outputView.displayTotalOrderPrice(totalOrderPrice);
    }

    public void displayEventDetails(boolean hasGiftEvent, Map<String, Integer> appliedEvents, int totalDiscount) {
        outputView.displayGiftEvent(hasGiftEvent);
        outputView.displayEventPreview(appliedEvents);
        outputView.displayTotalDiscount(totalDiscount);
    }

    public void displayPaymentPrice(int paymentPrice) {
        outputView.displayPaymentPrice(paymentPrice);
    }

    public void displayBadge(EventPlanner eventPlanner, int totalDiscount) {
        String badge = eventPlanner.awardBadge(totalDiscount);
        outputView.displayBadge(badge);
    }

    private String dateFormat(int dayOfMonth) {
        String date = String.format("12월 %d일", dayOfMonth);
        return date;
    }
}
