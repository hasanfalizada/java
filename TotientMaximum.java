package dev;

public class TotientMaximum {

    public static void main(String[] args) {
        int limit = 1000000;
        double maxRatio = 0;
        int result = 0;

        for (int i = 2; i <= limit; i++) {
            double ratio = (double) i / phi(i);
            if (ratio > maxRatio) {
                maxRatio = ratio;
                result = i;
            }
        }

        System.out.println("The value of n ≤ 1,000,000 for which n/φ(n) is a maximum is: " + result);
    }

    // Calculates Euler's totient function φ(n)
    public static int phi(int n) {
        int result = n;

        for (int p = 2; p * p <= n; p++) {
            if (n % p == 0) {
                result -= result / p;
                while (n % p == 0) {
                    n /= p;
                }
            }
        }

        if (n > 1) {
            result -= result / n;
        }

        return result;
    }
}
