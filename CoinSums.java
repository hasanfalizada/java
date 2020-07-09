package devjava;

public class CoinSums {
	public static void main(String[] args) {
		int target = 200;
		int[] coinSizes = { 1, 2, 5, 10, 20, 50, 100, 200 };
		int[] ways = new int[target + 1];
		ways[0] = 1;

		for (int i = 0; i < coinSizes.length; i++) {
			for (int j = coinSizes[i]; j <= target; j++) {
				ways[j] += ways[j - coinSizes[i]];
			}
		}

		System.out.println(ways[target]);
	}
}
