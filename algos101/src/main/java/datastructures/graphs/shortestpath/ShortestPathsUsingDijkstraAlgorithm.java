package datastructures.graphs.shortestpath;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// https://takeuforward.org/data-structure/dijkstras-algorithm-using-priority-queue-g-32/
public class ShortestPathsUsingDijkstraAlgorithm {

     public static List<String> shortestPaths(int V, List<List<Edge>> adj, int src) {
        int[] paths = new int[V];
        int[] dist = new int[V];
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;
        paths[src] = src;

        PriorityQueue<Edge> minHeap = new PriorityQueue<>();
        minHeap.add(new Edge(0, 0));

        while (!minHeap.isEmpty()) {
            Edge edge = minHeap.poll();
            int node = edge.node;
            int distance = edge.distance;

            for (Edge e : adj.get(node)) {
                int newDistance = e.distance + distance;
                if ( newDistance < dist[e.node]) {
                    dist[e.node] = newDistance;
                    paths[e.node] = node;
                    minHeap.add(new Edge(e.node, newDistance));
                }
            }
        }
        return createPaths(paths, V);

    }

    private static List<String> createPaths(int[] paths, int V) {
        List<String> pathList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            StringBuilder builder = new StringBuilder(String.valueOf(i) + " ");
            int curr = i;
            while (curr != 0) {
                builder.append(String.valueOf(paths[curr]) + " ");
                curr = paths[curr];
            }
            //builder.append("0");
            pathList.add(builder.toString());
        }
        return pathList;
    }


    public static void addEdge(List<List<Edge>> adj, int u, int v, int wt) {
        adj.get(u).add(new Edge(v, wt));
        adj.get(v).add(new Edge(u, wt));
    }

    public static class Edge implements Comparable<Edge> {
        int distance, node;
        public Edge(int node, int distance) {    
            this.node = node;
            this.distance = distance;
        }

        // Comparable to support Min Heap. 
        @Override
        public int compareTo(Edge o) {
            int result = this.distance - o.distance;
            if (result == 0) {
                result = this.node - o.node;
            }
            return result;
        }
    }

    public static void main(String[] args) {

        int V = 9;
        List<List<Edge>> adj = new ArrayList<>(V);

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Making the above-shown graph
        addEdge(adj, 0, 1, 4);
        addEdge(adj, 0, 7, 8);
        addEdge(adj, 1, 2, 8);
        addEdge(adj, 1, 7, 11);
        addEdge(adj, 2, 3, 7);
        addEdge(adj, 2, 8, 2);
        addEdge(adj, 2, 5, 4);
        addEdge(adj, 3, 4, 9);
        addEdge(adj, 3, 5, 14);
        addEdge(adj, 4, 5, 10);
        addEdge(adj, 5, 6, 2);
        addEdge(adj, 6, 7, 1);
        addEdge(adj, 6, 8, 6);
        addEdge(adj, 7, 8, 7);

        int src = 0;
        List<String> paths = shortestPaths(V, adj, src);
        System.out.println("Shortest Distance = " + paths);
    }

}
