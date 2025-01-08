package datastructures.graphs.dfs_bfs;

// https://takeuforward.org/graph/surrounded-regions-replace-os-with-xs/

public class SurroundedRegions {

    public static int[][] surroundedRegions(int[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        boolean[][] visited = new boolean[rowLen][colLen];

        // visit first and last columns of grid
        for (int r = 0; r < rowLen; r++) {
            if (grid[r][0] == 0) {
                dfs(r, 0, grid, visited);
            }
            if (grid[r][colLen - 1] == 0) {
                dfs(r, colLen - 1, grid, visited);
            }
        }

        // visit top and bottom rows of grid
        for (int c = 0; c < colLen; c++) {
            if (grid[0][c] == 0) {
                dfs(0, c, grid, visited);
            }
            if (grid[rowLen - 1][c] == 0) {
                dfs(rowLen - 1, c, grid, visited);
            }
        }

        // Fill surrounded regions with 1s
        fillSurroundedZeros(grid, visited);

        return grid;
    }

    private static void dfs(int row, int col, int[][] grid, boolean[][] visited) {
        if (grid[row][col] != 0 && visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        int[] rows = new int[] { -1, 0, 1, 0 };
        int[] cols = new int[] { 0, 1, 0, -1 };
        for (int i = 0; i < 4; i++) {
            int nextRow = row + rows[i];
            int nextCol = col + cols[i];
            if (nextRow >= 0 && nextRow < grid.length && nextCol >= 0
                    && nextCol < grid[0].length && grid[nextRow][nextCol] == 0 && visited[nextRow][nextCol] == false) {

                dfs(nextRow, nextCol, grid, visited);
            }
            
        }
    }

    private static void fillSurroundedZeros(int[][] grid, boolean[][] visited) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        for (int r = 0; r < rowLen; r++) {
            for (int c = 0; c < colLen; c++) {
                if (grid[r][c] == 0 && visited[r][c] == false) {
                    grid[r][c] = 1;
                }
            }
        }
    }

    public static void printGrid(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[][] grid = new int[][] {
                { 1, 1, 1, 1 },
                { 1, 0, 1, 1 },
                { 1, 0, 0, 1 },
                { 1, 0, 1, 1 },
                { 1, 1, 0, 0 }
        };
        System.out.println("Input Grid");
        printGrid(grid);

        System.out.println("Output Grid");
        printGrid(surroundedRegions(grid));

    }

}
