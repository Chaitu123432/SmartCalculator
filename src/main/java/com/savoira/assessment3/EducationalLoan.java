package com.savoira.assessment3;

public class EducationLoan extends Loan {

    private static final int MORATORIUM_MONTHS = 6;

    public EducationLoan(
            String id,
            String name,
            double principal,
            double rate,
            int tenure) {

        super(id, name, principal, rate, tenure);
    }

    @Override
    public double calculateEMI() {
        double simpleInterest = principalAmount
                * annualRate / 100
                * tenureMonths / 12;

        double emi = (principalAmount + simpleInterest)
                / tenureMonths;

        return Math.round(emi * 100.0) / 100.0;
    }

    @Override
    public double totalRepayable() {
        double baseTotal = calculateEMI() * tenureMonths;

        double moratoriumInterest = principalAmount
                * annualRate / 100
                * MORATORIUM_MONTHS / 12;

        return Math.round(
                (baseTotal + moratoriumInterest) * 100.0
        ) / 100.0;
    }
}