package com.savoira;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Demonstrates runtime polymorphism using the Calculable interface.
 */
public class PolymorphismDemo {

    private static final Logger logger =
            LoggerFactory.getLogger(PolymorphismDemo.class);

    /**
     * Runs the polymorphism demonstration.
     */
    public static void run() {

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