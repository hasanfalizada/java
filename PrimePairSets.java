package dev;

import java.util.ArrayList;
import java.util.List;

public class PrimePairSets {

    // [13, 5197, 5701, 6733, 8389]
    public static void main(String[] args) {
        List<Integer> primes = generatePrimes(10000);
        List<List<Integer>> quintets = findPrimeQuintets(primes);

        for (List<Integer> quintet : quintets) {
            System.out.println(quintet);
        }
    }

    public static List<Integer> generatePrimes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static List<List<Integer>> findPrimeQuintets(List<Integer> primes) {
        List<List<Integer>> quintets = new ArrayList<>();

        for (int i = 0; i < primes.size(); i++) {
            for (int j = i + 1; j < primes.size(); j++) {
                int prime1 = primes.get(i);
                int prime2 = primes.get(j);
                if (isConcatenationPrime(prime1, prime2) && isConcatenationPrime(prime2, prime1)) {
                    for (int k = j + 1; k < primes.size(); k++) {
                        int prime3 = primes.get(k);
                        if (isConcatenationPrime(prime1, prime3) && isConcatenationPrime(prime3, prime1) && isConcatenationPrime(prime2, prime3) && isConcatenationPrime(prime3, prime2)) {
                            for (int l = k + 1; l < primes.size(); l++) {
                                int prime4 = primes.get(l);
                                if (isConcatenationPrime(prime1, prime4) && isConcatenationPrime(prime4, prime1) && isConcatenationPrime(prime2, prime4) && isConcatenationPrime(prime4, prime2) && isConcatenationPrime(prime3, prime4) && isConcatenationPrime(prime4, prime3)) {
                                    for (int m = l + 1; m < primes.size(); m++) {
                                        int prime5 = primes.get(m);
                                        if (isConcatenationPrime(prime1, prime5) && isConcatenationPrime(prime5, prime1) && isConcatenationPrime(prime2, prime5) && isConcatenationPrime(prime5, prime2) && isConcatenationPrime(prime3, prime5) && isConcatenationPrime(prime5, prime3) && isConcatenationPrime(prime4, prime5) && isConcatenationPrime(prime5, prime4)) {
                                            List<Integer> quintet = new ArrayList<>();
                                            quintet.add(prime1);
                                            quintet.add(prime2);
                                            quintet.add(prime3);
                                            quintet.add(prime4);
                                            quintet.add(prime5);
                                            quintets.add(quintet);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return quintets;
    }

    public static boolean isConcatenationPrime(int num1, int num2) {
        int concatenated1 = Integer.parseInt(String.valueOf(num1) + String.valueOf(num2));
        int concatenated2 = Integer.parseInt(String.valueOf(num2) + String.valueOf(num1));
        return isPrime(concatenated1) && isPrime(concatenated2);
    }
}
