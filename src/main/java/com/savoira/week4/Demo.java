package com.savoira.week4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Demo {

    private static final Logger logger =
            LoggerFactory.getLogger(Demo.class);

    public static void main(String[] args) {

        logger.info("=== Bank Account Demo Started ===");

        BankAccount account1 =
                new BankAccount("1001", "Naga", 10000.00);

        BankAccount account2 =
                new BankAccount("1002", "Chaitanya", 5000.00);

        logger.info("--- Performing operations on Account 1 ---");

        account1.deposit(2000.00);
        account1.withdraw(1500.00);

        // Invalid operation
        account1.withdraw(20000.00);

        logger.info("--- Performing operations on Account 2 ---");

        account2.deposit(1000.00);
        account2.withdraw(500.00);

        // Invalid operation
        account2.deposit(-500.00);

        logger.info("--- Final Account Details ---");
        logger.info("{}", account1);
        logger.info("{}", account2);

        logger.info("=== Bank Account Demo Completed ===");
    }
}