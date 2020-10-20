package devjava;

import java.util.HashSet;
import java.util.Set;

public class TruncatablePrimes {
	static boolean isPrime(int factor) {
		int counter = 0;
		for (int i = 1; i <= Math.sqrt(factor); i++) {
			if (factor % i == 0) {
				counter++;
			}
			if (counter >= 2 || factor == 1) {
				return false;
			}
		}
		return true;
	}

	static boolean isTruncatable(int truncatable) {
		Set<Integer> truncates = new HashSet<Integer>();
		truncates.add(truncatable);
		String truncatableString = Integer.toString(truncatable);
		for (int i = 1; i < truncatableString.length(); i++) {
			truncates.add(Integer.valueOf(truncatableString.substring(0, i)));
		}
		for (int i = truncatableString.length() - 1; i >= 0; i--) {
			truncates.add(Integer.valueOf(truncatableString.substring(i, truncatableString.length())));
		}

		for (Integer i : truncates) {
			if (!isPrime(i)) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		for (int i = 8; i <= 10_000_000_00; i++) {
			if (isTruncatable(i)) {
				System.out.println(i);
			}
		}

	}

}
