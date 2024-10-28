package dev;

import java.io.*;
import java.util.*;

public class PasscodeDerivation {
    public static void main(String[] args) throws IOException {
        // Read the file and store each login attempt
        List<String> attempts = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("keylog.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                attempts.add(line.trim());
            }
        }

        // Create a graph to store the ordering constraints
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();

        // Initialize the graph and in-degrees for each digit
        for (String attempt : attempts) {
            char first = attempt.charAt(0);
            char second = attempt.charAt(1);
            char third = attempt.charAt(2);

            graph.putIfAbsent(first, new HashSet<>());
            graph.putIfAbsent(second, new HashSet<>());
            graph.putIfAbsent(third, new HashSet<>());

            inDegree.putIfAbsent(first, 0);
            inDegree.putIfAbsent(second, 0);
            inDegree.putIfAbsent(third, 0);

            // Build the graph and update in-degrees based on order constraints
            if (graph.get(first).add(second)) inDegree.put(second, inDegree.get(second) + 1);
            if (graph.get(second).add(third)) inDegree.put(third, inDegree.get(third) + 1);
        }

        // Topological sort to determine the shortest passcode
        Queue<Character> queue = new LinkedList<>();
        for (Character key : inDegree.keySet()) {
            if (inDegree.get(key) == 0) {
                queue.add(key);
            }
        }

        StringBuilder passcode = new StringBuilder();
        while (!queue.isEmpty()) {
            Character node = queue.poll();
            passcode.append(node);

            for (Character neighbor : graph.get(node)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // Output the shortest possible passcode
        System.out.println("The shortest possible passcode is: " + passcode.toString());
    }
}
