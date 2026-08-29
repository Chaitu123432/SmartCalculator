package com.savoira;

/**
 * Exception thrown when an attempt is made to divide by zero.
 */
public class DivisionByZeroException extends ArithmeticException {

    /**
     * Creates a division-by-zero exception with a default message.
     */
    public DivisionByZeroException() {
        super("Cannot divide by zero.");
    }
}