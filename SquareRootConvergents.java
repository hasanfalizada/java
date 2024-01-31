package dev;

import java.math.BigInteger;

public class SquareRootConvergents {
    private static BigInteger[] fractionByIterationNumber(int iteration) {
        if (iteration == 1) {
            return new BigInteger[]{BigInteger.valueOf(1), BigInteger.valueOf(2)};
        } else {
            BigInteger[] tempArr = fractionByIterationNumber(iteration - 1);
            return new BigInteger[]{tempArr[1], tempArr[1].multiply(BigInteger.valueOf(2)).add(tempArr[0])};
        }
    }

    public static void main(String[] args) {
        int iterationsNumber = 1000;
        int counter = 0;
        for (int i = 1; i <= iterationsNumber; i++) {
            BigInteger[] tempArray = new BigInteger[]{fractionByIterationNumber(i)[1].multiply(BigInteger.valueOf(1)).add(fractionByIterationNumber(i)[0]), fractionByIterationNumber(i)[1]};
            int numeratorLength = tempArray[0].toString().length();
            int denominatorLength = tempArray[1].toString().length();

            if (numeratorLength > denominatorLength) {
                counter++;
            }
        }
        System.out.println(counter);
    }
}
