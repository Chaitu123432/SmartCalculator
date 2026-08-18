package com.savoira.assessment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;

public class BankAccount {

    private static final Logger logger = LoggerFactory.getLogger(BankAccount.class);

    private final String accountNumber;
    private final String holderName;
    private double balance;
    private int transactionCount;

    /**
     * Creates a bank account with an initial balance.
     *
     * @param accountNumber unique account number
     * @param holderName account holder name
     * @param initialBalance starting balance
     */
    public BankAccount(String accountNumber, String holderName, double initialBalance) {
        if (accountNumber == null || accountNumber.isBlank()) {
            throw new IllegalArgumentException("Account number cannot be null or blank");
        }
        if (holderName == null || holderName.isBlank()) {
            throw new IllegalArgumentException("Holder name cannot be null or blank");
        }
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }

        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = initialBalance;
    }

    /**
     * Creates a bank account with a zero initial balance.
     *
     * @param accountNumber unique account number
     * @param holderName account holder name
     */
    public BankAccount(String accountNumber, String holderName) {
        this(accountNumber, holderName, 0.0);
    }

    /**
     * Deposits money into the account.
     *
     * @param amount amount to deposit; must be positive
     * @throws IllegalArgumentException if amount is not positive
     */
    public void deposit(double amount) {
        if (amount <= 0 || Double.isNaN(amount) || Double.isInfinite(amount)) {
            throw new IllegalArgumentException("Deposit amount must be a positive finite value");
        }
        balance += amount;
        transactionCount++;
    }

    /**
     * Withdraws money from the account.
     *
     * @param amount amount to withdraw; must be positive and no greater than the balance
     * @throws IllegalArgumentException if amount is invalid or exceeds the balance
     */
    public void withdraw(double amount) {
        if (amount <= 0 || Double.isNaN(amount) || Double.isInfinite(amount)) {
            throw new IllegalArgumentException("Withdrawal amount must be a positive finite value");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        balance -= amount;
        transactionCount++;
    }

    /**
     * Returns the current account balance.
     *
     * @return current balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Returns the number of successful deposits and withdrawals.
     *
     * @return transaction count
     */
    public int getTransactionCount() {
        return transactionCount;
    }

    /**
     * Returns a formatted account summary.
     *
     * @return formatted account summary
     */
    public String getSummary() {
        return String.format(
                Locale.ROOT,
                "Account Number: %s | Holder: %s | Balance: ₹%.2f | Transactions: %d",
                accountNumber,
                holderName,
                balance,
                transactionCount);
    }

    public static void main(String[] args) {
        var account1 = new BankAccount("ACC1001", "Priya Sharma", 10000.00);
        var account2 = new BankAccount("ACC1002", "Arjun Rao");

        account1.deposit(5000.00);
        account1.withdraw(1500.00);

        account2.deposit(8000.00);
        account2.withdraw(2500.00);

        try {
            account1.withdraw(-500.00);
        } catch (IllegalArgumentException e) {
            logger.error("Invalid operation: {}", e.getMessage());
        }

        logger.info(account1.getSummary());
        logger.info(account2.getSummary());
    }
}
