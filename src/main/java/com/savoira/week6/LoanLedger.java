package com.savoira.week6;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LoanLedger {

    private final List<String> transactions = new ArrayList<>();
    private final Map<String, BigDecimal> balances = new HashMap<>();
    private final Set<String> activeAccounts = new HashSet<>();

    public void addAccount(String accountNumber, BigDecimal initialBalance) {
        balances.put(accountNumber, initialBalance);
        activeAccounts.add(accountNumber);

        transactions.add(
                "Account " + accountNumber
                        + " opened with balance Rs." + initialBalance
        );
    }

    public void credit(String accountNumber, BigDecimal amount) {
        validateAccount(accountNumber);

        BigDecimal currentBalance = balances.get(accountNumber);
        BigDecimal newBalance = currentBalance.add(amount);

        balances.put(accountNumber, newBalance);

        transactions.add(
                "Credit Rs." + amount
                        + " to account " + accountNumber
        );
    }

    public void debit(String accountNumber, BigDecimal amount) {
        validateAccount(accountNumber);

        BigDecimal currentBalance = balances.get(accountNumber);

        if (currentBalance.compareTo(amount) < 0) {
            throw new IllegalArgumentException(
                    "Insufficient funds for account " + accountNumber
            );
        }

        BigDecimal newBalance = currentBalance.subtract(amount);

        balances.put(accountNumber, newBalance);

        transactions.add(
                "Debit Rs." + amount
                        + " from account " + accountNumber
        );
    }

    private void validateAccount(String accountNumber) {
        if (!balances.containsKey(accountNumber)) {
            throw new IllegalArgumentException(
                    "Account not found: " + accountNumber
            );
        }
    }

    public void printLedgerSummary() {
        System.out.println("=== Loan Ledger ===");

        for (Map.Entry<String, BigDecimal> entry : balances.entrySet()) {
            System.out.println(
                    "Account " + entry.getKey()
                            + ": Rs." + entry.getValue()
            );
        }

        System.out.println("Active accounts: " + activeAccounts.size());
        System.out.println("Transactions: " + transactions.size());
    }

    public static void main(String[] args) {

        LoanLedger ledger = new LoanLedger();

        ledger.addAccount("ACC001", new BigDecimal("50000.00"));
        ledger.addAccount("ACC002", new BigDecimal("75000.00"));
        ledger.addAccount("ACC003", new BigDecimal("25000.00"));

        ledger.credit("ACC001", new BigDecimal("5000.00"));
        ledger.debit("ACC002", new BigDecimal("10000.00"));
        ledger.debit("ACC003", new BigDecimal("5000.00"));

        ledger.printLedgerSummary();
    }
}