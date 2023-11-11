package christmas.ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
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
    @ValueSource(strings = {"1, 31"})
    public void validDateTest(String visitDateStringFormat) {
        assertDoesNotThrow(() -> inputValidator.validateDate(visitDateStringFormat));
    }

    @DisplayName("날짜 예외 테스트 - 날짜 범위를 벗어난 경우")
    @ParameterizedTest
    @ValueSource(strings = {"0 , 32"})
    public void validDateTestByOutOfRange(String visitDateStringFormat) {
        assertThatThrownBy(() -> inputValidator.validateDate(visitDateStringFormat))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("날짜 예외 테스트 - 숫자가 아닌 경우")
    @ParameterizedTest
    @ValueSource(strings = {"일 , two, ?"})
    public void validDateTestByInvalidFormat(String visitDateStringFormat) {
        assertThatThrownBy(() -> inputValidator.validateDate(visitDateStringFormat))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("날짜 예외 테스트 - 빈 문자열인 경우")
    @ParameterizedTest
    @ValueSource(strings = {""})
    public void validDateTestByEmpty(String visitDateStringFormat) {
        assertThatThrownBy(() -> inputValidator.validateDate(visitDateStringFormat))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
