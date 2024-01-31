package dev;

public class SpiralPrimes {
    static boolean isPrime(int n) {
        if (n <= 3) return n > 1;
        if (n % 2 == 0 || n % 3 == 0) return false;

        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        /*
         * Higher left: 4*n*n+1
         * Higher right: 4*n*n-2*n+1
         * Lower left: 4*n*n+2*n+1
         * Lower right: 4*n*n+4*n+1 (that is always square)
         */

        int length = 1;
        int i;

        double ratio = 0.1;
        double primeValuesCounter = 0.0;
        double totalValuesCount = 0.0;

        while (ratio >= 0.1) {

            length += 2;

            totalValuesCount = length / 2 * 4 + 1;

            i = length / 2;

            if (isPrime(4 * i * i + 1)) {
                primeValuesCounter++;
            }

            if (isPrime(4 * i * i - 2 * i + 1)) {
                primeValuesCounter++;
            }

            if (isPrime(4 * i * i + 2 * i + 1)) {
                primeValuesCounter++;
            }

            ratio = primeValuesCounter / totalValuesCount;

        }

        System.out.println("N: " + length + "; Total: " + totalValuesCount + "; Prime: " + primeValuesCounter + "; Ratio: " + ratio);

    }
}
