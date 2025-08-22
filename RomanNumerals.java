package dev;

import java.io.*;
import java.util.*;

public class RomanNumerals {

    // Roman numeral values in descending order for conversion to minimal form
    private static final int[] VALUES = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] NUMERALS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    /**
     * Converts a Roman numeral string to its integer value
     */
    public static int romanToInt(String roman) {
        Map<Character, Integer> values = new HashMap<>();
        values.put('I', 1);
        values.put('V', 5);
        values.put('X', 10);
        values.put('L', 50);
        values.put('C', 100);
        values.put('D', 500);
        values.put('M', 1000);

        int result = 0;
        int prevValue = 0;

        // Process from right to left
        for (int i = roman.length() - 1; i >= 0; i--) {
            int currentValue = values.get(roman.charAt(i));

            // If current value is less than previous, subtract it (subtractive notation)
            if (currentValue < prevValue) {
                result -= currentValue;
            } else {
                result += currentValue;
            }

            prevValue = currentValue;
        }

        return result;
    }

    /**
     * Converts an integer to its minimal Roman numeral representation
     */
    public static String intToMinimalRoman(int num) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < VALUES.length; i++) {
            while (num >= VALUES[i]) {
                result.append(NUMERALS[i]);
                num -= VALUES[i];
            }
        }

        return result.toString();
    }

    /**
     * Calculates the total character savings by converting Roman numerals to minimal form
     */
    public static int calculateSavings(String filename) throws IOException {
        int totalSavings = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    // Convert Roman numeral to integer
                    int value = romanToInt(line);

                    // Convert integer back to minimal Roman numeral
                    String minimal = intToMinimalRoman(value);

                    // Calculate savings
                    int savings = line.length() - minimal.length();
                    totalSavings += savings;

                    // Debug output for first few examples
                    if (totalSavings <= 50) { // Show first few for verification
                        System.out.println(line + " (" + value + ") -> " + minimal +
                                " (saved: " + savings + " characters)");
                    }
                }
            }
        }

        return totalSavings;
    }

    /**
     * Process Roman numerals directly from a string containing all the data
     */
    public static int calculateSavingsFromString(String data) {
        int totalSavings = 0;
        String[] lines = data.split("\n");

        for (String line : lines) {
            line = line.trim();
            if (!line.isEmpty()) {
                // Convert Roman numeral to integer
                int value = romanToInt(line);

                // Convert integer back to minimal Roman numeral
                String minimal = intToMinimalRoman(value);

                // Calculate savings
                int savings = line.length() - minimal.length();
                totalSavings += savings;

                // Debug output for first few examples
                if (totalSavings <= 50) { // Show first few for verification
                    System.out.println(line + " (" + value + ") -> " + minimal +
                            " (saved: " + savings + " characters)");
                }
            }
        }

        return totalSavings;
    }

    public static void main(String[] args) {
        try {
            System.out.println("Roman Numeral Optimizer");
            System.out.println("=======================");
            System.out.println();

            // Sample data from your document (first few lines for testing)
            String sampleData = """
                    MMMMDCLXXII
                    MMDCCCLXXXIII
                    MMMDLXVIIII
                    MMMMDXCV
                    DCCCLXXII
                    MMCCCVI
                    MMMCDLXXXVII
                    MMMMCCXXI
                    MMMCCXX
                    MMMMDCCCLXXIII
                    """;

            System.out.println("Processing sample data:");
            int sampleSavings = calculateSavingsFromString(sampleData);
            System.out.println("Sample savings: " + sampleSavings);
            System.out.println();

            // For file processing
            String filename = "roman.txt";
            int totalSavings = calculateSavings(filename);
            System.out.println("Total characters saved from file: " + totalSavings);

        } catch (IOException e) {
            System.err.println("Could not read file (this is expected if file doesn't exist)");
            System.out.println("You can copy the Roman numerals to a file named 'roman.txt' to process the full dataset.");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}