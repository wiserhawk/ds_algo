package datastructures.graphs.dfs_bfs;

import java.util.List;

//https://takeuforward.org/data-structure/detect-cycle-in-a-directed-graph-using-dfs-g-19/

public class CycleDetectionInDirectedGraph {

    public static boolean hasCycleUsingDFS(List<List<Integer>> edges) {    
        boolean[] visited = new boolean[edges.size()];
        int[] nodePath = new int[edges.size()];
        for (int i = 0; i < edges.size(); i++) {
            if (!visited[i]) {
                if (dfs(i, edges, visited, nodePath)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(int node, List<List<Integer>> edges, boolean[] visited, int[] nodePath) {
        if (nodePath[node] == 1)
            return true;
        if (visited[node])
            return false;

        visited[node] = true;
        nodePath[node] = 1;
        List<Integer> neighbors = edges.get(node);
        for (int neighbor : neighbors) {
            if (nodePath[neighbor] == 1) {
                return true;
            }
            if (!visited[neighbor]) {
                boolean isCycle = dfs(neighbor, edges, visited, nodePath);
                nodePath[neighbor] = 0;
                if (isCycle) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<List<Integer>> edges = List.of(
            List.of(1),
            List.of(2),
            List.of(3, 6),
            List.of(4),
            List.of(5),
            List.of(),
            List.of(4),
            List.of(1, 8),
            List.of(9),
            List.of(7)
        );
        System.out.println("DFS: Is Cycle present = " + hasCycleUsingDFS(edges));

    }

}
