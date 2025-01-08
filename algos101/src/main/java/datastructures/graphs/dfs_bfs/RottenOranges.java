package datastructures.graphs.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Complexcity : Medium 
 * 
 * You are given an m x n grid where each cell can have one of three values:
 * 
 * 0 - representing an empty cell,
 * 1 - representing a fresh orange, or
 * 2 - representing a rotten orange.
 * 
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 * 
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
 * 
 * Ref: https://leetcode.com/problems/rotting-oranges/
 */


public class RottenOranges {


    public static int orangesRotting(int[][] grid) {
       
        
        int colLen = grid[0].length;
        int rowLen = grid.length;
        Queue<Pair> queue = new LinkedList<>();
        
        // Find rotten orange position first.
        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                if (grid[row][col] == 2) {
                    queue.add(new Pair(row, col));
                    break;
                }
                col++;
            }
            row++;
        }

        // Depth of BFS
        int minutes = -1;
        int[] r = new int[]{-1,0,1,0};
        int[] c = new int[]{0,1,0,-1};
        //int[][] visited = new int[rowLen][colLen];
        
        // BFS 
        while(!queue.isEmpty()) {
            Pair curr = queue.poll();
            // if position visited already, don't do anything, just pick next pair from queue.
            // if (visited[curr.getRow()][curr.getCol()] == 1)
            //     continue;
            if (grid[curr.getRow()][curr.getCol()] == 0)
                continue;
            // Mark position as visisted true;
            //visited[curr.getRow()][curr.getCol()] = 1;
            boolean isFreshOrange = (grid[curr.getRow()][curr.getCol()] == 1) ? true : false;
            // Mark orange as rotten
            grid[curr.getRow()][curr.getCol()] = 2;
            
            for (int i = 0; i < r.length; i++) {
                int nRow = curr.getRow() + r[i];
                int nCol = curr.getCol() + c[i];
                //if (nRow < 0 || nCol < 0 || nRow >= rowLen || nCol >= colLen || grid[nRow][nCol] != 1 || visited[nRow][nCol] == 1)
                if (nRow < 0 || nCol < 0 || nRow >= rowLen || nCol >= colLen || grid[nRow][nCol] != 1)
                    continue;

                if (grid[nRow][nCol] == 1) {    
                    queue.add(new Pair(nRow, nCol));
                    isFreshOrange = true;
                }
            }
            if (isFreshOrange)
            minutes++;
        }

        // Check all oranges are rotten now
        boolean allOrangesRotten = true;
        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                if (grid[row][col] == 1) {
                    allOrangesRotten = false;
                    break;
                }
                col++;
            }
            row++;
        }
        System.out.println("allOrangesRotten = " + allOrangesRotten);
        return allOrangesRotten ? minutes : -1;
        
    }

    public static void main(String[] args) {
       int[][] grid = new int[][] {{2,1,1},{1,1,0},{0,1,1}};
       int minutes = orangesRotting(grid);
       System.out.println("Example-1: Minutes Taken = " + minutes);

       int[][] grid1 = new int[][] {{2,1,1},{0,1,1},{1,0,1}};
       int minutes1 = orangesRotting(grid1);
       System.out.println("Example-2: Minutes Taken = " + minutes1);
    }


}


class Pair {
    private int row;
    private int col;

    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

}