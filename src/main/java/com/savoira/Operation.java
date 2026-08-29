package com.savoira;

/**
 * Abstract base class for mathematical operations.
 *
 * <p>An operation contains two operands and provides
 * the common structure for concrete calculations.</p>
 */
public abstract class Operation {

    protected final double firstOperand;
    protected final double secondOperand;

    /**
     * Creates a mathematical operation.
     *
     * @param firstOperand the first operand
     * @param secondOperand the second operand
     */
    protected Operation(double firstOperand, double secondOperand) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
    }

    /**
     * Calculates the result of the operation.
     *
     * @return the calculated result
     */
    public abstract double calculate();
}