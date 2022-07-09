package dev;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CountingVowelsAndConsonants {
    public static void main(String[] args) {

        final Set<Character> allVowels = new HashSet(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        long vowels = 0;
        long consonants = 0;
        String str = "Hasan";

        str = str.toLowerCase();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (allVowels.contains(ch)) {
                vowels++;
            } else if ((ch >= 'a' && ch <= 'z')) {
                consonants++;
            }
        }

        vowels = str.chars()
                .filter(c -> allVowels.contains((char) c))
                .count();
        consonants = str.chars()
                .filter(c -> !allVowels.contains((char) c))
                .filter(ch -> (ch >= 'a' && ch <= 'z'))
                .count();

        System.out.println(vowels + " " + consonants);
    }
}
