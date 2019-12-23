class Test {

	public static void toOneDigit(Integer startingDigit) {
		char[] charArray = startingDigit.toString().toCharArray();
		int sum = 0;
		for (char ch : charArray) {
			sum += Character.getNumericValue(ch);
		}
		if (sum < 10) {
			System.out.println("DONE! - " + sum);
		} else {
			System.out.println("NO! - " + sum);
			toOneDigit(sum);
		}
	}

	public static void main(String[] args) {
		Test.toOneDigit(999999999);
	}
}