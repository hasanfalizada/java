package dev;

import java.math.BigInteger;

public class LychrelNumbers {

    static BigInteger reverseNumber(BigInteger n) {
        return new BigInteger(new StringBuilder().append(n).reverse().toString());
    }

    static boolean isPalindrome(BigInteger x) {
        return x.compareTo(reverseNumber(x)) == 0;
    }

    public static void main(String[] args) {
        
        BigInteger sum;
        BigInteger tempN;
        int counter;
        int lychrelCounter = 0;

        for (int i = 1; i <= 10000; i++) {
            tempN = BigInteger.valueOf(i);
            counter = 0;
            sum = BigInteger.valueOf(10);
            while (!isPalindrome(sum)) {
                sum = reverseNumber(tempN).add(tempN);
                tempN = sum;
                counter++;
                if (counter > 50) {
                    lychrelCounter++;
                    break;
                }
            }

        }
        System.out.println(lychrelCounter);
    }

}
