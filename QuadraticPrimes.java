package devjava;

public class QuadraticPrimes {

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

	static int numberOfConsecutivePrimesGenerated(int a, int b) {
		for (int i = 0;; i++) {
			int n = i * i + i * a + b;
			if (n < 0 || !isPrime(n))
				return i;
		}

	}

	public static void main(String[] args) {
		int bestNum = 0;
		int bestA = 0;
		int bestB = 0;
		for (int a = -1000; a <= 1000; a++) {
			for (int b = -1000; b <= 1000; b++) {
				int num = numberOfConsecutivePrimesGenerated(a, b);
				if (num > bestNum) {
					bestNum = num;
					bestA = a;
					bestB = b;
				}
			}
		}
		System.out.println(bestA * bestB);
	}

}
