package com.savoira.assessment3;

public class InvalidLoanAmountException extends LoanException {

    public InvalidLoanAmountException(String message) {
        super(message);
    }
}