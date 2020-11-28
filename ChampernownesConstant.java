package devjava;

public class ChampernownesConstant {
	public static void main(String[] args) {
		StringBuilder s = new StringBuilder();
		int dig = 0;
		while (s.length() <= 1000000) {
			dig++;
			s.append(dig);
		}
		String[] digits = new String[999999];
		digits = s.toString().split("");
		System.out.println(Integer.parseInt(digits[0]) * Integer.parseInt(digits[9]) * Integer.parseInt(digits[99])
				* Integer.parseInt(digits[999]) * Integer.parseInt(digits[9999]) * Integer.parseInt(digits[99999])
				* Integer.parseInt(digits[999999]));
	}
}
