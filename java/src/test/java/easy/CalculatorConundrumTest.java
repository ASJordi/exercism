package easy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import easy.CalculatorConundrum.IllegalOperationException;

public class CalculatorConundrumTest {

    @Test
    @Tag("task:1")
    @DisplayName("The calculate method returns the correct result when adding small operands")
    public void additionWithSmallOperands() {
        assertEquals("22 + 25 = 47", new CalculatorConundrum().calculate(22, 25, "+"));
    }

    @Test
    @Tag("task:1")
    @DisplayName("The calculate method returns the correct result when adding large operands")
    public void additionWithLargeOperands() {
        assertEquals("378961 + 399635 = 778596", new CalculatorConundrum().calculate(378_961, 399_635, "+"));
    }

    @Test
    @Tag("task:1")
    @DisplayName("The calculate method returns the correct result when multiplying small operands")
    public void multiplicationWithSmallOperands() {
        assertEquals("3 * 21 = 63", new CalculatorConundrum().calculate(3, 21, "*"));
    }

    @Test
    @Tag("task:1")
    @DisplayName("The calculate method returns the correct result when multiplying large operands")
    public void multiplicationWithLargeOperands() {
        assertEquals("72441 * 2048 = 148359168", new CalculatorConundrum().calculate(72_441, 2_048, "*"));
    }

    @Test
    @Tag("task:1")
    @DisplayName("The calculate method returns the correct result when dividing small operands")
    public void divisionWithSmallOperands() {
        assertEquals("72 / 9 = 8", new CalculatorConundrum().calculate(72, 9, "/"));
    }

    @Test
    @Tag("task:1")
    @DisplayName("The calculate method returns the correct result when dividing large operands")
    public void divisionWithLargeOperands() {
        assertEquals("1338800 / 83675 = 16", new CalculatorConundrum().calculate(1_338_800, 83_675, "/"));
    }

    @Test
    @Tag("task:2")
    @DisplayName("The calculate method throws IllegalOperationException when passing invalid operation")
    public void throwExceptionForUnknownOperation() {
        String invalidOperation = "**";
        String expectedMessage = "Operation '" + invalidOperation + "' does not exist";
        assertThatExceptionOfType(IllegalOperationException.class).isThrownBy(() -> new CalculatorConundrum().calculate(3, 78, invalidOperation)).withMessage(expectedMessage);
    }

    @Test
    @Tag("task:2")
    @DisplayName("The calculate method throws IllegalArgumentException when passing null operation")
    public void throwExceptionForNullAsOperation() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new CalculatorConundrum().calculate(66, 65, null)).withMessage("Operation cannot be null");
    }

    @Test
    @Tag("task:2")
    @DisplayName("The calculate method throws IllegalArgumentException when passing empty operation")
    public void throwExceptionForAnEmptyStringOperation() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new CalculatorConundrum().calculate(34, 324, "")).withMessage("Operation cannot be empty");
    }

    @Test
    @Tag("task:3")
    @DisplayName("The calculate method throws IllegalOperationException when dividing by zero")
    public void throwExceptionForDivisionByZero() {
        assertThatExceptionOfType(IllegalOperationException.class).isThrownBy(() -> new CalculatorConundrum().calculate(33, 0, "/")).withMessage("Division by zero is not allowed").withCauseInstanceOf(ArithmeticException.class);
    }

}
