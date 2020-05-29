package devjava;

public class TriangularNumber {
	public static void main(String[] args) {
		int divCount = 0;
		int z = 0;
		while (divCount * 2 <= 500) {
			divCount = 0;
			z++;
			int s = 0;
			for (int i = 0; i <= z; i++) {
				s = s + i;
			}
			for (int j = 1; j <= Math.sqrt(s); j++) {
				if (s % j == 0) {
					divCount++;
				}
			}
			if (divCount * 2 > 500) {
				System.out.println(s);
			}
		}
	}
}
