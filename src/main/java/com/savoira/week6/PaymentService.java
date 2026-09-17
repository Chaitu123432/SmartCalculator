package com.savoira.week6;

public class PaymentService {

    private static final double DAILY_LIMIT = 200000.0;

    private double balance;

    public PaymentService(double balance) {
        this.balance = balance;
    }

    public void processPayment(double amount) {

        if (amount < 0) {
            throw new InvalidAmountException(
                    "Payment amount cannot be negative: Rs." + amount
            );
        }

        if (amount > DAILY_LIMIT) {
            throw new DailyLimitExceededException(
                    "Payment amount exceeds daily limit of Rs.200000: Rs." + amount,
                    amount
            );
        }

        if (amount > balance) {
            double shortfall = amount - balance;

            throw new InsufficientFundsException(
                    "Insufficient funds. Shortfall: Rs." + shortfall,
                    shortfall
            );
        }

        balance -= amount;

        System.out.println(
                "Payment of Rs." + amount
                        + " processed. New balance: Rs." + balance
        );
    }

    public static void main(String[] args) {

        PaymentService paymentService = new PaymentService(50000);

        // Attempt 1
        try {
            paymentService.processPayment(15000);
        } catch (PaymentException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Attempt complete.");
        }

        // Attempt 2
        try {
            paymentService.processPayment(-500);
        } catch (PaymentException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Attempt complete.");
        }

        // Attempt 3
        try {
            paymentService.processPayment(250000);
        } catch (PaymentException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Attempt complete.");
        }

        // Attempt 4
        try {
            paymentService.processPayment(40000);
        } catch (PaymentException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Attempt complete.");
        }

        // Attempt 5
        try {
            paymentService.processPayment(10000);
        } catch (PaymentException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Attempt complete.");
        }
    }
}