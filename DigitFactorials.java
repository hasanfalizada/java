package devjava;

public class DigitFactorials {
	final static int FACT[] = { 1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880 }; // The first thing that comes to mind
																					// is,
	// that we must calculate factorials up
	// to 9 over and over again, which makes
	// them ideal to pre-calculate them

	static int factorialSum(int n) {
		int sum = 0;
		while (n > 0) {
			sum += FACT[n % 10];
			n = n / 10;
		}
		return sum;
	}

	public static void main(String[] args) {

		final int lowerBound = 10; // If we brute-force the task, the question for a good upper and lower bound
									// arises. The problem description excludes 1! and 2! to be valid, since they
									// are not sums. 3 is a reasonable lower bound, but since the factorial of a
									// one-digit number - except 3 itself - has always more than one digit, we can
									// start with 10

		final int upperBound = 1499999; // From this derivation follows, that a maximum upper bound can have at most 7
										// digits and will fail for any d> 7d>7, which gives an upper bound of 9999999,
										// a 7 digit number of all 9. But we know, that 7\cdot 9!=25401607⋅9!=2540160,
										// so we have a better upper bound. Okay, we know the upper bound must be 7
										// digit long and the first digit of the upper bound is at most 2, resulting in
										// two possible ways a 6 digit number of 9 can be formed, so the new upper bound
										// becomes 2!+6\cdot 9!2!+6⋅9!. This implies that if nn is a 7 digit number,
										// either the second digit must be 0 or 1 or the last digit is 1. If the first
										// digit is 2 and thus the second digit is 0 or 1, the numbers are limited by
										// 2!+1!+5\cdot 9!2!+1!+5⋅9! = 1814403 - which is a contradiction to the first
										// digit being 2. Thus, a 7-digit number can be at most 1999999. Another
										// observation is that all factorials of digits above 4 will have 2 and 5 as a
										// factor and thus end with 0. If all but the first digit of the 7 digit number
										// are at least 5, the last digit will be 1, coming from 1!1! of the first
										// digit, which is a contradiction to the statement that all 6 digits are at
										// least 5. This means that at least one of the 6 remaining digits can be at
										// most 4, which reduces the upper bound again: 1!+4!+5\cdot
										// 9!=18144251!+4!+5⋅9!=1814425. If we assume nn is a 7 digit number, the second
										// digit is at most 8. If the second digit is now 5, one of the remaining digits
										// has to be at most 4. This implies an upper bound of 1!+8!+4!+4\cdot
										// 9!=14918651!+8!+4!+4⋅9!=1491865, which is a contradiction that the second
										// digit has to be at least 5. Therefore the second digit can be at most 4 and
										// the new upper bound is 1499999.

		int sum = 0;
		for (int i = lowerBound; i <= upperBound; i++) {
			if (i == factorialSum(i)) {
				sum += i;
			}
		}
		System.out.println(sum);
	}
}
