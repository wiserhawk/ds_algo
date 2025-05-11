package datastructures.graphs.topologicalsorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/find-eventual-safe-states/description/

// Explaination: https://takeuforward.org/data-structure/find-eventual-safe-states-bfs-topological-sort-g-25/

// Hint: Using Kahn's Algorithm

public class EventualSafeStates {
    
    public static List<Integer> eventualSafeNodes(int V, List<List<Integer>> graph) {
        // Revese the graph edges direction and get indegree.
        List<List<Integer>> reveseGraph = new ArrayList<>();
        int[] indegree = new int[V];
        for (int i=0; i<V; i++) {
            reveseGraph.add(new ArrayList<>());
        }
        for (int i=0; i<V; i++) {
            for (Integer a : graph.get(i)) {
                reveseGraph.get(a).add(i);
                indegree[i]++;
            }
        }

        List<Integer> safeNodes = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0 ;  i < V; i++) {
            if (indegree[i] == 0)
                queue.add(i);
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            safeNodes.add(node);
            
            for (int a : reveseGraph.get(node)) {
                indegree[a]--;
                if (indegree[a] == 0)
                    queue.add(a);
            }
        }

        // if safe nodes shoulld be in sorted in ascending order.
        Collections.sort(safeNodes);
        return safeNodes; 
    }

    



    public static void main(String[] args) {

        int V = 7;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(1);
        graph.get(0).add(2);
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(2).add(5);
        graph.get(3).add(0); 
        graph.get(4).add(5);

        System.out.println("Eventual Safe States = " + eventualSafeNodes(V ,graph));

    }

}
