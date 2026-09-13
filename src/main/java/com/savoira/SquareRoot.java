package com.savoira;

/**
 * Represents a square-root operation.
 */
public class SquareRoot extends Operation implements Calculable {

    /**
     * Creates a square-root operation.
     *
     * @param operand number whose square root will be calculated
     */
    public SquareRoot(double operand) {
        super(operand, 0);
    }

    /**
     * Calculates the square root of the operand.
     *
     * @return square root of the operand
     * @throws IllegalArgumentException if the operand is negative
     */
    @Override
    public double calculate() {

        if (firstOperand < 0) {
            throw new IllegalArgumentException(
                    "Square root of a negative number is not allowed."
            );
        }

        return Math.sqrt(firstOperand);
    }

    /**
     * Returns a readable description of the operation.
     *
     * @return formatted square-root result
     */
    @Override
    public String toString() {
        return String.format(
                "Square Root: √%.2f = %.2f",
                firstOperand,
                calculate()
        );
    }
}