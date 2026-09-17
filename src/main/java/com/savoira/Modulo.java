package com.savoira;

/**
 * Represents a modulo operation.
 */
public class Modulo extends Operation implements Calculable {

    /**
     * Creates a modulo operation.
     *
     * @param firstOperand the first operand
     * @param secondOperand the second operand
     */
    public Modulo(double firstOperand, double secondOperand) {
        super(firstOperand, secondOperand);
    }

    /**
     * Calculates the remainder after division.
     *
     * @return modulo result
     * @throws ArithmeticException if the second operand is zero
     */
    @Override
    public double calculate() {

        if (secondOperand == 0) {
            throw new ModuloByZeroException();
        }

        return firstOperand % secondOperand;
    }

    /**
     * Returns a readable description of the operation.
     *
     * @return formatted modulo result
     */
    @Override
    public String toString() {
        return String.format(
                "Modulo: %.2f %% %.2f = %.2f",
                firstOperand,
                secondOperand,
                calculate()
        );
    }
}