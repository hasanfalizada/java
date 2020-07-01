package devjava;

public class NumberSpiralDiagonals {
	public static void main(String[] args) {
		/*
		 * From the diagram, let's observe the four corners of an n * n square (where n
		 * is odd). It's not hard to convince yourself that the top right corner always
		 * has the value n^2. Working counterclockwise (backwards), the top left corner
		 * has the value n^2 - (n - 1), the bottom left corner has the value n^2 - 2(n -
		 * 1), and the bottom right is n^2 - 3(n - 1). Putting it all together, this
		 * outermost ring contributes 4n^2 - 6(n - 1) to the final sum. Incidentally,
		 * the closed form of this sum is (4m^3 + 3m^2 + 8m - 9) / 6, where m = size.
		 */
		final int SIZE = 1001;

		long sum = 1; // Special case for size 1

		for (int n = 3; n <= SIZE; n += 2) {
			sum += 4 * n * n - 6 * (n - 1);
		}

		System.out.println(sum);

	}
}
