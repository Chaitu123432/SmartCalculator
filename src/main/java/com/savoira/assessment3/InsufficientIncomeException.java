package com.savoira.assessment3;

public class InsufficientIncomeException extends LoanException {

    private final double shortfall;

    public InsufficientIncomeException(
            String message,
            double shortfall) {

        super(message);
        this.shortfall = shortfall;
    }

    public double getShortfall() {
        return shortfall;
    }
}