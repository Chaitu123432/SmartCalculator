package com.savoira.week4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Demo {

    private static final Logger logger =
            LoggerFactory.getLogger(Demo.class);

    public static void main(String[] args) {

        var account1 =
                new BankAccount("ACC1001", "Naga", 100_000.0);

        var account2 =
                new BankAccount("ACC1002", "Chaitanya", 50_000.0);

        logger.info("Initial account 1: {}", account1);
        logger.info("Initial account 2: {}", account2);

        account1.deposit(25_000.0);
        account1.withdraw(10_000.0);

        account2.deposit(40_000.0);
        account2.withdraw(15_000.0);

        // Invalid operation
        try {
            account1.withdraw(500_000.0);
        } catch (IllegalArgumentException exception) {
            logger.warn("Invalid operation: {}", exception.getMessage());
        }

        // Static tracking
        logger.info(
                "Total accounts created: {}",
                BankAccount.getAccountCount()
        );

        logger.info(
                "Total transactions performed: {}",
                BankAccount.getTotalTransactionCount()
        );

        // LoanUtils demonstration
        var loanAmount =
                LoanUtils.calculateLoanAmount(
                        100_000.0,
                        8.0,
                        24
                );

        logger.info("Calculated loan amount: {}", loanAmount);

        logger.info("Final account 1: {}", account1);
        logger.info("Final account 2: {}", account2);
    }
}