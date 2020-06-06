package devjava;

public class Collatz {

	public static void main(String[] args) {
		long maxCount = 0;
		for (int i = 2; i < 1000000; i++) {
			long n = i;
			long counter = 0;
			while (n != 1) {
				counter++;
				if (n % 2 == 0) {
					n /= 2;
				} else if (n % 2 != 0) {
					n = 3 * n + 1;
				}
			}
			if (counter + 1 > maxCount) {
				System.out.println("i - " + i + "; count: " + (counter + 1));
				maxCount = counter + 1;
			}
		}
	}
}
