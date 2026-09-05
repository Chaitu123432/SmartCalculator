package com.savoira.w6;

public class InvalidAmountException extends PaymentException {

    public InvalidAmountException(String message) {
        super(message);
    }
}