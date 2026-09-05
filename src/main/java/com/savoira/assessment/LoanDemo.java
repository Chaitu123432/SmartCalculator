package com.savoira.assessment;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LoanDemo {

    public static void main(String[] args) {

        List<Loan> loans = new ArrayList<>();

        loans.add(new HomeLoan(
                "HL001",
                "Rahul",
                5000000,
                8.5,
                240
        ));

        loans.add(new PersonalLoan(
                "PL001",
                "Priya",
                500000,
                12.0,
                60
        ));

        loans.add(new EducationLoan(
                "EL001",
                "Arjun",
                1000000,
                7.5,
                120
        ));

        System.out.println("=== Loan Summaries ===");

        for (Loan loan : loans) {
            loan.printSummary();
        }

        System.out.println("=== Interface Demonstration ===");

        Auditable a = new HomeLoan(
                "HL002",
                "Meera",
                3000000,
                8.25,
                180
        );

        Exportable e = new HomeLoan(
                "HL003",
                "Kiran",
                2500000,
                8.0,
                120
        );

        System.out.println(a.getAuditLog());
        System.out.println(e.toCSVRow());

        System.out.println("=== HashSet Demonstration ===");

        Loan loan1 = new HomeLoan(
                "HL100",
                "Applicant One",
                3000000,
                8.5,
                180
        );

        Loan loan2 = new HomeLoan(
                "hl100",
                "Applicant Two",
                4000000,
                9.0,
                240
        );

        Set<Loan> loanSet = new HashSet<>();

        loanSet.add(loan1);
        loanSet.add(loan2);

        System.out.println("HashSet size: " + loanSet.size());

        // Both loans have the same loanId ignoring case,
        // so equals() considers them equal and hashCode()
        // produces the same hash. Therefore only one entry remains.
    }
}