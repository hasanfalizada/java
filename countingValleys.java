class Test {

	static int countingValleys(int n, String s) {
		char[] map = s.toCharArray();
		int[] stepsMap = new int[n];
		stepsMap[0] = map[0] == 'U' ? 1 : -1;
		for (int i = 1; i < map.length; i++) {
			stepsMap[i] = map[i] == 'U' ? stepsMap[i - 1] + 1 : stepsMap[i - 1] - 1;
		}
		int valleyCount = 0;
		boolean countingStarted = false;
		for (int i : stepsMap) {
			if (i < 0 && !countingStarted) {
				valleyCount++;
				countingStarted = true;
			} else if (i >= 0 && countingStarted) {
				countingStarted = false;
			}
		}
		return valleyCount;
	}

	public static void main(String[] args) {
		System.out.println(Test.countingValleys(8, "DDUUUUDD"));
	}
}