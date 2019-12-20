package main;

import java.util.ArrayList;
import java.util.List;

public class SubsequenceOfAString {

    List findLongestString(List<String> dict, String input) {

        String finalString = null;
        List<String> multipleLongestString = new ArrayList<String>();
        int index = 0;
        boolean isLongStringFound = false;
        for (String tempDict : dict) {
            finalString = compareString(tempDict, input);
            if (tempDict.equals(finalString)) {
                finalString = tempDict;
                if (multipleLongestString.size() == 0) {
                    multipleLongestString.add(index, finalString);
                } else if (finalString.length() > multipleLongestString.get(0)
                        .length()) {
                    isLongStringFound = true;
                }
            }
            if (finalString.length() >= multipleLongestString.get(0).length()
                    && !finalString.equals(multipleLongestString.get(0))) {
                if (isLongStringFound) {
                    multipleLongestString.remove(0);
                    isLongStringFound = false;
                }
                multipleLongestString.add(0, finalString);
                index++;
            }
        }
        printList(multipleLongestString);
        return multipleLongestString;
    }

    void printList(List<String> inputList) {
        for (String longestString : inputList) {
            System.out.println(longestString);
        }
    }

    String compareString(String tempDict, String input) {
        StringBuffer sb = new StringBuffer();
        int tempCount = 0;
        int inputStringLength = input.length();
        int dictLength = 0;
        while (inputStringLength != 0) {
            if (dictLength < tempDict.length()) {
                if (input.toLowerCase().contains(
                        Character.toString(tempDict.toLowerCase().charAt(
                                tempCount)))) {
                    sb.append(tempDict.charAt(tempCount));
                    tempCount++;
                    dictLength++;
                }
            }
            inputStringLength--;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        List<String> dict = new ArrayList<String>();
        dict.add("ale");
        dict.add("applee");
        dict.add("monkey");
        dict.add("plea");
        String input = "abpcpleeaDChsssgtrsssmonkey";
        SubsequenceOfAString ls = new SubsequenceOfAString();
        ls.findLongestString(dict, input);
    }
}
