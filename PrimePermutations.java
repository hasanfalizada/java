package dev;

import java.util.Arrays;

public class PrimePermutations {
    public static void main(String[] args) {
        final int LIMIT = 10000;
        boolean[] isPrime = listPrimality(LIMIT - 1);
        for (int base = 1000; base < LIMIT; base++) {
            if (isPrime[base]) {
                for (int step = 1; step < LIMIT; step++) {
                    int a = base + step;
                    int b = a + step;
                    if (a < LIMIT && isPrime[a] && hasSameDigits(a, base) && b < LIMIT && isPrime[b] && hasSameDigits(b, base) && (base != 1487 || a != 4817))
                        System.out.println("" + base + a + b);
                }
            }
        }
    }

    private static boolean hasSameDigits(int x, int y) {
        char[] xdigits = Integer.toString(x).toCharArray();
        char[] ydigits = Integer.toString(y).toCharArray();
        Arrays.sort(xdigits);
        Arrays.sort(ydigits);
        return Arrays.equals(xdigits, ydigits);
    }

    public static boolean[] listPrimality(int n) {
        if (n < 0) throw new IllegalArgumentException("Negative size");
        boolean[] prime = new boolean[n + 1];
        if (n >= 2) prime[2] = true;
        for (int i = 3; i <= n; i += 2)
            prime[i] = true;// Sieve of Eratosthenes
        for (int i = 3, end = (int) Math.sqrt(n); i <= end; i += 2) {
            if (prime[i]) {
                for (int j = i * i; j <= n; j += i << 1) prime[j] = false;
            }
        }
        return prime;
    }
}
