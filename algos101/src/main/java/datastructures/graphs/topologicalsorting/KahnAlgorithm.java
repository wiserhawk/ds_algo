package datastructures.graphs.topologicalsorting;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://takeuforward.org/data-structure/kahns-algorithm-topological-sort-algorithm-bfs-g-22/

public class KahnAlgorithm {

    public static List<Integer> kahnTopologicalSorting(int V, List<List<Integer>> adj) {
        int[] indegree = getIndegree(V, adj);

        Queue<Integer> queue = new LinkedList<>();
        // add all nodes with zero indegree (Indegree is number of adjacent nodes that point to a node ). 
        // For example c -> b <-a , indegree of b is 2.
        for (int i=0; i<V; i++) {
            if (indegree[i] == 0)
                queue.add(i);
        }

        List<Integer> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);

            for (int a : adj.get(node)) {
                indegree[a] = indegree[a] - 1;
                // If indegree in zero. Add it to queue.
                if (indegree[a] == 0)
                    queue.add(a);
            } 
        }

        return result;
    }

    private static int[] getIndegree(int V, List<List<Integer>> adj) {
        int[] indegree = new int[V];
        for (int i=0; i < V; i++) {
            for (int a : adj.get(i)) {
                indegree[a]++;
            }
        }
        return indegree;
    }

    public static void main(String[] args) {

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        System.out.println("Khan's Algorithm (Topological Sorting) = " + kahnTopologicalSorting(6 ,adj));

    }

}
