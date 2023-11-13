package christmas.ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class InputValidatorTest {
    private InputValidator inputValidator;

    @BeforeEach
    public void setUp() {
        inputValidator = new InputValidator();
    }

    @DisplayName("날짜 정상 입력 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1", "31"})
    public void validDateInput(String visitDateStringFormat) {
        assertDoesNotThrow(() -> inputValidator.validateDateInput(visitDateStringFormat));
    }

    @DisplayName("날짜 예외 테스트 - 날짜 범위를 벗어난 경우")
    @ParameterizedTest
    @ValueSource(strings = {"0", "32"})
    public void dateInputByOutOfRange(String visitDateStringFormat) {
        assertThatThrownBy(() -> inputValidator.validateDateInput(visitDateStringFormat))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("날짜 예외 테스트 - 숫자가 아닌 경우")
    @ParameterizedTest
    @ValueSource(strings = {"일", "two", "?"})
    public void dateInputByInvalidFormat(String visitDateStringFormat) {
        assertThatThrownBy(() -> inputValidator.validateDateInput(visitDateStringFormat))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("날짜 예외 테스트 - 빈 문자열인 경우")
    @ParameterizedTest
    @ValueSource(strings = {""})
    public void dateInputByEmpty(String visitDateStringFormat) {
        assertThatThrownBy(() -> inputValidator.validateDateInput(visitDateStringFormat))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("날짜 입력 예외 테스트 - null이 입력된 경우")
    @ParameterizedTest
    @NullSource
    public void dateInputByNull(String orderStringFormat) {
        assertThatThrownBy(() -> inputValidator.validateDateInput(orderStringFormat))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("주문 정상 입력 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"크리스마스파스타-1", "크리스마스파스타-1,제로콜라-1", "크리스마스파스타-1,제로콜라-1,타파스-1,"})
    public void validOrderInput(String orderStringFormat) {
        assertDoesNotThrow(() -> inputValidator.validateOrderInput(orderStringFormat));
    }

    @DisplayName("주문 입력 예외 테스트 - 입력 양식에 맞지 않게 입력된 경우")
    @ParameterizedTest
    @ValueSource(strings = {"크리스마스파스타1", "1", "christmas", "christmasPasta-1"})
    public void orderInputByInvalidFormat(String orderStringFormat) {
        assertThatThrownBy(() -> inputValidator.validateOrderInput(orderStringFormat))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("주문 입력 예외 테스트 - 개수에 0이 입력된 경우")
    @ParameterizedTest
    @ValueSource(strings = {"크리스마스파스타-0"})
    public void orderInputByQuantityZero(String orderStringFormat) {
        assertThatThrownBy(() -> inputValidator.validateOrderInput(orderStringFormat))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("주문 입력 예외 테스트 - 빈 문자열이 입력된 경우")
    @ParameterizedTest
    @ValueSource(strings = {""})
    public void orderInputByEmpty(String orderStringFormat) {
        assertThatThrownBy(() -> inputValidator.validateOrderInput(orderStringFormat))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("주문 입력 예외 테스트 - 중복 메뉴가 입력된 경우")
    @ParameterizedTest
    @ValueSource(strings = {"초코케이크-1, 초코케이크-1"})
    public void orderInputByDuplicate(String orderStringFormat) {
        assertThatThrownBy(() -> inputValidator.validateOrderInput(orderStringFormat))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("주문 입력 예외 테스트 - null이 입력된 경우")
    @ParameterizedTest
    @NullSource
    public void orderInputByNull(String orderStringFormat) {
        assertThatThrownBy(() -> inputValidator.validateOrderInput(orderStringFormat))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
