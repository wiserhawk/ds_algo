package datastructures.graphs.dfs_bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DistanceOfNearestOne {


    public static int[][] findNearestOnes(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] output = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c= 0; c < cols; c++) {
                bfs(r, c, grid, output);
            }
        }
        return output;
    }

    private static void bfs(int row, int col, int[][] grid, int[][] output) {
        
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        int[] xDirections = new int[] {-1, 0, 1, 0};
        int[] yDirections = new int[] {0, 1, 0, -1};

        Queue<Coordinate> queue = new LinkedList<Coordinate>();
        queue.add(new Coordinate(row, col, 0));

        while (!queue.isEmpty()) {
            Coordinate coordinate = queue.poll();
            int x = coordinate.x;
            int y = coordinate.y;
            if (visited[x][y])
                break;
            visited[x][y] = true;
            if (grid[x][y] == 1) {
                output[row][col] = coordinate.steps;
                break;
            }
            else {
                for (int i = 0; i < xDirections.length; i++) {
                    int nextX = x + xDirections[i];
                    int nextY = y + yDirections[i];
                    if (withInLimit(nextX, nextY, rows, cols))
                        queue.add(new Coordinate(nextX, nextY, coordinate.steps+1));
                }
            }
        }
    } 

    private static boolean withInLimit(int x, int y, int rows, int cols) {
        return !(x < 0 || x >= rows || y < 0 || y >= cols);
    }

    public static void print2DGrid(int grid[][])
    {
        // Loop through all rows
        for (int[] row : grid)

            // converting each row as string
            // and then printing in a separate line
            System.out.println(Arrays.toString(row));
    }

    public static class Coordinate {
        public int x;
        public int y;
        public int steps;
        
        Coordinate(int x, int y, int steps) {
            this.x = x;
            this.y = y;
            this.steps = steps;
        }
    }

    public static void main(String[] args) {
        int[][] grid = new int[][] {
            {1,0,1},
            {1,1,0},
            {1,0,0}
        };
        System.out.println("Input Grid");
        print2DGrid(grid);
        grid = findNearestOnes(grid);
        System.out.println("Output Grid");
        print2DGrid(grid);

    }

}
