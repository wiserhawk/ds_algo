package datastructures.graphs.shortestpath;

import java.util.PriorityQueue;

// https://takeuforward.org/data-structure/g-37-path-with-minimum-effort/

public class PathWithMinimumEfforts {

    public static class Position {
        int row, col, diff;
        
        public Position(int row, int col, int diff) {
            this.row = row;
            this.col = col;
            this.diff = diff;
        }
    }

    public static int minimumEffort(int[] src, int[] dest, int[][] heights) {
        int rowLen = heights.length;
        int colLen = heights[0].length;
        
        int[] rowsDir = {-1, 0, 1, 0};
        int[] colsDir = {0, 1, 0, -1};

        boolean[][] visited = new boolean[rowLen][colLen];
        
        PriorityQueue<Position> minHeap = new PriorityQueue<>((a, b) -> a.diff - b.diff);
        minHeap.add(new Position(src[0], src[1], 0));

        while (!minHeap.isEmpty()) {
            Position position = minHeap.poll();
            int currRow = position.row;
            int currCol = position.col;
            int currDiff = position.diff;

            visited[currRow][currCol] = true;

            if (currRow == dest[0] && currCol == dest[1]) {
                return currDiff;
            }

            for (int i=0; i<4; i++) {
                int nextRow = currRow + rowsDir[i];
                int nextCol = currCol + colsDir[i];

                if (nextRow >= 0 && nextRow < rowLen && nextCol >= 0 && nextCol < colLen && !visited[nextRow][nextCol]) {
                    int diff = Math.abs(heights[currRow][currCol] - heights[nextRow][nextCol]);
                    minHeap.add(new Position(nextRow, nextCol, diff));
                }
            }
        }
        return -1;

    }



    public static void main(String[] args) {

        int[][] heights = {{1,2,2},{3,8,2},{5,3,5}};
        int[] src = {0, 0};
        int[] dest = {heights.length - 1, heights[0].length - 1};

        System.out.println("Minimum Effort Path = " + minimumEffort(src, dest, heights));

    }

}
