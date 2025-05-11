package datastructures.graphs.shortestpath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/network-delay-time/description/
public class NetworkDelayTime {

    public static class Node {
        int number, time;

        public Node(int number, int time) {
            this.number = number;
            this.time = time;
        }
    }

    public static class Pair {
        int node, timeTaken;

        public Pair(int node, int timeTaken) {
            this.node = node;
            this.timeTaken = timeTaken;
        }
        
    }


    public static int networkDelayTime(int[][] times, int n, int k) {
        List<List<Node>> graph = createGraph(n, times);
        
        int[] singleTime = new int[n+1];
        Arrays.fill(singleTime, Integer.MAX_VALUE);

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(k, 0));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int node = pair.node;
            int timeTaken = pair.timeTaken;
            singleTime[node] = Math.min(singleTime[node], timeTaken);
            

            for (Node next : graph.get(node)) {
                queue.add(new Pair(next.number, next.time + timeTaken));
            }

        }

        int networkDelay = 0;
        for (int i = 1; i <= n; i++) {
            if (singleTime[i] == Integer.MAX_VALUE) {
                return -1;
            }
            networkDelay = Math.max(networkDelay, singleTime[i]);
        }
        return networkDelay;
        
    }


    private static List<List<Node>> createGraph(int n, int[][] times) {
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {   
            graph.add(new ArrayList<>());
        }

        for (int[] time : times) {
            graph.get(time[0]).add(new Node(time[1], time[2]));
        }
        return graph;
    }


    public static void main(String[] args) {

        int[][] times = new int[][] {{2,1,1},{2,3,1},{3,4,1}};
        int n = 4, k = 2;
        System.out.println("Network Delay Time = " + new NetworkDelayTime().networkDelayTime(times, n, k));

        times = new int[][] {{1,2,1},{2,3,2},{1,3,4}};
        n = 3; k = 1;
        System.out.println("Network Delay Time = " + new NetworkDelayTime().networkDelayTime(times, n, k));
        
    }

}
