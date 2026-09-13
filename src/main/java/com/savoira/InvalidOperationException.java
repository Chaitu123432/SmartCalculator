package com.savoira;

/**
 * Exception thrown when an unsupported mathematical operation is requested.
 */
public class InvalidOperationException extends RuntimeException {

    /**
     * Creates an invalid-operation exception.
     *
     * @param message description of the invalid operation
     */
    public InvalidOperationException(String message) {
        super(message);
    }
}