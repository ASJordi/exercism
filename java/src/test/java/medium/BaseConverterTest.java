package medium;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class BaseConverterTest {

    @Test
    public void testSingleBitOneToDecimal() {
        BaseConverter baseConverter = new BaseConverter(2, new int[]{1});

        assertThat(baseConverter.convertToBase(10))
                .containsExactly(1);
    }

    @Test
    public void testBinaryToSingleDecimal() {
        BaseConverter baseConverter = new BaseConverter(2, new int[]{1, 0, 1});

        assertThat(baseConverter.convertToBase(10))
                .containsExactly(5);
    }

    @Test
    public void testSingleDecimalToBinary() {
        BaseConverter baseConverter = new BaseConverter(10, new int[]{5});

        assertThat(baseConverter.convertToBase(2))
                .containsExactly(1, 0, 1);
    }

    @Test
    public void testBinaryToMultipleDecimal() {
        BaseConverter baseConverter = new BaseConverter(2, new int[]{1, 0, 1, 0, 1, 0});

        assertThat(baseConverter.convertToBase(10))
                .containsExactly(4, 2);
    }

    @Test
    public void testDecimalToBinary() {
        BaseConverter baseConverter = new BaseConverter(10, new int[]{4, 2});

        assertThat(baseConverter.convertToBase(2))
                .containsExactly(1, 0, 1, 0, 1, 0);
    }

    @Test
    public void testTrinaryToHexadecimal() {
        BaseConverter baseConverter = new BaseConverter(3, new int[]{1, 1, 2, 0});

        assertThat(baseConverter.convertToBase(16))
                .containsExactly(2, 10);
    }

    @Test
    public void testHexadecimalToTrinary() {
        BaseConverter baseConverter = new BaseConverter(16, new int[]{2, 10});

        assertThat(baseConverter.convertToBase(3))
                .containsExactly(1, 1, 2, 0);
    }

    @Test
    public void test15BitInteger() {
        BaseConverter baseConverter = new BaseConverter(97, new int[]{3, 46, 60});

        assertThat(baseConverter.convertToBase(73))
                .containsExactly(6, 10, 45);
    }

    @Test
    public void testEmptyDigits() {
        BaseConverter baseConverter = new BaseConverter(2, new int[]{});

        assertThat(baseConverter.convertToBase(10))
                .containsExactly(0);
    }

    @Test
    public void testSingleZero() {
        BaseConverter baseConverter = new BaseConverter(10, new int[]{0});

        assertThat(baseConverter.convertToBase(2))
                .containsExactly(0);
    }

    @Test
    public void testMultipleZeros() {
        BaseConverter baseConverter = new BaseConverter(10, new int[]{0, 0, 0});

        assertThat(baseConverter.convertToBase(2))
                .containsExactly(0);
    }

    @Test
    public void testLeadingZeros() {
        BaseConverter baseConverter = new BaseConverter(7, new int[]{0, 6, 0});

        assertThat(baseConverter.convertToBase(10))
                .containsExactly(4, 2);
    }

    @Test
    public void testFirstBaseIsOne() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new BaseConverter(1, new int[]{1}))
                .withMessage("Bases must be at least 2.");
    }

    @Test
    public void testFirstBaseIsZero() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new BaseConverter(0, new int[]{1}))
                .withMessage("Bases must be at least 2.");
    }

    @Test
    public void testFirstBaseIsNegative() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new BaseConverter(-2, new int[]{1}))
                .withMessage("Bases must be at least 2.");
    }

    @Test
    public void testNegativeDigit() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new BaseConverter(2, new int[]{1, -1, 1, 0, 1, 0}))
                .withMessage("Digits may not be negative.");
    }

    @Test
    public void testInvalidPositiveDigit() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new BaseConverter(2, new int[]{1, 2, 1, 0, 1, 0}))
                .withMessage("All digits must be strictly less than the base.");
    }

    @Test
    public void testSecondBaseIsOne() {
        BaseConverter baseConverter =
                new BaseConverter(2, new int[]{1, 0, 1, 0, 1, 0});

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> baseConverter.convertToBase(1))
                .withMessage("Bases must be at least 2.");
    }

    @Test
    public void testSecondBaseIsZero() {
        BaseConverter baseConverter = new BaseConverter(10, new int[]{7});

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> baseConverter.convertToBase(0))
                .withMessage("Bases must be at least 2.");
    }

    @Test
    public void testSecondBaseIsNegative() {
        BaseConverter baseConverter = new BaseConverter(2, new int[]{1});

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> baseConverter.convertToBase(-7))
                .withMessage("Bases must be at least 2.");
    }

}
