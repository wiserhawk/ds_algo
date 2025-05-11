package datastructures.graphs.shortestpath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

// https://takeuforward.org/data-structure/shortest-path-in-undirected-graph-with-unit-distance-g-28/

public class ShortestPathInUndirectedGraph {

    // Using BFS
    public static String shortestDistatnceForEachNode(int nodes, int edges, int[][] adjArray) {
        int source = 0;
        List<List<Integer>> adjList = createUndirectedGraph(nodes, adjArray);
        int[] distances = new int[nodes];
        Arrays.fill(distances, -1);
        Queue<Pair> queue = new LinkedList<>();
    
        queue.add(new Pair(source, 0));
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int node = pair.node;
            int distance = pair.distance;
            if (distances[node] == -1)
                distances[node] = distance;
        
            for (int next : adjList.get(node)) {
                if (distances[next] == -1)
                    queue.add(new Pair(next, distance + 1));
            }
        }
        return Arrays.toString(distances);
    }

    private static List<List<Integer>> createUndirectedGraph(int nodes, int[][] adjArray) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] pair : adjArray) {
            adjList.get(pair[0]).add(pair[1]);
            adjList.get(pair[1]).add(pair[0]);
        }

        return adjList;
    }


    public static class Pair {
        int node, distance;

        public Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        int nodes = 9;
        int edges = 10;
        int[][] adjArray = new int[][] {{0,1},{0,3},{3,4},{4 ,5},{5, 6},{1,2},{2,6},{6,7},{7,8},{6,8}};

        System.out.println("Shortest Path = " + shortestDistatnceForEachNode(nodes, edges, adjArray));
    }   

}
