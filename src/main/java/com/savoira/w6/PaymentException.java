package com.savoira.w6;

public class PaymentException extends RuntimeException {

    public PaymentException(String message) {
        super(message);
    }
}