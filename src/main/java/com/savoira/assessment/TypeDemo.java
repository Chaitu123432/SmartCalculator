package com.savoira.assessment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TypeDemo {

    private static final Logger logger = LoggerFactory.getLogger(TypeDemo.class);

    public static void main(String[] args) {
        // Block 1 prediction: 4, 1, 4.5
        int a = 9, b = 2;
        logger.info("{}", a / b);
        logger.info("{}", a % b);
        logger.info("{}", (double) a / b);

        // Block 2 prediction: true, false, true
        Integer x = 100;
        Integer y = 100;
        Integer p = 200;
        Integer q = 200;
        logger.info("{}", x == y);
        logger.info("{}", p == q);
        logger.info("{}", p.equals(q));

        // WHY the results differ:
        // Integer values from -128 through 127 are cached by Java, so x and y
        // refer to the same cached Integer object. Values outside that cache
        // range, such as 200, are normally represented by different objects.
        // Therefore == compares different references for p and q and returns false.
        // equals() compares the Integer values themselves, so p.equals(q) is true.
    }
}
