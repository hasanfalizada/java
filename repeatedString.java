public class Test {
	static long repeatedString(String s, long n) {
		long oCount = s.chars().filter(ch -> ch == 'a').count();
		int remainCount = 0;

		if (n % s.length() == 0) {
			System.out.println(n / s.length() * oCount);
			return n / s.length() * oCount;
		} else {
			char[] ca = s.toCharArray();
			for (int i = 0; i < n % s.length(); i++) {
				if (ca[i] == 'a') {
					remainCount++;
				}
			}
			System.out.println(n / s.length() * oCount + remainCount);
			return n / s.length() * oCount + remainCount;
		}
	}

	public static void main(String[] args) {
		Test.repeatedString("a", 1000000000000L);
	}
}