package christmas.ui;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    InputValidator inputValidator = new InputValidator();

    public int getVisitDate() throws IllegalArgumentException {
        String input = Console.readLine();
        int visitDate = inputValidator.validateDate(input);

        return visitDate;
    }
}
