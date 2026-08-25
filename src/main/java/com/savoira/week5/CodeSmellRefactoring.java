package com.savoira.week5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CodeSmellRefactoring {

    private static final Logger logger =
            LoggerFactory.getLogger(CodeSmellRefactoring.class);

    /*
     * CODE SMELL 1: Poor Naming
     *
     * Original:
     * void process(List<Loan> l)
     *
     * The parameter name "l" gives no meaningful information
     * about what the list contains.
     *
     * Refactoring:
     * Use a descriptive name such as "loans".
     *
     *
     * CODE SMELL 2: Magic Numbers
     *
     * Original:
     * if(l.get(i).principal > 500000
     *         && l.get(i).principal < 2000000)
     *
     * The values 500000 and 2000000 have unexplained meanings.
     * Named constants make the business rule clear and easier
     * to maintain.
     *
     * The indexed loop and repeated l.get(i) calls are also
     * unnecessarily verbose. An enhanced for-loop makes the
     * method simpler and easier to read.
     */

    private static final double MIN_PRINCIPAL = 500_000;
    private static final double MAX_PRINCIPAL = 2_000_000;

    public static void processLoans(List<Loan> loans) {

        for (Loan loan : loans) {
            if (loan.principal > MIN_PRINCIPAL
                    && loan.principal < MAX_PRINCIPAL) {

                logger.info("Loan ID: {}", loan.loanId);
            }
        }
    }
}
