package com.savoira.week4;

/*
 * Five clean-code violations in the original method:
 *
 * 1. Poor method name: "calc" does not describe the operation.
 * 2. Meaningless parameter names: "a", "b", and "c" provide no context.
 * 3. Meaningless local variable: "r" does not communicate its purpose.
 * 4. Magic number: "1200" is unexplained.
 * 5. Poor formatting/readability: the loop is compressed and lacks braces.
 */
public final class LoanUtils {

    private static final int MONTHS_PER_YEAR = 12;
    private static final int PERCENTAGE_MULTIPLIER = 100;

    private LoanUtils() {
        // Utility class; prevent instantiation.
    }

    /**
     * Calculates the loan amount after applying monthly compound interest.
     *
     * @param principalAmount the initial loan principal
     * @param annualInterestRate the annual interest rate as a percentage
     * @param termInMonths the loan term in months
     * @return the loan amount after compound interest
     */
    public static double calculateLoanAmount(
            double principalAmount,
            double annualInterestRate,
            int termInMonths) {

        double growthFactor = 1.0;
        double monthlyInterestRate =
                annualInterestRate
                        / (MONTHS_PER_YEAR * PERCENTAGE_MULTIPLIER);

        for (int month = 0; month < termInMonths; month++) {
            growthFactor *= 1 + monthlyInterestRate;
        }

        return principalAmount * growthFactor;
    }
}