package com.savoira.w5;

public class PersonalLoan extends Loan implements Exportable {

    private final int tenureMonths;

    public PersonalLoan(String loanId, String applicantName,
                        double principal, double annualRate,
                        int tenureMonths) {
        super(loanId, applicantName, principal, annualRate);
        this.tenureMonths = tenureMonths;
    }

    @Override
    public double calculateEMI() {
        double totalInterest =
                principal * annualRate / 100 * tenureMonths / 12;

        return (principal + totalInterest) / tenureMonths;
    }

    @Override
    public String loanType() {
        return "Personal Loan";
    }

    @Override
    public String toCSVRow() {
        return String.format(
                "%s,%s,%.2f,%.2f,%d,%.2f",
                loanId,
                applicantName,
                principal,
                annualRate,
                tenureMonths,
                calculateEMI()
        );
    }
}