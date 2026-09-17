package com.savoira.week4;

/**
 * Central configuration constants for bank operations.
 */
public final class BankConfig {

    private BankConfig() {
        // Prevent instantiation.
    }

    public static final double MAX_DEPOSIT = 500_000.0;
    public static final double MAX_WITHDRAWAL = 200_000.0;
    public static final int MAX_DAILY_TXN = 10;
}
