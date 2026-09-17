package com.savoira.assessment3;

public class PersonalLoan extends Loan {

    public PersonalLoan(
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
}