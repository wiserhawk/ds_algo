package datastructures.graphs.shortestpath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://takeuforward.org/data-structure/shortest-path-in-directed-acyclic-graph-topological-sort-g-27/
public class ShortestPathInDirectedAcyclicGraph {

    public static String shortestPath(int nodeSize, int edgeSize, int[][] edges) {
        List<List<Edge>> edgeList = createDirectedGraph(nodeSize, edges);
        int[] distances = new int[nodeSize];
        Arrays.fill(distances, -1);
        int source  = 0;
        Queue<Edge> queue = new LinkedList<>();
        queue.add(new Edge(source, 0));
        distances[source] = 0;

        while (!queue.isEmpty()) {
            Edge edge = queue.poll();
            int node = edge.node;
           
            for (Edge nextEdge : edgeList.get(node)) {
                if (distances[nextEdge.node] == -1) {
                    distances[nextEdge.node] = distances[node] + nextEdge.weight;
                } else if (distances[node] + nextEdge.weight < distances[nextEdge.node]) {
                    distances[nextEdge.node] = distances[node] + nextEdge.weight;
                } 
                queue.add(nextEdge);
            }
        }
        return Arrays.toString(distances);

    }

    private static List<List<Edge>> createDirectedGraph(int nodes, int[][] edges) {
        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(new Edge(edge[1], edge[2]));
        }
        return adj;
    }


    public static class Edge {
        int node, weight;

        public Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        int n = 6, m = 7;
        int[][] edges = {{0,1,2},{0,4,1},{4,5,4},{4,2,2},{1,2,3},{2,3,6},{5,3,1}};
        System.out.println("Shortest Path = " + shortestPath(n, m, edges));
    }

}
