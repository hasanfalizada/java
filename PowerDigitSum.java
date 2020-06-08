package devjava;

import java.math.BigInteger;

public class PowerDigitSum {
	public static void main(String[] args) {
		int sum = 0;
		BigInteger bigInteger = new BigInteger("2");
		for (int i = 1; i < 1000; i++) {
			bigInteger = bigInteger.multiply(new BigInteger("2"));
		}

		for (char c : bigInteger.toString().toCharArray()) {
			sum += Character.getNumericValue(c);
		}

		System.out.println(sum);
	}
}
