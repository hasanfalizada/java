package dev;

import java.math.BigInteger;
import java.util.function.Function;

public class ConvergentsOfE {
    public static void main(String[] args) {
        BigInteger[] convergent = getConvergent(100);
        System.out.println("Numerator of 100th convergent: " + convergent[0]);
        System.out.println("Sum of digits in the numerator of 100th convergent: " + sumOfDigits(convergent[0]));
    }

    private static BigInteger[] getConvergent(int n) {
        BigInteger h0 = BigInteger.valueOf(2);
        BigInteger h1 = BigInteger.valueOf(3);
        BigInteger k0 = BigInteger.ONE;
        BigInteger k1 = BigInteger.ONE;

        Function<Integer, BigInteger> a = (k) -> {
            if (k == 0) return BigInteger.valueOf(2);
            if (k % 3 == 2) return BigInteger.valueOf(2 * (k / 3 + 1));
            return BigInteger.ONE;
        };

        for (int i = 2; i < n; i++) {
            BigInteger hi = a.apply(i).multiply(h1).add(h0);
            BigInteger ki = a.apply(i).multiply(k1).add(k0);
            h0 = h1;
            h1 = hi;
            k0 = k1;
            k1 = ki;
        }

        return new BigInteger[]{h1, k1};
    }

    private static int sumOfDigits(BigInteger number) {
        String digits = number.toString();
        int sum = 0;

        for (int i = 0; i < digits.length(); i++) {
            sum += Character.digit(digits.charAt(i), 10);
        }

        return sum;
    }
}
