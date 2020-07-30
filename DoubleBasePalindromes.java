package devjava;

public class DoubleBasePalindromes {

	public static boolean isPalindrome(String str) {
		int i = 0, j = str.length() - 1;
		while (i < j) {
			if (str.charAt(i) != str.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args) {
		long counter = 0L;
		for (int i = 1; i < 1000000; i++) {
			if (isPalindrome(String.valueOf(i)) & isPalindrome(Integer.toBinaryString(i).replaceAll("^0+", ""))) {
				counter += i;
			}
		}
		System.out.println(counter);
	}
}
