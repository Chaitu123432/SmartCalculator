package com.savoira.assessment2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TransactionClassifier {

    private static final Logger logger = LoggerFactory.getLogger(TransactionClassifier.class);

    /**
     * Classifies a transaction based on its type and amount.
     *
     * @param type transaction type
     * @param amount transaction amount
     * @return transaction classification
     * @throws IllegalArgumentException if the transaction type is unknown
     */
    public static String classifyTransaction(String type, double amount) {
        return switch (type) {
            case "CREDIT" -> "Income — positive cash flow";
            case "DEBIT" -> "Expense — deducted from balance";
            case "TRANSFER" -> amount > 10_000
                    ? "Large Transfer — requires OTP"
                    : "Standard Transfer";
            case "WITHDRAWAL" -> "Cash Withdrawal";
            default -> throw new IllegalArgumentException("Unknown transaction type: " + type);
        };
    }

    public static void main(String[] args) {
        logger.info(classifyTransaction("CREDIT", 5000));
        logger.info(classifyTransaction("DEBIT", 1200));
        logger.info(classifyTransaction("TRANSFER", 15000));
        logger.info(classifyTransaction("TRANSFER", 5000));
        logger.info(classifyTransaction("WITHDRAWAL", 3000));

        try {
            logger.info(classifyTransaction("UNKNOWN", 100));
        } catch (IllegalArgumentException e) {
            logger.error(e.getMessage());
        }
    }
}
