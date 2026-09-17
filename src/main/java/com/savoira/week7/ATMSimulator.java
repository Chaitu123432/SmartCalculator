package com.savoira.week7;

import java.util.Scanner;

public class ATMSimulator {

    private double balance;

    public ATMSimulator(double balance) {
        this.balance = balance;
    }

    public double withdraw(double amount) {

        if (amount < 500) {
            throw new MinimumWithdrawalException(
                    "Withdrawal amount must be at least Rs.500."
            );
        }

        if (amount > 20_000) {
            throw new MaximumWithdrawalException(
                    "Withdrawal amount cannot exceed Rs.20,000."
            );
        }

        if (amount % 500 != 0) {
            throw new InvalidMultipleException(
                    "Withdrawal amount must be a multiple of Rs.500."
            );
        }

        if (amount > balance) {
            throw new InsufficientBalanceException(
                    "Insufficient balance."
            );
        }

        balance -= amount;
        return balance;
    }

    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ATMSimulator atm = new ATMSimulator(3000);

        int attempts = 0;

        while (attempts < 3) {

            System.out.print("Enter withdrawal amount: ");
            double amount = scanner.nextDouble();

            attempts++;

            try {

                double newBalance = atm.withdraw(amount);

                System.out.println("Withdrawal successful.");
                System.out.println("New balance: Rs." + newBalance);

                break;

            } catch (RuntimeException e) {

                System.out.println(e.getMessage());

                if (attempts == 3) {
                    System.out.println("Card locked.");
                }
            }
        }

        scanner.close();
    }
}


class MinimumWithdrawalException extends RuntimeException {

    public MinimumWithdrawalException(String message) {
        super(message);
    }
}


class MaximumWithdrawalException extends RuntimeException {

    public MaximumWithdrawalException(String message) {
        super(message);
    }
}


class InvalidMultipleException extends RuntimeException {

    public InvalidMultipleException(String message) {
        super(message);
    }
}


class InsufficientBalanceException extends RuntimeException {

    public InsufficientBalanceException(String message) {
        super(message);
    }
}