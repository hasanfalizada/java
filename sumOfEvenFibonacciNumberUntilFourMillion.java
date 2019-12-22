class Test {

	public static void sumOfEvenFibonacciNumberUntilFourMillion() {
		int firstNumber = 1;
		int secondNumber = 1;
		int fibonacciNumber = 1;
		int sumOfEvens = 0;
		while (fibonacciNumber <= 4_000_000) {
			if (fibonacciNumber % 2 == 0) {
				sumOfEvens += fibonacciNumber;
			}
			firstNumber = secondNumber;
			secondNumber = fibonacciNumber;
			fibonacciNumber = firstNumber + secondNumber;
		}
		System.out.println(sumOfEvens);
	}

	public static void main(String[] args) {
		Test.sumOfEvenFibonacciNumberUntilFourMillion();
	}
}