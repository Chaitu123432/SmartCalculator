package com.savoira.week4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BankAccount {

    private static final Logger logger =
            LoggerFactory.getLogger(BankAccount.class);

    // Static tracking shared by all BankAccount objects
    private static int accountCount = 0;
    private static int totalTransactionCount = 0;

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

        accountCount++;

        logger.info("Bank account created: {}", accountNumber);
    }

    // Constructor with zero initial balance
    public BankAccount(String accountNumber, String holderName) {
        this(accountNumber, holderName, 0.0);
    }

    public void deposit(double amount) {

        if (amount <= 0) {
            logger.warn("Invalid deposit amount: {}", amount);
            throw new IllegalArgumentException(
                    "Deposit amount must be greater than zero."
            );
        }

        if (amount > BankConfig.MAX_DEPOSIT) {
            logger.warn("Deposit exceeds maximum allowed amount: {}", amount);
            throw new IllegalArgumentException(
                    "Deposit exceeds maximum allowed amount."
            );
        }

        checkDailyTransactionLimit();

        balance += amount;
        transactionCount++;
        totalTransactionCount++;

        logger.info(
                "Deposit successful: account={}, amount={}, balance={}",
                accountNumber,
                amount,
                balance
        );
    }

    public void withdraw(double amount) {

        if (amount <= 0) {
            logger.warn("Invalid withdrawal amount: {}", amount);
            throw new IllegalArgumentException(
                    "Withdrawal amount must be greater than zero."
            );
        }

        if (amount > BankConfig.MAX_WITHDRAWAL) {
            logger.warn(
                    "Withdrawal exceeds maximum allowed amount: {}",
                    amount
            );
            throw new IllegalArgumentException(
                    "Withdrawal exceeds maximum allowed amount."
            );
        }

        if (amount > balance) {
            logger.warn(
                    "Insufficient balance: account={}, requested={}",
                    accountNumber,
                    amount
            );
            throw new IllegalArgumentException("Insufficient balance.");
        }

        checkDailyTransactionLimit();

        balance -= amount;
        transactionCount++;
        totalTransactionCount++;

        logger.info(
                "Withdrawal successful: account={}, amount={}, balance={}",
                accountNumber,
                amount,
                balance
        );
    }

    private void checkDailyTransactionLimit() {

        if (transactionCount >= BankConfig.MAX_DAILY_TXN) {
            logger.warn(
                    "Daily transaction limit reached for account={}",
                    accountNumber
            );

            throw new IllegalStateException(
                    "Daily transaction limit reached."
            );
        }
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

    public static int getAccountCount() {
        return accountCount;
    }

    public static int getTotalTransactionCount() {
        return totalTransactionCount;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", holderName='" + holderName + '\'' +
                ", balance=" + balance +
                ", transactionCount=" + transactionCount +
                '}';
    }
}