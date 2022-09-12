package dev;

import java.util.Arrays;

class PermutedMultiples {
    public static void main(String[] args) {
        Integer step = 10;
        char[] firstCharArray;
        char[] secondCharArray;
        char[] thirdCharArray;
        char[] fourthCharArray;
        char[] fifthCharArray;
        char[] sixthCharArray;
        while (true) {
            firstCharArray = step.toString().toCharArray();
            secondCharArray = Integer.valueOf(step * 2).toString().toCharArray();
            thirdCharArray = Integer.valueOf(step * 3).toString().toCharArray();
            fourthCharArray = Integer.valueOf(step * 4).toString().toCharArray();
            fifthCharArray = Integer.valueOf(step * 5).toString().toCharArray();
            sixthCharArray = Integer.valueOf(step * 6).toString().toCharArray();
            Arrays.sort(firstCharArray);
            Arrays.sort(secondCharArray);
            Arrays.sort(thirdCharArray);
            Arrays.sort(fourthCharArray);
            Arrays.sort(fifthCharArray);
            Arrays.sort(sixthCharArray);
            if (new String(firstCharArray).equals(new String(secondCharArray))
                    &
                    new String(secondCharArray).equals(new String(thirdCharArray))
                    &
                    new String(thirdCharArray).equals(new String(fourthCharArray))
                    &
                    new String(fourthCharArray).equals(new String(fifthCharArray))
                    &
                    new String(fifthCharArray).equals(new String(sixthCharArray))) {
                System.out.println(step);
                break;
            }
            step++;
        }
    }
}