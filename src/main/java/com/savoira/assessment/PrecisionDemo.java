package com.savoira.assessment;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PrecisionDemo {

    public static void main(String[] args) {

        // Floating-point precision problem
        double d1 = 0.1 + 0.2;

        System.out.println("Double result: " + d1);

        // BigDecimal solution
        BigDecimal bd1 = new BigDecimal("0.1");
        BigDecimal bd2 = new BigDecimal("0.2");

        System.out.println(
                "BigDecimal result: " + bd1.add(bd2)
        );

        // Compound interest calculation
        BigDecimal principal = new BigDecimal("500000");
        BigDecimal annualRate = new BigDecimal("8.5");

        int years = 3;
        int compoundsPerYear = 12;

        BigDecimal rate = annualRate
                .divide(
                        BigDecimal.valueOf(100),
                        10,
                        RoundingMode.HALF_UP
                )
                .divide(
                        BigDecimal.valueOf(compoundsPerYear),
                        10,
                        RoundingMode.HALF_UP
                );

        int totalPeriods = years * compoundsPerYear;

        BigDecimal factor = BigDecimal.ONE.add(rate);

        BigDecimal amount = principal.multiply(
                factor.pow(totalPeriods)
        );

        BigDecimal roundedAmount = amount.setScale(
                2,
                RoundingMode.HALF_UP
        );

        System.out.println(
                "Compound interest final amount: Rs."
                        + roundedAmount
        );
    }
}