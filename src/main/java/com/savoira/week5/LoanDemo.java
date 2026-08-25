package com.savoira.week5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

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
    }
}
