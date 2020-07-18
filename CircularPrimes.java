package devjava;

public class CircularPrimes {

	public static boolean[] listPrimality(int n) {

		if (n < 0) {
			throw new IllegalArgumentException("Negative size");
		}

		boolean[] prime = new boolean[n + 1];

		if (n >= 2) {
			prime[2] = true;
		}

		for (int i = 3; i <= n; i += 2) {
			prime[i] = true;
		}

		for (int i = 3, end = (int) Math.sqrt(n); i <= end; i += 2) {
			if (prime[i]) {
				for (int j = i * i; j <= n; j += i << 1) {
					prime[j] = false;
				}

			}

		}
		return prime;
	}

	private static final int LIMIT = (int) Math.pow(10, 6);

	private static boolean[] isPrime = listPrimality(LIMIT - 1);

	private static boolean isCircularPrime(int n) {
		String s = Integer.toString(n);
		for (int i = 0; i < s.length(); i++) {
			if (!isPrime[Integer.parseInt(s.substring(i) + s.substring(0, i))])
				return false;
		}
		return true;

	}

	public static void main(String[] args) {
		int count = 0;
		for (int i = 0; i < isPrime.length; i++) {
			if (isCircularPrime(i))
				count++;
		}
		System.out.println(count);
	}

}
