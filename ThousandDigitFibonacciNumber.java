package devjava;

import java.math.BigInteger;

public class ThousandDigitFibonacciNumber {

	static BigInteger fib(int n) {
		BigInteger a = BigInteger.valueOf(1);
		BigInteger b = BigInteger.valueOf(1);
		BigInteger c = BigInteger.valueOf(2);
		for (int j = 2; j <= n; j++) {
			c = a.add(b);
			a = b;
			b = c;
		}

		return a;
	}

	public static void main(String[] args) {
		int digitsCount = 0;
		int n = 0	;
		while (digitsCount < 1000) {
			n++;
			digitsCount = String.valueOf(fib(n)).length();
		}
		System.out.println(n + " " + fib(n));
	}

}
