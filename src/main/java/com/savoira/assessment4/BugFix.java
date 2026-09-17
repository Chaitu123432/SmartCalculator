package com.savoira.assessment;

public class BugFix {

    // Original buggy implementation
    public static int sumEvensBuggy(int n) {
        int sum = 1;          // Bug 1: Initialized to 1 instead of 0
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1)   // Bug 2: Checks for odd numbers (i % 2 == 1)
                sum += i;
        }
        return sum;
    }

    // Fixed implementation
    public static int sumEvensFixed(int n) {
        int sum = 0;          // Fixed: Initialized to 0
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0)   // Fixed: Checks for even numbers (i % 2 == 0)
                sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("Testing sumEvens with n = " + n);
        System.out.println("Buggy Output: " + sumEvensBuggy(n)); // Returns 26
        System.out.println("Fixed Output: " + sumEvensFixed(n)); // Returns 30 (Expected)
    }
}