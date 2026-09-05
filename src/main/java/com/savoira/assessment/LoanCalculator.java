package com.savoira.assessment;

public class LoanCalculator {

    public boolean assessEligibility(double monthlyIncome) {

        boolean eligible = monthlyIncome > 25000;

        System.out.println(
                eligible
                        ? "Eligible based on income."
                        : "Not eligible: monthly income must be greater than 25000."
        );

        return eligible;
    }

    public boolean assessEligibility(
            double monthlyIncome,
            double existingEMI) {

        boolean eligible = monthlyIncome - existingEMI > 20000;

        System.out.println(
                eligible
                        ? "Eligible based on disposable income."
                        : "Not eligible: disposable income must be greater than 20000."
        );

        return eligible;
    }

    public boolean assessEligibility(
            double monthlyIncome,
            double existingEMI,
            int creditScore) {

        boolean eligible =
                monthlyIncome - existingEMI > 20000
                        && creditScore > 650;

        System.out.println(
                eligible
                        ? "Eligible based on income, EMI, and credit score."
                        : "Not eligible: income/EMI or credit score condition failed."
        );

        return eligible;
    }

    public static void main(String[] args) {

        LoanCalculator calculator = new LoanCalculator();

        calculator.assessEligibility(30000);

        calculator.assessEligibility(
                40000,
                15000
        );

        calculator.assessEligibility(
                50000,
                15000,
                700
        );
    }
}