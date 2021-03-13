package devjava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PandigitalPrime {

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

	static List<Integer> generateAllPandigitals() {
		int n = 7;
		List<Integer> outList = new ArrayList<>();
		for (int i = n; i >= 1; i--) {
			for (int k = n; k >= 1; k--) {
				if (k == i) {
					continue;
				}
				for (int j = n; j >= 1; j--) {
					if (j == k || j == i) {
						continue;
					}
					for (int z = n; z >= 1; z--) {
						if (z == k || z == i || z == j) {
							continue;
						}
						for (int m = n; m >= 1; m--) {
							if (m == k || m == i || m == j || m == z) {
								continue;
							}
							for (int h = n; h >= 1; h--) {
								if (h == k || h == i || h == j || h == z || h == m) {
									continue;
								}
								for (int y = n; y >= 1; y--) {
									if (y == k || y == i || y == j || y == z || y == m || y == h) {
										continue;
									}
									outList.add(
											Integer.parseInt(i + "" + k + "" + j + "" + z + "" + m + "" + h + "" + y));
								}
							}
						}
					}
				}
			}
		}
		Collections.sort(outList, Collections.reverseOrder());
		return outList;
	}

	public static void main(String[] args) {
		for (int i : generateAllPandigitals()) {
			if (isPrime(i)) {
				System.out.println(i);
				break;
			}
		}
	}

}
