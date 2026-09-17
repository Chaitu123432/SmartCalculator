package com.savoira;

/**
 * Exception thrown when an attempt is made to divide by zero.
 */
public class ModuloByZeroException extends ArithmeticException {

  /**
   * Creates a division-by-zero exception with a default message.
   */
  public ModuloByZeroException() {
    super("Cannot perform modulo by zero.");
  }
}