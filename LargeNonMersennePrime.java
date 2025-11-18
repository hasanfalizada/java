package dev;

import java.math.BigInteger;

public class LargeNonMersennePrime {

    public static void main(String[] args) {
        // We need to find the last 10 digits of: 28433 × 2^7830457 + 1

        long modulo = 10_000_000_000L; // 10^10 for last 10 digits

        // Calculate 2^7830457 mod 10^10 using modular exponentiation
        BigInteger base = BigInteger.valueOf(2);
        BigInteger exponent = BigInteger.valueOf(7830457);
        BigInteger mod = BigInteger.valueOf(modulo);

        // Using BigInteger's modPow for efficient modular exponentiation
        BigInteger powerMod = base.modPow(exponent, mod);

        // Multiply by 28433
        BigInteger result = powerMod.multiply(BigInteger.valueOf(28433));

        // Add 1
        result = result.add(BigInteger.ONE);

        // Take mod 10^10 to get last 10 digits
        result = result.mod(mod);

        // Format with leading zeros if necessary
        String lastTenDigits = String.format("%010d", result.longValue());

        System.out.println("The last 10 digits of the prime 28433 × 2^7830457 + 1 are:");
        System.out.println(lastTenDigits);
    }
}
