package com.savoira.assessment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MathUtilsDemo {

    private static final Logger logger = LoggerFactory.getLogger(MathUtilsDemo.class);

    public static void main(String[] args) {
        logger.info("Rounded: {}", MathUtils.roundToTwoDecimalPlaces(123.4567));
        logger.info("Simple Interest: {}", MathUtils.calculateSimpleInterest(10000, 5, 2));
        logger.info("Compound Interest: {}", MathUtils.calculateCompoundInterest(10000, 5, 4, 2));
    }
}
