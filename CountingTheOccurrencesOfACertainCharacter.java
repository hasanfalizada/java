package dev;

public class CountingTheOccurrencesOfACertainCharacter {
    public static void main(String[] args) {
        String str = "Hasan";
        char ch = 'a';

        System.out.println(str.length() - str.replace(String.valueOf(ch), "").length());
        System.out.println(str.chars().filter(c -> c == ch).count());
    }
}
