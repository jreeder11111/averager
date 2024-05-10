package com.reederhome;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    /**
     * Calculates the average for a list of numbers inputted as follows:
     * <count> <list> <of> <numbers> (separated by whitespace)
     * 
     * If count = 0, the program exists
     * If the count doesn't match the number of inputs or if the inputs can't be parsed as integers, the program prints an error
     * Otherwise, the program prints the average of the numbers
     * 
     * @param args Not used
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                try {
                    String input = scanner.nextLine();
                    int[] numbers = ParserUtil.parseInts(input);
                    if (Arrays.equals(numbers, new int[0])) {
                        break;
                    }
                    System.out.println(NumbersUtil.calculateAverage(numbers));
                } catch (IllegalArgumentException e) {
                    System.err.println("Unexpected input");
                }
            }
        }
    }
}