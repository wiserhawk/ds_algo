package datastructures.graphs.topologicalsorting;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.apple.laf.resources.aqua_ja;

// https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1

// Hint: Using Kahn's Algorithm
public class CycleDetectionInDirectedGraph {

    // Using Kahn's Algorithm
    public static boolean hasCycleUsingBFS(int V, List<List<Integer>> adj) {
        int[] indegree = getIndegree(V, adj);

        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<V; i++) {
            if (indegree[i] == 0)
                queue.add(i);
        }
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int a : adj.get(node)) {
                indegree[a]--;
                if (indegree[a] == 0)
                    queue.add(a);
            }
        }

        // Look for nodes with non-zero indegree.
        for (int i=0; i<V; i++) {
            if (indegree[i] != 0)
                return true;
        }
        return false;

    }

    private static int[] getIndegree(int V, List<List<Integer>> adj) {
        int[] indegree = new int[V];
        for (int i=0; i < V; i++) {
            for ( int a : adj.get(i)) {
                indegree[a]++;
            }
        }
        return indegree;
    }

    public static void main(String[] args) {
        int V = 4;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(3);
        //adj.get(4).add(0);
        System.out.println("Cycle present = " + hasCycleUsingBFS(V, adj));

    }

}
