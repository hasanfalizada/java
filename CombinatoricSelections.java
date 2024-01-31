package dev;

import java.math.BigInteger;

public class CombinatoricSelections {

    static public BigInteger fac(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++)
            result = result.multiply(BigInteger.valueOf(i));
        return result;
    }

    static public BigInteger combinatoricSelections(int n, int r) {
        return fac(n).divide(fac(r).multiply(fac(n - r)));
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        BigInteger comSel = new BigInteger("0");
        int counter = 0;
        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= i; j++) {
                comSel = combinatoricSelections(i, j);
                if (comSel.compareTo(new BigInteger("1000000")) == 1) {
                    counter++;
                }
            }
        }
        long endTime = System.nanoTime();
        long totalTime = (endTime - startTime)/1_000_000;
        System.out.println(totalTime + " milliseconds");
        System.out.println(counter);
    }
}
