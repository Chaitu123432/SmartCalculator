package com.savoira;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

/**
 * Entry point for the SmartCalculator command-line application.
 *
 * <p>This class handles user interaction and delegates
 * calculations to the {@link Calculator} class.</p>
 */
public class Main {

    private static final Logger logger =
            LoggerFactory.getLogger(Main.class);

    /**
     * Starts the SmartCalculator command-line application.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        try (Scanner scanner = new Scanner(System.in)) {

            logger.info("=== SmartCalculator ===");
            logger.info("Type 'exit' to quit.");
            logger.info(
                    "Supported operations: "
                            + "+, -, *, /, %, sqrt, percentage"
            );

            // PolymorphismDemo.run();

            while (true) {

                logger.info("Enter first number (or 'exit'): ");

                String firstInput = scanner.nextLine().trim();

                if (firstInput.equalsIgnoreCase("exit")) {
                    break;
                }

                Double firstOperand = parseNumber(firstInput);

                if (firstOperand == null) {
                    continue;
                }

                logger.info(
                        "Enter operator (+ - * / % sqrt percentage): "
                );

                String operator = scanner.nextLine().trim();

                if (!calculator.isValidOperator(operator)) {

                    logger.error(
                            "Invalid operation: Unsupported operator: {}",
                            operator
                    );

                    continue;
                }

                Double secondOperand = null;

                if (calculator.requiresSecondOperand(operator)) {

                    logger.info("Enter second number: ");

                    String secondInput =
                            scanner.nextLine().trim();

                    secondOperand = parseNumber(secondInput);

                    if (secondOperand == null) {
                        continue;
                    }
                }

                try {

                    double result = calculator.calculate(
                            firstOperand,
                            operator,
                            secondOperand
                    );

                    logger.info(
                            "Result: {}",
                            String.format("%.2f", result)
                    );

                } catch (DivisionByZeroException exception) {

                    logger.error(
                            "Calculation error : {}",
                            exception.getMessage()
                    );

                } catch (ArithmeticException exception) {

                    logger.error(
                            "Calculation error:  {}",
                            exception.getMessage()
                    );

                } catch (IllegalArgumentException exception) {

                    logger.error(
                            "Calculation  error: {}",
                            exception.getMessage()
                    );
                }
            }

            logger.info("Goodbye!");
        }
    }

    /**
     * Converts user input into a numerical value.
     *
     * @param input user input to parse
     * @return parsed number, or {@code null} when input is invalid
     */
    private static Double parseNumber(String input) {

        if (input.isBlank()) {
            logger.error("Please enter a valid number.");
            return null;
        }

        try {

            double number = Double.parseDouble(input);

            if (!Double.isFinite(number)) {
                logger.error("Please enter a finite number.");
                return null;
            }

            return number;

        } catch (NumberFormatException exception) {

            logger.error("Please enter a valid number.");
            return null;
        }
    }
}