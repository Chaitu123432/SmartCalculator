package com.savoira.week4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BankAccount {

    private static final Logger logger =
            LoggerFactory.getLogger(BankAccount.class);

    private final String accountNumber;
    private String holderName;
    private double balance;
    private int transactionCount;

    // Primary constructor
    public BankAccount(String accountNumber, String holderName, double initialBalance) {

        if (accountNumber == null || accountNumber.isBlank()) {
            throw new IllegalArgumentException("Account number cannot be empty.");
        }

        if (holderName == null || holderName.isBlank()) {
            throw new IllegalArgumentException("Holder name cannot be empty.");
        }

        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative.");
        }

        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = initialBalance;
        this.transactionCount = 0;

        logger.info("Account created: ACC{} | Holder: {} | Initial Balance: Rs.{}",
                accountNumber, holderName, initialBalance);
    }

    // Secondary constructor
    public BankAccount(String accountNumber, String holderName) {
        this(accountNumber, holderName, 0.0);
    }

    public void deposit(double amount) {

        if (amount <= 0) {
            logger.warn("Invalid deposit for ACC{}: Amount must be greater than zero. Amount: {}",
                    accountNumber, amount);
            return;
        }

        balance += amount;
        transactionCount++;

        logger.info("Deposit successful for ACC{}: Rs.{} | New Balance: Rs.{}",
                accountNumber, amount, balance);
    }

    public void withdraw(double amount) {

        if (amount <= 0) {
            logger.warn("Invalid withdrawal for ACC{}: Amount must be greater than zero. Amount: {}",
                    accountNumber, amount);
            return;
        }

        if (amount > balance) {
            logger.warn("Invalid withdrawal for ACC{}: Insufficient balance. " +
                            "Requested: Rs.{} | Available: Rs.{}",
                    accountNumber, amount, balance);
            return;
        }

        balance -= amount;
        transactionCount++;

        logger.info("Withdrawal successful for ACC{}: Rs.{} | New Balance: Rs.{}",
                accountNumber, amount, balance);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public int getTransactionCount() {
        return transactionCount;
    }

    @Override
    public String toString() {
        return "ACC" + accountNumber
                + " | " + holderName
                + " | Balance: Rs." + balance
                + " | Txn: " + transactionCount;
    }
}