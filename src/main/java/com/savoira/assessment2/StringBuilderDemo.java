package com.savoira.assessment2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringBuilderDemo {

    private static final Logger logger = LoggerFactory.getLogger(StringBuilderDemo.class);

    /**
     * Builds a transaction report from the supplied item descriptions.
     *
     * @param items transaction descriptions
     * @return report in the format "Report: item1 | item2 | item3"
     */
    public static String buildReport(String[] items) {
        if (items == null) {
            throw new IllegalArgumentException("Items cannot be null");
        }

        var report = new StringBuilder("Report: ");
        for (var i = 0; i < items.length; i++) {
            if (items[i] == null) {
                throw new IllegalArgumentException("Transaction description cannot be null");
            }
            if (i > 0) {
                report.append(" | ");
            }
            report.append(items[i]);
        }
        return report.toString();
    }

    public static void main(String[] args) {
        var transactions = new String[] {
                "Salary credit",
                "Grocery purchase",
                "Electricity bill",
                "ATM withdrawal",
                "Online transfer"
        };

        logger.info(buildReport(transactions));

        // StringBuilder is preferred over String concatenation in a loop because
        // it modifies one mutable buffer instead of repeatedly creating new
        // String objects for each concatenation.
    }
}
