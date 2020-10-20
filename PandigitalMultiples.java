package devjava;

import java.util.Arrays;

public class PandigitalMultiples {
	private static boolean isPandigital(String s) {
		if (s.length() != 9)
			return false;
		char[] temp = s.toCharArray();
		Arrays.sort(temp);
		return new String(temp).equals("123456789");
	}

	public static void main(String[] args) {
		for (int i = 1; i < 9999; i++) {
			String tempDigit = "";
			int multiplier = 1;
			while (tempDigit.length() <= 9) {
				tempDigit += Integer.toString(i * multiplier);
				if (isPandigital(tempDigit)) {
					System.out.println(i + " -> " + tempDigit);
					continue;
				}
				multiplier++;
			}
		}
	}
}
