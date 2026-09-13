package com.savoira;

/**
 * Represents a subtraction operation.
 */
public class Subtraction extends Operation implements Calculable {

    /**
     * Creates a subtraction operation.
     *
     * @param firstOperand the first number
     * @param secondOperand the second number
     */
    public Subtraction(double firstOperand, double secondOperand) {
        super(firstOperand, secondOperand);
    }

    /**
     * Calculates the difference between the two operands.
     *
     * @return the subtraction result
     */
    @Override
    public double calculate() {
        return firstOperand - secondOperand;
    }

    /**
     * Returns a readable description of the operation.
     *
     * @return formatted subtraction result
     */
    @Override
    public String toString() {
        return String.format(
                "Subtraction: %.2f - %.2f = %.2f",
                firstOperand,
                secondOperand,
                calculate()
        );
    }
}