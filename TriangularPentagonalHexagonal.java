package devjava;

public class TriangularPentagonalHexagonal {
	public static void main(String[] args) {

		long H;
		long P;
		long T;

		for (long i = 1; i <= 285000; i++) {
			T = i * (i + 1) / 2;
			for (long j = 1; j <= i; j++) {
				P = j * (3 * j - 1) / 2;
				if (T == P) {
					for (long k = 1; k <= j; k++) {
						H = k * (2 * k - 1);
						if (P == H) {
							System.out.println("T" + i + " = P" + j + " = H" + k + " = " + H);
						}
					}
				} else {
					continue;
				}
			}
		}
	}
}
