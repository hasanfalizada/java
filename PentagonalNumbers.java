package devjava;

public class PentagonalNumbers {
	private static boolean isPentagonal(int number) {
		double penTest = (Math.sqrt(1 + 24 * number) + 1.0) / 6.0;
		return penTest == ((int) penTest);
	}

	public static void main(String[] args) {
		int result = 0;
		boolean notFound = true;
		int i = 1;

		while (notFound) {
			i++;
			int n = i * (3 * i - 1) / 2;
			for (int j = i - 1; j > 0; j--) {
				int m = j * (3 * j - 1) / 2;
				if (isPentagonal(n - m) && isPentagonal(n + m)) {
					result = n - m;
					notFound = false;
					break;
				}
			}
		}

		System.out.println(result);
	}
}
