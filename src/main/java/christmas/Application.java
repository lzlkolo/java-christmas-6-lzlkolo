package christmas;

import christmas.controller.Controller;
import christmas.ui.InputView;
import christmas.ui.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        Controller controller = new Controller(inputView, outputView);
        controller.run();
    }
}
