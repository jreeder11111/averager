package com.reederhome;

public class NumbersUtil {
    
    /** 
     * Averages the list of numbers passed in.
     *
     * @param numbers Array of numbers to average
     * @return double The average
     * @throws IllegalArgumentException if input is null or empty
     */
    public static double calculateAverage(int[] numbers) throws IllegalArgumentException {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Input is null or an empty list");
        }

        double rval = 0.0;
        for (int i = 0; i < numbers.length; i++) {
            rval += numbers[i];
        }

        return rval / numbers.length;
    }
}
