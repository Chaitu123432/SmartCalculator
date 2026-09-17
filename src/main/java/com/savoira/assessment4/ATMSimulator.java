package com.savoira.assessment4;

import java.util.Scanner;

public class ATMSimulator {
    private double balance = 10000.00;

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) throws ATMException {
        if (amount < 500) {
            throw new ATMException("Minimum withdrawal amount is ₹500.");
        }
        if (amount > 20000) {
            throw new ATMException("Maximum withdrawal limit per transaction is ₹20,000.");
        }
        if (amount % 500 != 0) {
            throw new ATMException("Withdrawal amount must be in multiples of ₹500.");
        }
        if (amount > balance) {
            throw new ATMException("Insufficient balance. Available balance: ₹" + balance);
        }

        balance -= amount;
    }

    public static void main(String[] args) {
        ATMSimulator atm = new ATMSimulator();
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        final int MAX_ATTEMPTS = 3;
        boolean success = false;

        System.out.println("=== Welcome to Meridian Bank ATM ===");

        while (attempts < MAX_ATTEMPTS && !success) {
            System.out.print("\nEnter withdrawal amount (₹): ");
            if (!scanner.hasNextDouble()) {
                System.out.println("Invalid input! Please enter a numerical amount.");
                scanner.next();
                attempts++;
                continue;
            }

            double amount = scanner.nextDouble();

            try {
                atm.withdraw(amount);
                System.out.println("Withdrawal successful! Please collect your cash.");
                System.out.printf("Updated Balance: ₹%.2f%n", atm.getBalance());
                success = true;
            } catch (ATMException e) {
                attempts++;
                System.out.println("Transaction Failed: " + e.getMessage());
                if (attempts < MAX_ATTEMPTS) {
                    System.out.println("Attempts remaining: " + (MAX_ATTEMPTS - attempts));
                }
            }
        }

        if (!success) {
            System.out.println("\nCard locked.");
        }

        scanner.close();
    }
}