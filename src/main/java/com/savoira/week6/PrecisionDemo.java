package com.savoira.week6;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PrecisionDemo {

    public static void main(String[] args) {

        double doubleResult = 0.1 + 0.2;

        BigDecimal bigDecimalResult = BigDecimal.valueOf(0.1)
                .add(BigDecimal.valueOf(0.2));

        BigDecimal amount = new BigDecimal("100.00");
        BigDecimal interestRate = new BigDecimal("0.075");

        BigDecimal interest = amount
                .multiply(interestRate)
                .setScale(2, RoundingMode.HALF_UP);

        System.out.println("Double result: " + doubleResult);
        System.out.println("BigDecimal result: " + bigDecimalResult);
        System.out.println("Interest on Rs.100.00 at 7.5%: Rs." + interest);
    }
}