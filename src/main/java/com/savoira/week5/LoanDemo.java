package com.savoira.w5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LoanDemo {

    private static final Logger logger =
            LoggerFactory.getLogger(LoanDemo.class);

    public static void main(String[] args) {

        List<Loan> loans = new ArrayList<>();

        loans.add(new HomeLoan(
                "HL001",
                "Rahul Sharma",
                5000000,
                8.5,
                240
        ));

        loans.add(new PersonalLoan(
                "PL001",
                "Priya Reddy",
                500000,
                12.0,
                36
        ));

        loans.add(new PersonalLoan(
                "PL002",
                "Arjun Kumar",
                300000,
                10.5,
                24
        ));

        logger.info("=== Loan Details ===");

        for (Loan loan : loans) {
            logger.info("Loan Type: {}", loan.loanType());
            loan.printSummary();
            logger.info("--------------------");
        }

        logger.info("=== Interface Demonstration ===");

        Auditable auditableLoan = new HomeLoan(
                "HL002",
                "Sneha Rao",
                3500000,
                8.25,
                180
        );

        logger.info(auditableLoan.auditSummary());

        Exportable exportableLoan = new PersonalLoan(
                "PL003",
                "Vikram Singh",
                750000,
                11.5,
                48
        );

        logger.info("CSV: {}", exportableLoan.toCSVRow());

        logger.info("=== equals() and hashCode() Demonstration ===");

        Loan firstLoan = new HomeLoan(
                "HL100",
                "Anita Rao",
                4000000,
                8.0,
                240
        );

        Loan secondLoan = new HomeLoan(
                "hl100",
                "Different Applicant",
                4500000,
                9.0,
                180
        );

        Set<Loan> loanSet = new HashSet<>();
        loanSet.add(firstLoan);
        loanSet.add(secondLoan);

        logger.info("First loan equals second loan: {}",
                firstLoan.equals(secondLoan));

        logger.info("HashSet size: {}", loanSet.size());
    }
}