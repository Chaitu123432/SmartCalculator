package com.savoira.assessment;

public class HomeLoan extends Loan implements Auditable, Exportable {

    public HomeLoan(
            String id,
            String name,
            double principal,
            double rate,
            int tenure) {

        super(id, name, principal, rate, tenure);
    }

    @Override
    public double calculateEMI() {
        double monthlyRate = annualRate / 12 / 100;

        if (monthlyRate == 0) {
            return principalAmount / tenureMonths;
        }

        double factor = Math.pow(1 + monthlyRate, tenureMonths);

        double emi = principalAmount
                * monthlyRate
                * factor
                / (factor - 1);

        return Math.round(emi * 100.0) / 100.0;
    }

    @Override
    public String getAuditLog() {
        return getAuditPrefix()
                + "LoanId=" + loanId
                + " | Applicant=" + applicantName
                + " | Amount=" + String.format("%.2f", principalAmount)
                + " | Status=ACTIVE";
    }

    @Override
    public String toCSVRow() {
        return loanId + ","
                + applicantName + ","
                + String.format("%.2f", principalAmount) + ","
                + String.format("%.2f", annualRate) + ","
                + tenureMonths + ","
                + String.format("%.2f", calculateEMI());
    }
}