package devjava;

import java.util.*;

public class TestFun {

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        map.put("Hasan", 1);
        map.put("Alizada", 2);
        map.put("Somebody", 3);
        map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).limit(2)
                .forEach(System.out::println);
    }

}