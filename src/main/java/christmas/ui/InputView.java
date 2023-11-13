package christmas.ui;

import camp.nextstep.edu.missionutils.Console;

import java.util.Map;

public class InputView {
    InputValidator inputValidator = new InputValidator();
    OutputView outputView = new OutputView();

    public int getVisitDate() throws IllegalArgumentException {
        outputView.displayMessage(OutputMessage.ASK_VISIT_DATE_MESSAGE.getMessage());
        String input = Console.readLine();
        int visitDate = inputValidator.validateDateInput(input);

        return visitDate;
    }

    public Map<String, Integer> getOrder() throws IllegalArgumentException {
        outputView.displayMessage(OutputMessage.ASK_ORDER_MESSAGE.getMessage());
        String input = Console.readLine();
        Map<String, Integer> orderItems = inputValidator.validateOrderInput(input);

        return orderItems;
    }
}
