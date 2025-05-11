package datastructures.graphs.topologicalsorting;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://takeuforward.org/data-structure/alien-dictionary-topological-sort-g-26/

// Hint: Using Kahn's Algorithm
public class AlienDictionary {



    public static String findOrder(String[] words, int n, int k) {
        // Create adjacent list.
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n-1; i++) {
            String first = words[i];
            String second = words[i+1];
            int minLength =  Math.min(first.length(), second.length());
            for (int c=0; c < minLength; c++) {
                if (first.charAt(c) != second.charAt(c)) {
                    adj.get(first.charAt(c) - 'a').add(second.charAt(c) - 'a');
                    break;
                }
            }
        }

        return topoSort(k, adj);

    }

    private static String topoSort(int k, List<List<Integer>> adj) {
        int[] indegree = new int[k];
        for (int i=0; i < k; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i < k; i++) {
            if (indegree[i] == 0) 
                queue.add(i);
        }

        StringBuilder order = new StringBuilder();
        while (!queue.isEmpty()) {
            int ch = queue.poll();
            order.append( (char) (ch + (int)'a')).append(" ");
            for (int it : adj.get(ch)) {
                indegree[it]--;
                if (indegree[it] == 0)
                    queue.add(it);
            }
        }
        return order.toString();
        
    }


    public static void main(String[] args) {
        int N = 5, K = 4;
        String[] words = {"baa", "abcd", "abca", "cab", "cad"};
        System.out.println("Alien Dictionary = " + findOrder(words, N, K));

    }

}
