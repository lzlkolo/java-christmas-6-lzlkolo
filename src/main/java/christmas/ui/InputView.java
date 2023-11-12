package christmas.ui;

import camp.nextstep.edu.missionutils.Console;

import java.util.Map;

public class InputView {
    InputValidator inputValidator = new InputValidator();

    public int getVisitDate() throws IllegalArgumentException {
        String input = Console.readLine();
        int visitDate = inputValidator.validateDateInput(input);

        return visitDate;
    }

    public Map<String, Integer> getOrder() throws IllegalArgumentException {
        String input = Console.readLine();
        Map<String, Integer> orderItems = inputValidator.validateOrderInput(input);

        return orderItems;
    }
}
