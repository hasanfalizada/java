package dev;

import java.util.Arrays;

public class TotientPermutation {
    public static void main(String[] args) {
        int limit = 10000000; // 10^7
        double minRatio = Double.MAX_VALUE;
        int result = 0;

        for (int n = 2; n < limit; n++) {
            int phi = phi(n);
            if (isPermutation(n, phi)) {
                double ratio = (double) n / phi;
                if (ratio < minRatio) {
                    minRatio = ratio;
                    result = n;
                }
            }
        }

        System.out.println("The value of n is: " + result);
    }

    // Euler's totient function
    public static int phi(int n) {
        int result = n;

        for (int p = 2; p * p <= n; p++) {
            if (n % p == 0) {
                while (n % p == 0) {
                    n /= p;
                }
                result -= result / p;
            }
        }

        if (n > 1) {
            result -= result / n;
        }

        return result;
    }

    // Check if two numbers are permutations of each other
    public static boolean isPermutation(int a, int b) {
        char[] aDigits = String.valueOf(a).toCharArray();
        char[] bDigits = String.valueOf(b).toCharArray();
        Arrays.sort(aDigits);
        Arrays.sort(bDigits);
        return Arrays.equals(aDigits, bDigits);
    }
}

