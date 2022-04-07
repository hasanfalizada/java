package devjava;

public class Goldbach {

	static boolean isPerfectSquare(double x) {
		double sq = Math.sqrt(x);
		return ((sq - Math.floor(sq)) == 0);
	}

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

	static boolean isOddComposite(int digit) {
		if (digit % 2 == 1 && !isPrime(digit)) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {

		for (int i = 1; i <= 10000; i++) {
			int solutionsCount = 0;
			if (isOddComposite(i)) {
				for (int j = 0; j <= i; j++) {
					int primeCandidate = i - j;
					if (isPrime(primeCandidate)) {
						int diff = i - primeCandidate;
						if (diff % 2 == 0 && isPerfectSquare(diff / 2)) {
							solutionsCount++;
						}
					}
				}
				if (solutionsCount == 0) {
					System.out.println("No solutions for " + i + "!");
					System.exit(0);
				}
			}
		}
	}
}
