package datastructures.graphs;

import java.util.ArrayList;

/**
 * 
 * Problem Statement: Given an undirected graph with V vertices. 
 * We say two vertices u and v belong to a single province if there is a path from u to v or v to u. 
 * Your task is to find the number of provinces.
 * 
 * Pre-req: Connected Components, Graph traversal techniques
 */


public class NumberOfProvinces {





    public static void main(String[] args) {

        ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer> >();

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

        101
        010
        101
    }



}