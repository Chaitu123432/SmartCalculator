package com.savoira.week7;

public class BugFixer {

    static double findLargest(double[] amounts) {

        // Bug 1 fix: max cannot start at 0 because all values could be negative.
        // Initialize max with the first element of the array instead.
        double max = amounts[0];

        // Bug 2 fix: valid array indexes stop at length - 1.
        // Using <= would cause ArrayIndexOutOfBoundsException.
        for (int i = 1; i < amounts.length; i++) {

            if (amounts[i] > max) {
                max = amounts[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {

        double[] amounts = {-500, -200, -1000, -300};

        System.out.println("Largest amount: " + findLargest(amounts));
    }
}