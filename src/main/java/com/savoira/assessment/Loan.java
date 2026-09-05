package com.savoira.assessment;

import java.util.Objects;

public abstract class Loan {

    protected final String loanId;
    protected final String applicantName;
    protected final double principalAmount;
    protected final double annualRate;
    protected final int tenureMonths;

    public Loan(String id, String name, double principal, double rate, int tenure) {
        this.loanId = id;
        this.applicantName = name;
        this.principalAmount = principal;
        this.annualRate = rate;
        this.tenureMonths = tenure;
    }

    public abstract double calculateEMI();

    public double totalRepayable() {
        return calculateEMI() * tenureMonths;
    }

    public void printSummary() {
        System.out.println("Loan ID: " + loanId);
        System.out.println("Applicant: " + applicantName);
        System.out.printf("Principal Amount: %.2f%n", principalAmount);
        System.out.printf("Annual Rate: %.2f%%%n", annualRate);
        System.out.println("Tenure: " + tenureMonths + " months");
        System.out.printf("EMI: %.2f%n", calculateEMI());
        System.out.printf("Total Repayable: %.2f%n", totalRepayable());
        System.out.println("----------------------------");
    }

    public String getLoanId() {
        return loanId;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public double getPrincipalAmount() {
        return principalAmount;
    }

    public double getAnnualRate() {
        return annualRate;
    }

    public int getTenureMonths() {
        return tenureMonths;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Loan other)) {
            return false;
        }

        return loanId.equalsIgnoreCase(other.loanId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loanId.toLowerCase());
    }
}