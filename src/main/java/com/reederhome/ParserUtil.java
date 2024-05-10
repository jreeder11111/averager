package com.reederhome;

import java.util.regex.PatternSyntaxException;

public class ParserUtil {
    /**
     * Parses a input string consisting of the count of numbers and then the sequence itself.
     * All values are separated by whitespace.
     * 
     * @param input Input string
     * @return Array of integers
     * @throws IllegalArgumentException if the input string is empty, can't be parsed as a sequence of numbers, or if the count does not match the number of arguments
     */
    public static int[] parseInts(String input) throws IllegalArgumentException {
        // Split the input
        String[] strings = null; 
        try {
            strings = input.split("\\s+");
        } catch (NullPointerException npe) {
            throw new IllegalArgumentException("Input string is null");
        } catch (PatternSyntaxException  e) {
            throw new IllegalArgumentException("Unable to parse input string");
        }

        int count = 0;
        try {
            count = Integer.parseInt(strings[0]);
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            throw new IllegalArgumentException("Unable to get the count from the input string");
        }

        if (count != strings.length - 1) {
            throw new IllegalArgumentException("The count (" + count + ") doesn't match the number of values passed in (" + (strings.length - 1) + ")");
        }

        int[] rval = new int[count];
        try {
            for (int i = 0; i < count; i++) {
                rval[i] = Integer.parseInt(strings[i+1]);
            }
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("Unable to parse one or more of the values");
        }

        return rval;
    }
}
