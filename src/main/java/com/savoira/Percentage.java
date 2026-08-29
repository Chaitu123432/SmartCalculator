package com.savoira;

/**
 * Represents a percentage calculation.
 *
 * <p>For example, 10 percent of 200 is 20.</p>
 */
public class Percentage extends Operation implements Calculable {

    /**
     * Creates a percentage operation.
     *
     * @param value value from which the percentage is calculated
     * @param percentage percentage to calculate
     */
    public Percentage(double value, double percentage) {
        super(value, percentage);
    }

    /**
     * Calculates the requested percentage.
     *
     * @return calculated percentage
     */
    @Override
    public double calculate() {
        return firstOperand * secondOperand / 100;
    }

    /**
     * Returns a readable description of the operation.
     *
     * @return formatted percentage result
     */
    @Override
    public String toString() {
        return String.format(
                "Percentage: %.2f%% of %.2f = %.2f",
                secondOperand,
                firstOperand,
                calculate()
        );
    }
}