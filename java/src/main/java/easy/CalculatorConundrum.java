package easy;

public class CalculatorConundrum {

    public String calculate(int operand1, int operand2, String operation) {
        if (operation == null) throw new IllegalArgumentException("Operation cannot be null");
        if (operation.isBlank()) throw new IllegalArgumentException("Operation cannot be empty");

        int result = 0;

        switch (operation) {
            case "+" -> result = operand1 + operand2;
            case "*" -> result = operand1 * operand2;
            case "/" -> {
                try {
                    result = operand1 / operand2;
                } catch (ArithmeticException e) {
                    throw new IllegalOperationException("Division by zero is not allowed", e);
                }
            }
            default -> throw new IllegalOperationException("Operation '" + operation + "' does not exist");
        }

        return operand1 + " " + operation + " " + operand2 + " = " + result;
    }

    static class IllegalOperationException extends RuntimeException {

        public IllegalOperationException(String errorMessage) {
            super(errorMessage);
        }

        public IllegalOperationException(String errorMessage, Throwable cause) {
            super(errorMessage, cause);
        }

    }

}
