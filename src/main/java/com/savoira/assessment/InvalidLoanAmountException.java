package com.savoira.assessment;

public class InvalidLoanAmountException extends LoanException {

    public InvalidLoanAmountException(String message) {
        super(message);
    }
}