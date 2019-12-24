class Test {
	public int sumNumbers(String str) {
		int sum = 0;
		String[] numsArray = str.replaceAll("[^0-9]+", ".").split("\\.");
		for (String s : numsArray) {
			if (s != null && s.length() != 0) {
				sum += Integer.parseInt(s);
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(new Test().sumNumbers("7 11"));
	}
}
