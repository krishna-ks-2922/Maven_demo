package com.krishna;

public class OddEven {

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static String checkNumber(int number) {
        if (isEven(number)) {
            return number + " is an even number.";
        }

        return number + " is an odd number.";
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java OddEven <number>");
            System.exit(1);
        }

        try {
            int number = Integer.parseInt(args[0]);
            System.out.println(checkNumber(number));
        } catch (NumberFormatException exception) {
            System.err.println("Please provide a valid integer.");
            System.exit(1);
        }
    }
}