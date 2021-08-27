package devjava;

import java.util.ArrayList;
import java.util.List;

public class SubStringDivisibility {
	public static List<Long> generateAllPandigitals() {
		int n = 9;
		List<Long> outList = new ArrayList<>();
		for (int i = n; i >= 1; i--) {
			for (int k = n; k >= 0; k--) {
				if (k == i) {
					continue;
				}
				for (int j = n; j >= 0; j--) {
					if (j == k || j == i) {
						continue;
					}
					for (int z = n; z >= 0; z--) {
						if (z == k || z == i || z == j) {
							continue;
						}
						for (int m = n; m >= 0; m--) {
							if (m == k || m == i || m == j || m == z) {
								continue;
							}
							for (int h = n; h >= 0; h--) {
								if (h == k || h == i || h == j || h == z || h == m) {
									continue;
								}
								for (int y = n; y >= 0; y--) {
									if (y == k || y == i || y == j || y == z || y == m || y == h) {
										continue;
									}
									for (int i1 = n; i1 >= 0; i1--) {
										if (i1 == k || i1 == i || i1 == j || i1 == z || i1 == m || i1 == h || i1 == y) {
											continue;
										}
										for (int i2 = n; i2 >= 0; i2--) {
											if (i2 == k || i2 == i || i2 == j || i2 == z || i2 == m || i2 == h
													|| i2 == y || i2 == i1) {
												continue;
											}
											for (int i3 = n; i3 >= 0; i3--) {
												if (i3 == k || i3 == i || i3 == j || i3 == z || i3 == m || i3 == h
														|| i3 == y || i3 == i1 || i3 == i2) {
													continue;
												}
												outList.add(Long.parseLong(i + "" + k + "" + j + "" + z + "" + m + ""
														+ h + "" + y + "" + i1 + "" + i2 + "" + i3));
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return outList;
	}

	public static void main(String[] args) {
		long sum = 0L;
		for (long i : generateAllPandigitals()) {
			if (Integer
					.parseInt(String.valueOf(i).charAt(1) + "" + String.valueOf(i).charAt(2) + ""
							+ String.valueOf(i).charAt(3))
					% 2 == 0
					& Integer.parseInt(String.valueOf(i).charAt(2) + "" + String.valueOf(i).charAt(3) + ""
							+ String.valueOf(i).charAt(4)) % 3 == 0
					& Integer.parseInt(String.valueOf(i).charAt(3) + "" + String.valueOf(i).charAt(4) + ""
							+ String.valueOf(i).charAt(5)) % 5 == 0
					& Integer.parseInt(String.valueOf(i).charAt(4) + "" + String.valueOf(i).charAt(5) + ""
							+ String.valueOf(i).charAt(6)) % 7 == 0
					& Integer.parseInt(String.valueOf(i).charAt(5) + "" + String.valueOf(i).charAt(6) + ""
							+ String.valueOf(i).charAt(7)) % 11 == 0
					& Integer.parseInt(String.valueOf(i).charAt(6) + "" + String.valueOf(i).charAt(7) + ""
							+ String.valueOf(i).charAt(8)) % 13 == 0
					& Integer.parseInt(String.valueOf(i).charAt(7) + "" + String.valueOf(i).charAt(8) + ""
							+ String.valueOf(i).charAt(9)) % 17 == 0) {
				sum += i;
			}
		}
		System.out.println(sum);
	}
}
