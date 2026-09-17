package com.savoira.assessment2;

public final class MathUtils {

    private MathUtils() {
        // prevent instantiation — utility class.
    }

    /**
     * Rounds a value to two decimal places.
     *
     * @param v value to round
     * @return rounded value
     */
    public static double roundToTwoDecimalPlaces(double v) {
        return Math.round(v * 100.0) / 100.0;
    }

    /**
     * Calculates simple interest using the rate as a percentage.
     *
     * @param p principal amount
     * @param r annual interest rate in percent
     * @param t time in years
     * @return simple interest amount
     */
    public static double calculateSimpleInterest(double p, double r, double t) {
        return p * r * t / 100.0;
    }

    /**
     * Calculates compound interest using the rate as a percentage.
     *
     * @param p principal amount
     * @param r annual interest rate in percent
     * @param n number of compounding periods per year
     * @param t time in years
     * @return compound interest amount
     */
    public static double calculateCompoundInterest(double p, double r, int n, double t) {
        if (n <= 0) {
            throw new IllegalArgumentException("Compounding frequency must be positive");
        }
        return p * Math.pow(1 + r / (100.0 * n), n * t) - p;
    }
}
