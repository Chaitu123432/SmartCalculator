package com.savoira.week5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Loan {

    private static final Logger logger = LoggerFactory.getLogger(Loan.class);

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
}
