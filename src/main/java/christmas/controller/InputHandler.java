package christmas.controller;

import christmas.ui.InputView;

import java.util.HashMap;
import java.util.Map;

public class InputHandler {
    private final InputView inputView;

    public InputHandler(InputView inputView) {
        this.inputView = inputView;
    }

    public int getValidDate() {
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

    public Map<String, Integer> getValidOrder() {
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
}
