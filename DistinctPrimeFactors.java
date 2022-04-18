package devjava;

import java.util.HashSet;
import java.util.Set;

public class DistinctPrimeFactors {
	static boolean isPrime(int factor) {
		int counter = 0;
		for (int i = 1; i <= Math.sqrt(factor); i++) {
			if (factor % i == 0) {
				counter++;
			}
			if (counter >= 2) {
				return false;
			}
		}
		return true;
	}

	static Set<Integer> getDistinctPrimeFactors(int n, Set<Integer> factors) {
		if (isPrime(n)) {
			factors.add(n);
			return factors;
		} else {
			for (int i = 2; i < (n / 2); i++) {
				if (n % i == 0) {
					factors.add(i);
					factors.addAll(getDistinctPrimeFactors(n / i, factors));
					break;
				}
			}
		}
		return factors;
	}

	public static void main(String[] args) {
		for (int i = 5; i <= 1000000; i++) {
			if (getDistinctPrimeFactors(i - 3, new HashSet<Integer>()).size()
					+ getDistinctPrimeFactors(i - 2, new HashSet<Integer>()).size()
					+ getDistinctPrimeFactors(i - 1, new HashSet<Integer>()).size()
					+ getDistinctPrimeFactors(i, new HashSet<Integer>()).size() == 16) {
				System.out.println((i - 3) + " / " + (i - 2) + " / " + (i - 1) + " / " + i);
			}
		}
	}
}
