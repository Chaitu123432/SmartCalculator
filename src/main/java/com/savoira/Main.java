package com.savoira;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        

        Scanner sc = new Scanner(System.in);
        System.out.println("=== SmartCalculator ===");
        System.out.println("Type 'exit' to quit.");
        while (true) {
            System.out.print("Enter first number (or 'exit'): ");
            String input = sc.nextLine().trim();
            if (input.equalsIgnoreCase("exit")) break;
            double x = Double.parseDouble(input);
            System.out.print("Enter operator (+ - * / %): ");
            String op = sc.nextLine().trim();
            System.out.print("Enter second number: ");
            double y = Double.parseDouble(sc.nextLine().trim());
            double result = switch (op) {
                case "+" -> x + y;
                case "-" -> x - y;
                case "*" -> x * y;
                case "/" -> {
                    if (y == 0) { System.out.println("Error: division by zero"); yield
                            Double.NaN; }
                    else yield x / y;
                }
                case "%" -> x % y;
                default -> { System.out.println("Unknown operator"); yield
                        Double.NaN; }
            };
            if (!Double.isNaN(result))
                System.out.printf("Result: %.2f%n", result);
        }
        System.out.println("Goodbye!");
    }
}