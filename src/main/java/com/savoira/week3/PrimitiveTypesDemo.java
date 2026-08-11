package com.savoira.week3;

public class PrimitiveTypesDemo {

    public static void main(String[] args) {

        // Block 1: integer division
        int a = 17, b = 5;
        System.out.println(a / b);
        System.out.println(a % b);
        System.out.println((double) a / b);

        // Block 2: Integer cache
        Integer x = 127;
        Integer y = 127;
        Integer p = 200;
        Integer q = 200;

        System.out.println(x == y);
        System.out.println(p == q);
        System.out.println(p.equals(q));

        // Values from -128 to 127 are cached, so == compares the same cached
        // object for 127, while 200 creates different Integer objects.
    }
}