package dev;

public class CountingFractionsInARange {
    public static void main(String[] args) {
        int maxDenominator = 12000;
        int count = 0;

        for (int denominator = 2; denominator <= maxDenominator; denominator++) {
            int startNumerator = (denominator / 3) + 1; // first number greater than denominator/3
            int endNumerator = (denominator - 1) / 2; // last number less than denominator/2

            for (int numerator = startNumerator; numerator <= endNumerator; numerator++) {
                if (gcd(numerator, denominator) == 1) {
                    count++;
                }
            }
        }

        System.out.println("The number of reduced proper fractions between 1/3 and 1/2 for d <= 12000 is: " + count);
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
