package christmas.ui;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

import static java.util.Map.entry;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputViewTest {
    InputView inputView;

    @BeforeEach
    public void setUp() {
        inputView = new InputView();
    }

    @DisplayName("방문 날짜 입력 후 반환 값 테스트")
    @Test
    public void inputViewTestByVisitDate() {
        System.setIn(createUserInput("15"));

        int visitDate = inputView.getVisitDate();

        assertEquals(15, visitDate);

        System.setIn(System.in);
    }

    @DisplayName("주문 입력 후 반환 값 테스트")
    @Test
    public void inputViewTestByOrder() {
        String input = "크리스마스파스타-1,레드와인-1";
        System.setIn(createUserInput(input));

        Map<String, Integer> orderItems = inputView.getOrder();

        Map<String, Integer> expectedOrderItems = Map.ofEntries(
                entry("크리스마스파스타", 1),
                entry("레드와인", 1)
        );

        assertEquals(expectedOrderItems, orderItems);

        System.setIn(System.in);
    }

    InputStream createUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @AfterEach
    public void closeConsole() {
        Console.close();
    }
}
