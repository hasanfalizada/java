package dev;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class SquareRootDigitalExpansion {


    public static void main(String[] args) {

        int finalSum = 0;

        for (int i = 1; i <= 100; i++) {
            if (!isPerfectSquare(i)) {
                BigDecimal sqrt2 = new BigDecimal(i).sqrt(new MathContext(110, RoundingMode.FLOOR));
                String sqrt2Str = sqrt2.toPlainString().substring(0, 102).replace(".", "").substring(0, 100);  // Skip "1."
                int sum = 0;
                for (char digit : sqrt2Str.toCharArray()) {
                    sum += Character.getNumericValue(digit);
                }
                finalSum += sum;
            }
        }

        System.out.println(finalSum);
    }

    public static boolean isPerfectSquare(int number) {
        if (number < 0) {
            return false; // Negative numbers cannot be perfect squares
        }

        int sqrt = (int) Math.sqrt(number); // Calculate the integer part of the square root
        return (sqrt * sqrt == number); // Check if squaring it gives the original number
    }
}
