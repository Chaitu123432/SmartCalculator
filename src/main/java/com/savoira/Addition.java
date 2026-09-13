package com.savoira;

/**
 * Represents an addition operation.
 */
public class Addition extends Operation implements Calculable {

    /**
     * Creates an addition operation.
     *
     * @param firstOperand the first number
     * @param secondOperand the second number
     */
    public Addition(double firstOperand, double secondOperand) {
        super(firstOperand, secondOperand);
    }

    /**
     * Calculates the sum of the two operands.
     *
     * @return the sum of the operands
     */
    @Override
    public double calculate() {
        return firstOperand + secondOperand;
    }

    /**
     * Returns a readable description of the operation.
     *
     * @return formatted addition result
     */
    @Override
    public String toString() {
        return String.format(
                "Addition: %.2f + %.2f = %.2f",
                firstOperand,
                secondOperand,
                calculate()
        );
    }
}