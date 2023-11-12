package christmas.ui;

public class InputValidator {
    private static final int FIRST_DAY_OF_MONTH = 1;
    private static final int LAST_DAY_OF_MONTH = 31;

    public int validateDate(String input) throws IllegalArgumentException {
        try {
            int visitDate = Integer.parseInt(input);

            if (!checkRange(visitDate)) {
                throw new IllegalArgumentException(ErrorMessage.DATE_ERROR.getMessage());
            }

            return visitDate;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.DATE_ERROR.getMessage());
        }
    }

    private boolean checkRange(int visitDate) {
        return visitDate >= FIRST_DAY_OF_MONTH && visitDate <= LAST_DAY_OF_MONTH;
    }
}
