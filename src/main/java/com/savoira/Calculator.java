package com.savoira;

/**
 * Provides calculator functionality by validating operators,
 * creating mathematical operations, and calculating results.
 */
public class Calculator {

    /**
     * Checks whether the supplied operator is supported.
     *
     * @param operator operator entered by the user
     * @return true if the operator is supported, otherwise false
     */
    public boolean isValidOperator(String operator) {

        if (operator == null) {
            return false;
        }

        return switch (operator.toLowerCase()) {
            case "+", "-", "*", "/", "%",
                 "sqrt", "square-root", "percentage" -> true;
            default -> false;
        };
    }

    /**
     * Determines whether an operation requires a second operand.
     *
     * @param operator mathematical operator
     * @return true if a second operand is required
     */
    public boolean requiresSecondOperand(String operator) {

        return !operator.equalsIgnoreCase("sqrt")
                && !operator.equalsIgnoreCase("square-root");
    }

    /**
     * Performs a calculation using the supplied operator and operands.
     *
     * @param firstOperand first operand
     * @param operator mathematical operator
     * @param secondOperand second operand when required
     * @return calculation result
     * @throws InvalidOperationException if the operator is unsupported
     */
    public double calculate(
            double firstOperand,
            String operator,
            Double secondOperand
    ) {

        if (!isValidOperator(operator)) {
            throw new InvalidOperationException(
                    "Unsupported operator: " + operator
            );
        }

        Calculable operation = createOperation(
                firstOperand,
                operator,
                secondOperand
        );

        return operation.calculate();
    }

    /**
     * Creates the appropriate operation for the supplied operator.
     *
     * @param firstOperand first operand
     * @param operator mathematical operator
     * @param secondOperand second operand when required
     * @return a calculable operation
     * @throws InvalidOperationException if an operand is missing
     *         or the operator is unsupported
     */
    private Calculable createOperation(
            double firstOperand,
            String operator,
            Double secondOperand
    ) {

        return switch (operator.toLowerCase()) {

            case "+" -> new Addition(
                    firstOperand,
                    requireSecondOperand(secondOperand, operator)
            );

            case "-" -> new Subtraction(
                    firstOperand,
                    requireSecondOperand(secondOperand, operator)
            );

            case "*" -> new Multiplication(
                    firstOperand,
                    requireSecondOperand(secondOperand, operator)
            );

            case "/" -> new Division(
                    firstOperand,
                    requireSecondOperand(secondOperand, operator)
            );

            case "%" -> new Modulo(
                    firstOperand,
                    requireSecondOperand(secondOperand, operator)
            );

            case "sqrt", "square-root" ->
                    new SquareRoot(firstOperand);

            case "percentage" -> new Percentage(
                    firstOperand,
                    requireSecondOperand(secondOperand, operator)
            );

            default -> throw new InvalidOperationException(
                    "Unsupported operator: " + operator
            );
        };
    }

    /**
     * Ensures that a second operand is available when required.
     *
     * @param secondOperand second operand
     * @param operator operator requiring the operand
     * @return the second operand
     * @throws InvalidOperationException if the operand is missing
     */
    private double requireSecondOperand(
            Double secondOperand,
            String operator
    ) {

        if (secondOperand == null) {
            throw new InvalidOperationException(
                    "Operator '" + operator
                            + "' requires two operands."
            );
        }

        return secondOperand;
    }
}