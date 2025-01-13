package datastructures.graphs.dfs_bfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * "Undirected Graph Cycle"
 * 
 * Given an undirected graph with V vertices labelled from 0 to V-1 and E edges, check whether the graph contains any cycle or not. 
 * The Graph is represented as an adjacency list, where adj[i] contains all the vertices that are directly connected to vertex i.
 * 
 * NOTE: The adjacency list represents undirected edges, meaning that if there is an edge between vertex i and vertex j, both j will be adj[i] and i will be in adj[j].
 */

public class CycleDetectionInUndirectedGraph {

    public static boolean hasCycleUsingDFS(List<List<Integer>> edges) {
        int n = edges.size();
        boolean[] visited = new boolean[n];
        return dfs(0, edges, visited);
    }

    private static boolean dfs(int node, List<List<Integer>> edges, boolean[] visited) {
        if (visited[node]) {
            return true;      
        }
        visited[node] = true;
        for (int n : edges.get(node)) {
            if (dfs(n, edges, visited)) {
               return true;
            }
        }
        return false;
    }

    public static boolean hasCycleUsingBFS(List<List<Integer>> edges) {
        int n = edges.size();
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (visited[node])
                return true;
            visited[node] = true;
            for (int adj : edges.get(node)) {
                    queue.add(adj);
            }
        }
        return false;
    }


    public static void main(String[] args) {
        List<List<Integer>> edges = List.of(
                List.of(1),
                List.of(0, 2, 4),
                List.of(1, 3),
                List.of(2, 4),
                List.of(1, 3)
        );
        System.out.println("DFS: Is Cycle present = " + hasCycleUsingDFS(edges));

        System.out.println("BFS: Is Cycle present = " + hasCycleUsingBFS(edges));


    }

}
