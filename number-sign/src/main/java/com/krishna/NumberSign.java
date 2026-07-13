package com.krishna;

public class NumberSign {

    public static String checkSign(int number) {
        if (number > 0) {
            return number + " is positive.";
        }

        if (number < 0) {
            return number + " is negative.";
        }

        return "The number is zero.";
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java NumberSign <number>");
            System.exit(1);
        }

        try {
            int number = Integer.parseInt(args[0]);
            System.out.println(checkSign(number));
        } catch (NumberFormatException exception) {
            System.err.println("Please provide a valid integer.");
            System.exit(1);
        }
    }
}