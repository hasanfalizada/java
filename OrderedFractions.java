package dev;

public class OrderedFractions {
    public static void main(String[] args) {
        int maxD = 1000_000;
        int targetN = 3;
        int targetD = 7;
        int leftN = 0;
        int leftD = 1;

        for (int q = 2; q <= maxD; q++) {
            int p = (targetN * q - 1) / targetD; // Largest possible numerator for fraction less than 3/7

            if (gcd(p, q) == 1) {
                // If the fraction is in reduced form, check if it's closer to 3/7 than the current best.
                if ((long) leftN * q < (long) p * leftD) {
                    leftN = p;
                    leftD = q;
                }
            }
        }

        System.out.println("The numerator of the fraction immediately to the left of 3/7 with d <= 10000 is: " + leftN);
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}
