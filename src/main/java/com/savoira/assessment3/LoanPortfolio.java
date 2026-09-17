package com.savoira.assessment3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LoanPortfolio {

    public static void main(String[] args) {

        List<Loan> loans = new ArrayList<>();

        Loan homeLoan = new HomeLoan(
                "HL001",
                "Rahul",
                5000000,
                8.5,
                240
        );

        Loan personalLoan = new PersonalLoan(
                "PL001",
                "Priya",
                500000,
                12.0,
                60
        );

        Loan educationLoan = new EducationLoan(
                "EL001",
                "Rahul",
                1000000,
                7.5,
                120
        );

        loans.add(homeLoan);
        loans.add(personalLoan);
        loans.add(educationLoan);

        // Map for fast loan lookup by loan ID
        Map<String, Loan> loanMap = new HashMap<>();

        for (Loan loan : loans) {
            loanMap.put(loan.getLoanId(), loan);
        }

        // Successful lookup
        Loan foundLoan = loanMap.get("HL001");

        if (foundLoan != null) {
            System.out.println(
                    "Successful lookup: "
                            + foundLoan.getLoanId()
            );
        }

        // Failed lookup
        Loan missingLoan = loanMap.get("UNKNOWN");

        if (missingLoan == null) {
            System.out.println(
                    "Failed lookup: loan not found."
            );
        }

        // Set for unique applicant names
        Set<String> applicants = new HashSet<>();

        for (Loan loan : loans) {
            applicants.add(loan.getApplicantName());
        }

        System.out.println(
                "Unique applicants: " + applicants.size()
        );

        // For-each loop
        System.out.println("=== For-each iteration ===");

        for (Loan loan : loans) {
            System.out.println(
                    loan.getLoanId()
                            + " - "
                            + loan.getApplicantName()
            );
        }

        // Iterator
        System.out.println("=== Iterator iteration ===");

        Iterator<Loan> iterator = loans.iterator();

        while (iterator.hasNext()) {

            Loan loan = iterator.next();

            System.out.println(
                    loan.getLoanId()
                            + " - "
                            + loan.getApplicantName()
            );
        }
    }
}