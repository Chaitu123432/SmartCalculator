package com.savoira.week3;

public class StringBuilderDemo {

    public static void main(String[] args) {

        StringBuilder builder = new StringBuilder();

        // StringBuilder is preferred over String concatenation inside a loop
        // because it modifies the existing object instead of creating a new
        // String object during every concatenation.
        for (int i = 1; i <= 10; i++) {
            builder.append(i).append(" ");
        }

        System.out.println(builder);
    }
}
