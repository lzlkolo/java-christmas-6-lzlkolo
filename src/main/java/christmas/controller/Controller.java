package christmas.controller;

import christmas.domain.Order;
import christmas.event.EventPlanner;

import java.time.LocalDate;
import java.time.Month;
import java.util.Map;

public class Controller {
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public Controller(InputHandler inputHandler, OutputHandler outputHandler) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    public void run() {
        outputHandler.displayWelcomeMessage();

        int dayOfMonth = inputHandler.getValidDate();
        Map<String, Integer> orderItems = inputHandler.getValidOrder();

        displayEventPreview(dayOfMonth, orderItems);
    }

    private void displayEventPreview(int dayOfMonth, Map<String, Integer> orderItems) {
        outputHandler.displayPreviewMessage(dayOfMonth);

        Order order = new Order(orderItems);
        int totalOrderPrice = order.calculateTotalPrice();
        outputHandler.displayOrderDetails(orderItems, totalOrderPrice);

        EventPlanner eventPlanner = createEventPlanner(dayOfMonth, order, totalOrderPrice);

        boolean hasGiftEvent = eventPlanner.hasGiftEvent();
        Map<String, Integer> appliedEvents = eventPlanner.applyEvents();
        int totalDiscount = eventPlanner.calculateTotalDiscount(appliedEvents);
        int paymentPrice = eventPlanner.calculatePaymentPrice(totalOrderPrice, totalDiscount, hasGiftEvent);

        outputHandler.displayEventDetails(hasGiftEvent, appliedEvents, totalDiscount);
        outputHandler.displayPaymentPrice(paymentPrice);
        outputHandler.displayBadge(eventPlanner, totalDiscount);
    }

    private EventPlanner createEventPlanner(int dayOfMonth, Order order, int totalPrice) {
        LocalDate visitDate = LocalDate.of(LocalDate.now().getYear(), Month.DECEMBER, dayOfMonth);
        return new EventPlanner(visitDate, order, totalPrice);
    }
}
