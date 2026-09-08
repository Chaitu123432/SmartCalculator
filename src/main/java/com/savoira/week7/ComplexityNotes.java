package com.savoira.week7;

public class ComplexityNotes {

    /*
     * Scenario 1: Finding one account by ID
     *
     * Linear scan:
     * Big O = O(n)
     *
     * HashMap lookup:
     * Big O = O(1) average
     *
     * For 1 million accounts, choose HashMap lookup because
     * it provides constant-time average lookup instead of
     * potentially scanning the entire list.
     */


    /*
     * Scenario 2: Finding all overdue accounts
     *
     * Nested loop comparing every pair:
     * Big O = O(n^2)
     *
     * Single pass with a Set of overdue IDs:
     * Big O = O(n) average
     *
     * For 1 million accounts, choose the single-pass approach
     * with a Set because O(n) scales much better than O(n^2).
     */


    /*
     * Summary:
     *
     * Finding one account:
     * Linear scan       -> O(n)
     * HashMap lookup    -> O(1) average
     *
     * Finding overdue accounts:
     * Nested loop       -> O(n^2)
     * Single pass + Set -> O(n) average
     *
     * Preferred approaches for 1 million accounts:
     * 1. HashMap lookup
     * 2. Single pass with a Set
     */
}