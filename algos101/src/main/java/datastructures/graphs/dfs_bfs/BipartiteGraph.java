package datastructures.graphs.dfs_bfs;

import java.util.List;

public class BipartiteGraph {

    public static boolean isBipartite(List<List<Integer>> graph) {
        int[] visited = new int[graph.size()];
        return dfs(new Node(0, 1), graph, visited);
    }

    // Labels: 0 (Not Visited), 1 (Visited with label 1) , 2 (Visited with label 2);
    private static boolean dfs(Node node, List<List<Integer>> graph, int[] labels) {
        int value = node.value;
        int label = node.label;
        if (labels[value] !=0 )
            return labels[value] == label;
        
        labels[value] = label;
        List<Integer> neighbors = graph.get(value);
        for (int neighbor: neighbors) {
            if (!dfs(new Node(neighbor, switchLable(label)), graph, labels))
                return false; 
        }
        return true;
    }

    private static int switchLable(int lable) {
        return lable == 1 ? 2 : 1;
    }


    public static class Node {
        int value;
        int label;

        public Node(int value, int label) {
            this.value = value;
            this.label = label;
        }
    }

   

    public static void main(String[] args) {
        // Input: graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
        // Output: false
        List<List<Integer>> graph = List.of(
            List.of(1,2,3),
            List.of(0,2),
            List.of(0,1,3),
            List.of(0,2)
        );

        System.out.println("Is graph bipartite = " + isBipartite(graph));
        
        // Input: graph1 = [[1,3],[0,2],[1,3],[0,2]]
        // Output: true
        List<List<Integer>> graph1 = List.of(
            List.of(1,3),
            List.of(0,2),
            List.of(1,3),
            List.of(0,2)    
        );
        
        System.out.println("Is graph1 bipartite = " + isBipartite(graph1));

    }   

}
