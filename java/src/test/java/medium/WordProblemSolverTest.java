package medium;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class WordProblemSolverTest {

    WordProblemSolver solver = new WordProblemSolver();

    @Test
    public void testJustANumber() {
        assertEquals(5, solver.solve("What is 5?"));
    }

    @Test
    public void testSingleAddition1() {
        assertEquals(2, solver.solve("What is 1 plus 1?"));
    }

    @Test
    public void testSingleAddition2() {
        assertEquals(55, solver.solve("What is 53 plus 2?"));
    }

    @Test
    public void testSingleAdditionWithNegativeNumbers() {
        assertEquals(-11, solver.solve("What is -1 plus -10?"));
    }

    @Test
    public void testSingleAdditionOfLargeNumbers() {
        assertEquals(45801, solver.solve("What is 123 plus 45678?"));
    }

    @Test
    public void testSingleSubtraction() {
        assertEquals(16, solver.solve("What is 4 minus -12?"));
    }

    @Test
    public void testSingleMultiplication() {
        assertEquals(-75, solver.solve("What is -3 multiplied by 25?"));
    }

    @Test
    public void testSingleDivision() {
        assertEquals(-11, solver.solve("What is 33 divided by -3?"));
    }

    @Test
    public void testMultipleAdditions() {
        assertEquals(3, solver.solve("What is 1 plus 1 plus 1?"));
    }

    @Test
    public void testAdditionThenSubtraction() {
        assertEquals(8, solver.solve("What is 1 plus 5 minus -2?"));
    }

    @Test
    public void testMultipleSubtractions() {
        assertEquals(3, solver.solve("What is 20 minus 4 minus 13?"));
    }

    @Test
    public void testSubtractionThenAddition() {
        assertEquals(14, solver.solve("What is 17 minus 6 plus 3?"));
    }

    @Test
    public void testMultipleMultiplications() {
        assertEquals(-12, solver.solve("What is 2 multiplied by -2 multiplied by 3?"));
    }

    @Test
    public void testAdditionThenMultiplication() {
        assertEquals(-8, solver.solve("What is -3 plus 7 multiplied by -2?"));
    }

    @Test
    public void testMultipleDivisions() {
        assertEquals(2, solver.solve("What is -12 divided by 2 divided by -3?"));
    }

    @Test
    public void testUnknownOperation() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> solver.solve("What is 52 cubed?"))
                .withMessage("I'm sorry, I don't understand the question!");
    }

    @Test
    public void testNonMathQuestion() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> solver.solve("Who is the President of the United States?"))
                .withMessage("I'm sorry, I don't understand the question!");
    }

    @Test
    public void testMissingAnOperand() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> solver.solve("What is 1 plus?"))
                .withMessage("I'm sorry, I don't understand the question!");
    }

    @Test
    public void testNoOperandsOrOperators() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> solver.solve("What is?"))
                .withMessage("I'm sorry, I don't understand the question!");
    }

    @Test
    public void testTwoOperationsInARow() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> solver.solve("What is 1 plus plus 2?"))
                .withMessage("I'm sorry, I don't understand the question!");
    }

    @Test
    public void testTwoNumbersAfterOperation() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> solver.solve("What is 1 plus 2 1?"))
                .withMessage("I'm sorry, I don't understand the question!");
    }

    @Test
    public void testPostfixNotation() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> solver.solve("What is 1 2 plus?"))
                .withMessage("I'm sorry, I don't understand the question!");
    }

    @Test
    public void testPrefixNotation() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> solver.solve("What is plus 1 2?"))
                .withMessage("I'm sorry, I don't understand the question!");
    }
}
