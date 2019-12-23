class Test {

	public static int solution(String x) {
		int result = -1;
		int stringLength = x.length();
		for (int i = stringLength; i > 0; i--) {
			int n = stringLength / i;
			if (n * i == stringLength) {
				boolean valid = true;
				String component = x.substring(0, n);
				for (int j = 1; j < i; j++) {
					if (!x.substring(j * n, j * n + n).equals(component)) {
						valid = false;
						break;
					}
				}
				if (valid) {
					result = i;
					break;
				}

			}

		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(Test.solution("abcabc"));
	}
}
