package christmas.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputViewTest {
    @DisplayName("방문 날짜 입력 테스트")
    @Test
    public void inputViewTestByVisitDate() {
        String input = "15";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        InputView inputView = new InputView();
        int visitDate = inputView.getVisitDate();

        assertEquals(15, visitDate);

        System.setIn(System.in);
    }
}
