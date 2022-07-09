package dev;

public class GetTheBitValue {
    public static void main(String[] args) {
        int n = 423;
        int k = 7;
        int result = n & (1 << k);
        if (result == 0) {
            System.out.println('0');
        } else {
            System.out.println('1');
        }
    }
}
