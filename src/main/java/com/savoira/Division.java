package com.savoira;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Represents a division operation.
 *
 * <p>BigDecimal is used to reduce floating-point precision
 * problems during division.</p>
 */
public class Division extends Operation implements Calculable {

    /**
     * Creates a division operation.
     *
     * @param firstOperand the dividend
     * @param secondOperand the divisor
     */
    public Division(double firstOperand, double secondOperand) {
        super(firstOperand, secondOperand);
    }

    /**
     * Divides the first operand by the second operand.
     *
     * @return the division result rounded to ten decimal places
     * @throws DivisionByZeroException if the divisor is zero
     */
    @Override
    public double calculate() {

        if (secondOperand == 0) {
            throw new DivisionByZeroException();
        }

        BigDecimal firstValue = BigDecimal.valueOf(firstOperand);
        BigDecimal secondValue = BigDecimal.valueOf(secondOperand);

        return firstValue
                .divide(secondValue, 10, RoundingMode.HALF_UP)
                .doubleValue();
    }

    /**
     * Returns a readable description of the operation.
     *
     * @return formatted division result
     */
    @Override
    public String toString() {
        return String.format(
                "Division: %.2f / %.2f = %.2f",
                firstOperand,
                secondOperand,
                calculate()
        );
    }
}