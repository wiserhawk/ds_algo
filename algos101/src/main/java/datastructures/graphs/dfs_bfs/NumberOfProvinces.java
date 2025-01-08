package datastructures.graphs.dfs_bfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Problem Statement: Given an undirected graph with V vertices. 
 * We say two vertices u and v belong to a single province if there is a path from u to v or v to u. 
 * Your task is to find the number of provinces.
 * 
 * Pre-req: Connected Components, Graph traversal techniques
 */


public class NumberOfProvinces {


    // DFS approach
    public static int getNumberOfProvinces(List<ArrayList<Integer> > adj) {
        int provinces = 0;
        int[] visited = new int[adj.size()];
       
        for (int city = 0; city < adj.size(); city++) {
            if (visited[city] == 0) {
                List<Integer> connectedCities = adj.get(city);
                for (int connectedCity : connectedCities) {
                    if (visited[connectedCity] == 0) {
                        visited[connectedCity] = 1;
                    }                    
                }
                provinces++;
            }
        }

        return provinces;
    }





    public static void main(String[] args) {

        List<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer> >();

        // Metrics represented as Adjacency cities
        // 1 0 1
        // 0 1 0
        // 1 0 1
        adj.add(new ArrayList<Integer>());
        adj.get(0).add(0, 1);
        adj.get(0).add(1, 0);
        adj.get(0).add(2, 1);
        adj.add(new ArrayList<Integer>());
        adj.get(1).add(0, 0);
        adj.get(1).add(1, 1);
        adj.get(1).add(2, 0);
        adj.add(new ArrayList<Integer>());
        adj.get(2).add(0, 1);
        adj.get(2).add(1, 0);
        adj.get(2).add(2, 1);


        int provinces = getNumberOfProvinces(adj);
        System.out.println("Number of Provinces = " + provinces);
    }



}