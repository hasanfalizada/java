public class Test {
	public int lengthOfLongestSubstring(String s) {
		char[] charArray = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		int maxLength = 0;

		for (int i = 0; i < charArray.length; i++) {
			for (int j = i; j < charArray.length; j++) {
				if (sb.toString().indexOf(charArray[j]) == -1) {
					sb.append(charArray[j]);
				} else {
					break;
				}
			}
			if (sb.length() > maxLength) {
				maxLength = sb.length();
			}
			sb = new StringBuilder();
		}

		return maxLength;
	}

	public static void main(String[] args) {
		new Test().lengthOfLongestSubstring("pwwkew");
	}
}