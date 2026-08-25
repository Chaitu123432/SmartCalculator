package com.savoira.week5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public abstract class Loan implements Auditable {

    private static final Logger logger =
            LoggerFactory.getLogger(Loan.class);

    protected String loanId;
    protected String applicantName;
    protected double principal;
    protected double annualRate;

    public Loan(String loanId, String applicantName,
                double principal, double annualRate) {
        this.loanId = loanId;
        this.applicantName = applicantName;
        this.principal = principal;
        this.annualRate = annualRate;
    }

    public abstract double calculateEMI();

    public abstract String loanType();

    @Override
    public String auditSummary() {
        return auditPrefix()
                + loanId + " | "
                + applicantName + " | Rs."
                + String.format("%.2f", principal)
                + " | Rate:"
                + String.format("%.2f", annualRate)
                + "%";
    }

    public void printSummary() {
        logger.info(
                "Loan ID: {}, Applicant: {}, Loan Type: {}, Principal: {}, Annual Rate: {}%, EMI: {}",
                loanId,
                applicantName,
                loanType(),
                String.format("%.2f", principal),
                String.format("%.2f", annualRate),
                String.format("%.2f", calculateEMI())
        );
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Loan other)) {
            return false;
        }

        if (loanId == null || other.loanId == null) {
            return loanId == other.loanId;
        }

        return loanId.equalsIgnoreCase(other.loanId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                loanId == null ? null : loanId.toLowerCase()
        );
    }
}