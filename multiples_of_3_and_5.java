public class Test {

	public static int calculateMultiplesSum(int bound) {
		int calculatedSum = 0;
		for (int i = 1; i < bound; i++) {
			if (i % 3 == 0 || i % 5 == 0) {
				calculatedSum += i;
			}
		}
		return calculatedSum;
	}

	public static void main(String[] args) {
		System.out.println(Test.calculateMultiplesSum(99999999));
	}
}