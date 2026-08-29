package com.savoira;

/**
 * Represents a multiplication operation.
 */
public class Multiplication extends Operation implements Calculable {

    /**
     * Creates a multiplication operation.
     *
     * @param firstOperand the first number
     * @param secondOperand the second number
     */
    public Multiplication(double firstOperand, double secondOperand) {
        super(firstOperand, secondOperand);
    }

    /**
     * Calculates the product of the two operands.
     *
     * @return the multiplication result
     */
    @Override
    public double calculate() {
        return firstOperand * secondOperand;
    }

    /**
     * Returns a readable description of the operation.
     *
     * @return formatted multiplication result
     */
    @Override
    public String toString() {
        return String.format(
                "Multiplication: %.2f * %.2f = %.2f",
                firstOperand,
                secondOperand,
                calculate()
        );
    }
}