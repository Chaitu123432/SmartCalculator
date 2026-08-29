package com.savoira;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;

/**
 * Entry point for the SmartCalculator command-line application.
 *
 * <p>This class handles user input and delegates calculations
 * to the appropriate operation classes.</p>
 */
public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    /**
     * Starts the SmartCalculator command-line application.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

            logger.info("=== SmartCalculator ===");
            logger.info("Type 'exit' to quit.");
            logger.info("Supported operations: +, -, *, /, %, sqrt, percentage");

            runPolymorphismDemo();

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

                if (operator.isEmpty()) {
                    logger.error("Operator cannot be empty.");
                    continue;
                }

                Double secondOperand = null;

                if (requiresSecondOperand(operator)) {

                    logger.info("Enter second number: ");

                    String secondInput = scanner.nextLine().trim();

                    secondOperand = parseNumber(secondInput);

                    if (secondOperand == null) {
                        continue;
                    }
                }

                try {

                    Calculable operation = createOperation(
                            firstOperand,
                            operator,
                            secondOperand
                    );

                    double result = operation.calculate();

                    logger.info(
                            "Result: {}",
                            String.format("%.2f", result)
                    );

                } catch (InvalidOperationException exception) {
                    logger.error(
                            "Invalid operation: {}",
                            exception.getMessage()
                    );

                } catch (DivisionByZeroException exception) {
                    logger.error(
                            "Calculation error: {}",
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
            logger.error(
                    "Please enter a valid number."
            );
            return null;
        }

        try {
            return Double.parseDouble(input);

        } catch (NumberFormatException exception) {
            logger.error(
                    "Please enter a valid number."
            );
            return null;
        }
    }

    /**
     * Determines whether an operation requires a second operand.
     *
     * @param operator mathematical operator
     * @return true when a second operand is required
     */
    private static boolean requiresSecondOperand(String operator) {

        return !operator.equalsIgnoreCase("sqrt")
                && !operator.equalsIgnoreCase("square-root");
    }

    /**
     * Creates the appropriate calculation object based on the operator.
     *
     * @param firstOperand first operand
     * @param operator requested mathematical operator
     * @param secondOperand second operand, when required
     * @return an operation implementing {@link Calculable}
     * @throws InvalidOperationException when the operator is unsupported
     */
    private static Calculable createOperation(
            double firstOperand,
            String operator,
            Double secondOperand
    ) {

        return switch (operator.toLowerCase()) {

            case "+" -> new Addition(
                    firstOperand,
                    requireSecondOperand(secondOperand, operator)
            );

            case "-" -> new Subtraction(
                    firstOperand,
                    requireSecondOperand(secondOperand, operator)
            );

            case "*" -> new Multiplication(
                    firstOperand,
                    requireSecondOperand(secondOperand, operator)
            );

            case "/" -> new Division(
                    firstOperand,
                    requireSecondOperand(secondOperand, operator)
            );

            case "%" -> new Modulo(
                    firstOperand,
                    requireSecondOperand(secondOperand, operator)
            );

            case "sqrt", "square-root" -> new SquareRoot(firstOperand);

            case "percentage" -> new Percentage(
                    firstOperand,
                    requireSecondOperand(secondOperand, operator)
            );

            default -> throw new InvalidOperationException(
                    "Unsupported operator: " + operator
            );
        };
    }

    /**
     * Ensures that a second operand exists when required.
     *
     * @param secondOperand second operand
     * @param operator operator requiring the operand
     * @return the second operand
     * @throws InvalidOperationException when the operand is missing
     */
    private static double requireSecondOperand(
            Double secondOperand,
            String operator
    ) {

        if (secondOperand == null) {
            throw new InvalidOperationException(
                    "Operator '" + operator + "' requires two operands."
            );
        }

        return secondOperand;
    }

    /**
     * Demonstrates runtime polymorphism using the Calculable interface.
     */
    private static void runPolymorphismDemo() {

        logger.info("=== Polymorphism Demo ===");

        List<Calculable> operations = List.of(
                new Addition(10, 4),
                new Subtraction(10, 4),
                new Multiplication(10, 4),
                new Division(10, 4)
        );

        for (Calculable operation : operations) {
            logger.info(operation.toString());
        }

        logger.info("=== End Polymorphism Demo ===");
    }
}