package christmas;

import christmas.controller.Controller;
import christmas.controller.InputHandler;
import christmas.controller.OutputHandler;
import christmas.ui.InputView;
import christmas.ui.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        InputHandler inputHandler = new InputHandler(inputView);
        OutputHandler outputHandler = new OutputHandler(outputView);

        Controller controller = new Controller(inputHandler, outputHandler);
        controller.run();
    }
}
