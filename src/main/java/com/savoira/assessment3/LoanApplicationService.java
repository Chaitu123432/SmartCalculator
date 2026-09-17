package com.savoira.assessment3;

public class LoanApplicationService {

    public String applyForLoan(
            double income,
            double loanAmount,
            int creditScore) {

        if (income < loanAmount * 0.10) {

            double requiredIncome = loanAmount * 0.10;
            double shortfall = requiredIncome - income;

            throw new InsufficientIncomeException(
                    String.format(
                            "Insufficient income. Shortfall: %.2f",
                            shortfall
                    ),
                    shortfall
            );
        }

        if (loanAmount <= 0 || loanAmount > 5_000_000) {

            throw new InvalidLoanAmountException(
                    "Invalid loan amount: " + loanAmount
            );
        }

        if (creditScore < 650) {

            throw new CreditScoreBelowThresholdException(
                    "Credit score below threshold: " + creditScore
            );
        }

        return "APPROVED";
    }

    public static void main(String[] args) {

        LoanApplicationService service =
                new LoanApplicationService();

        System.out.println("=== Loan Application Tests ===");

        // 1. All checks pass
        try {
            String result = service.applyForLoan(
                    100000,
                    500000,
                    700
            );

            System.out.println("Result: " + result);

        } catch (LoanException e) {
            System.out.println("Rejected: " + e.getMessage());

        } finally {
            System.out.println("Attempt complete.");
        }

        // 2. Income too low
        try {
            service.applyForLoan(
                    20000,
                    500000,
                    700
            );

        } catch (LoanException e) {
            System.out.println("Rejected: " + e.getMessage());

            if (e instanceof InsufficientIncomeException exception) {
                System.out.printf(
                        "Shortfall: %.2f%n",
                        exception.getShortfall()
                );
            }

        } finally {
            System.out.println("Attempt complete.");
        }

        // 3. Invalid amount
        try {
            service.applyForLoan(
                    100000,
                    0,
                    700
            );

        } catch (LoanException e) {
            System.out.println("Rejected: " + e.getMessage());

        } finally {
            System.out.println("Attempt complete.");
        }

        // 4. Credit score too low
        try {
            service.applyForLoan(
                    100000,
                    500000,
                    600
            );

        } catch (LoanException e) {
            System.out.println("Rejected: " + e.getMessage());

        } finally {
            System.out.println("Attempt complete.");
        }
    }
}