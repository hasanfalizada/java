package devjava;

import java.math.BigInteger;

public class FactorialDigitSum {
	public static void main(String[] args) {
		int factorialNumber = 100;
		BigInteger factorial = BigInteger.valueOf(1);
		int digitsSum = 0;

		for (int i = 1; i <= factorialNumber; i++) {
			factorial = factorial.multiply(BigInteger.valueOf(i));
		}

		System.out.println(factorial);

		for (char c : factorial.toString().toCharArray()) {
			digitsSum += Character.getNumericValue(c);
		}
		
		System.out.println(digitsSum);
	}
}
