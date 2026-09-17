package com.savoira.week3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

/*
 * Expected Test Outputs:
 *
 * Test Case 1:
 * Result: 13.00
 *
 * Test Case 2:
 * Error: Division by zero
 *
 * Test Case 3:
 * Error: Unknown operator '^'
 */

public class SmartCalc {

    private static final Logger logger = LoggerFactory.getLogger(SmartCalc.class);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            logger.info("Enter first number (or 'exit' to quit): ");
            String firstInput = scanner.nextLine();

            if (firstInput.equalsIgnoreCase("exit")) {
                break;
            }

            double num1 = Double.parseDouble(firstInput);

            logger.info("Enter operator (+, -, *, /, %): ");
            String operator = scanner.nextLine();

            if (operator.equalsIgnoreCase("exit")) {
                break;
            }

            logger.info("Enter second number: ");
            String secondInput = scanner.nextLine();

            if (secondInput.equalsIgnoreCase("exit")) {
                break;
            }

            double num2 = Double.parseDouble(secondInput);

            try {
                double result = switch (operator) {
                    case "+" -> num1 + num2;
                    case "-" -> num1 - num2;
                    case "*" -> num1 * num2;
                    case "/" -> {
                        if (num2 == 0) {
                            throw new ArithmeticException("Division by zero");
                        }
                        yield num1 / num2;
                    }
                    case "%" -> {
                        if (num2 == 0) {
                            throw new ArithmeticException("Division by zero");
                        }
                        yield num1 % num2;
                    }
                    default -> throw new IllegalArgumentException(
                            "Unknown operator '" + operator + "'"
                    );
                };

                logger.info("Result: {}", String.format("%.2f", result));

            } catch (ArithmeticException e) {
                logger.error("Error: {}", e.getMessage());

            } catch (IllegalArgumentException e) {
                logger.error("Error: {}", e.getMessage());
            }
        }

        scanner.close();
        logger.info("Calculator exited.");
    }
}