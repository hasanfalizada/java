package dev;

import java.math.BigInteger;

public class DiophantineEquation {
    public static void main(String[] args) {
        BigInteger max_x = BigInteger.ZERO;
        int result_D = 0;

        for (int D = 2; D <= 1000; D++) {
            if (!isSquare(D)) {
                BigInteger x = findMinimalX(D);
                if (x.compareTo(max_x) > 0) {
                    max_x = x;
                    result_D = D;
                }
            }
        }

        System.out.println("The value of D <= 1000 that produces the largest x is: " + result_D);
        System.out.println("The largest x is: " + max_x);
    }

    private static boolean isSquare(int n) {
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }

    private static BigInteger findMinimalX(int D) {
        BigInteger m = BigInteger.ZERO;
        BigInteger d = BigInteger.ONE;
        BigInteger a = BigInteger.valueOf((long) Math.sqrt(D));
        BigInteger initialA = a;

        BigInteger num1 = BigInteger.ONE;
        BigInteger num = a;

        BigInteger den1 = BigInteger.ZERO;
        BigInteger den = BigInteger.ONE;

        while (!num.multiply(num).subtract(BigInteger.valueOf(D).multiply(den).multiply(den)).equals(BigInteger.ONE)) {
            m = d.multiply(a).subtract(m);
            d = BigInteger.valueOf(D).subtract(m.multiply(m)).divide(d);
            a = initialA.add(m).divide(d);

            BigInteger num2 = num1;
            num1 = num;
            num = a.multiply(num1).add(num2);

            BigInteger den2 = den1;
            den1 = den;
            den = a.multiply(den1).add(den2);
        }

        return num;
    }

}
