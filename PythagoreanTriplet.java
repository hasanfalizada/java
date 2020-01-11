class Test {
	static boolean isPythagoreanTriplet(int a, int b, int c) {
		if (a * a + b * b == c * c) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {

		int bound = 1000;
		for (int i = 2; i < bound; i++) {
			for (int j = i + 1; j < bound; j++) {
				for (int k = j + 1; k < bound; k++) {
					if (isPythagoreanTriplet(i, j, k)) {
						if (i + j + k == 1000) {
							System.out.println(i * j * k);
							return;
						}
					}
				}
			}
		}

	}
}
