package com.savoira.assessment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;

public class AccountFormatter {

    private static final Logger logger = LoggerFactory.getLogger(AccountFormatter.class);

    /**
     * Formats account details into a single summary string.
     *
     * @param name account holder name
     * @param balance account balance
     * @param accountType account type
     * @return formatted account summary
     */
    public static String formatAccountSummary(String name, double balance, String accountType) {
        if (name == null || accountType == null) {
            throw new IllegalArgumentException("Name and account type cannot be null");
        }

        return String.format(
                Locale.ROOT,
                "Account Holder: %s | Type: %s | Balance: ₹%.2f",
                name.toUpperCase(Locale.ROOT),
                accountType,
                balance);
    }

    public static void main(String[] args) {
        logger.info(formatAccountSummary("Priya Sharma", 45200.50, "SAVINGS"));
        logger.info(formatAccountSummary("Arjun Rao", 12500.00, "CURRENT"));
        logger.info(formatAccountSummary("Meera Patel", 98765.43, "SALARY"));
    }
}
