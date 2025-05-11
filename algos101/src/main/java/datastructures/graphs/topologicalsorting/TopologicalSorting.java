package datastructures.graphs.topologicalsorting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.Map.Entry;

// https://takeuforward.org/data-structure/topological-sort-algorithm-dfs-g-21/

public class TopologicalSorting {

    public static List<Integer> topologicalSorting(int V, List<List<Integer>> adj) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        for (int node = 0; node < V; node++) {
            if (!visited[node]) {
                dfs(node, adj, visited, stack);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            Integer node = stack.pop();
            result.add(node);
        }
        return result;
    }

    private static void dfs(Integer node, List<List<Integer>> adj, boolean[] visited, Stack<Integer> stack) {
        List<Integer> adjNodes = adj.get(node);
        visited[node] = true;
        for (Integer an : adjNodes) {
            if (!visited[an]) {
                dfs(an, adj, visited, stack);
            }
        }
        stack.push(node);
    }


    public static void main(String[] args) {
        int V = 6;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(5).add(0);
        adj.get(5).add(2);
        System.out.println("Topological Sorting = " + topologicalSorting(V ,adj));

    }

}
