package dev;

public class PowerfulDigitCounts {

    public static void main(String[] args) {
        int overallCount = 0;
        int n = 1;
        int count;

        while ((count = countNDigitNthPowers(n)) > 0) {
            overallCount += count;
            n++;
        }

        System.out.println("The overall count of n-digit nth powers is: " + overallCount);
    }

    private static int countNDigitNthPowers(int n) {
        // Lower bound for nth root of 10^(n-1)
        int lowerBound = (int) Math.ceil(Math.pow(10, (n - 1) / (double) n));
        // Upper bound is 10 - 1, because 10^n has n+1 digits
        int upperBound = 10 - 1;
        int count = 0;

        for (int x = lowerBound; x <= upperBound; x++) {
            if (Math.pow(x, n) < Math.pow(10, n)) {
                count++;
            }
        }

        return count;
    }
}
