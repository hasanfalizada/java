package devjava;

public class IntegerRightTriangles {
	static int getSolutionsCountForPerimeter(int perimeter) {
		int solutionsCount = 0;
		for (int i = 1; i <= perimeter / 2; i++) {
			for (int j = 1; j <= perimeter / 2; j++) {
				for (int k = 1; k <= perimeter / 2; k++) {
					if ((i <= j) & (i + j + k == perimeter) & (i * i + j * j == k * k)) {
						solutionsCount++;
					}
				}
			}
		}
		return solutionsCount;
	}

	public static void main(String[] args) {
		int max = 0;
		int perimeter = 0;
		int tempCount = 0;
		for (int i = 3; i <= 1000; i++) {
			tempCount = getSolutionsCountForPerimeter(i);
			if (tempCount > max) {
				max = tempCount;
				perimeter = i;
			}
		}
		System.out.println(perimeter + " -> " + max);
	}
}
