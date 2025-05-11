package datastructures.graphs.shortestpath;

import java.util.LinkedList;
import java.util.Queue;


// https://takeuforward.org/data-structure/g-36-shortest-distance-in-a-binary-maze/
public class ShortestDistanceInBinaryMaze {

    public static class Position {
        int row, col, distance;

        public Position(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
        
    }

    public static int shortestPath(int[] src, int[] dest, int[][] maze) {
        int[] rowDirections = new int[] {-1, 0, 1, 0};
        int[] colDirections = new int[] {0, 1, 0, -1};

        boolean[][] visited = new boolean[maze.length][maze[0].length];

        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(src[0], src[1], 0));

        while (!queue.isEmpty()) {
            Position pos = queue.poll();
            int currRow = pos.row;
            int currCol = pos.col;
            int currDistance = pos.distance;

            visited[currRow][currCol] = true;
            if (currRow == dest[0] && currCol == dest[1])
                return pos.distance;
            
            for (int i=0; i<4; i++) {
                int nextRow = currRow + rowDirections[i];
                int nextCol = currCol + colDirections[i];
                if (nextRow >= 0 && nextRow < maze.length && 
                       nextCol >= 0 && nextCol < maze[0].length && 
                        maze[nextRow][nextCol] == 1 && !visited[nextRow][nextCol]) {
                    queue.add(new Position(nextRow, nextCol, currDistance+1));
                }
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        int[] src = {0, 1}, dest = {2, 2};
        int[][] maze = {{1, 1, 1, 1},
                        {1, 1, 0, 1},
                        {1, 1, 1, 1},
                        {1, 1, 0, 0},
                        {1, 0, 0, 1}};
        System.out.println("Shortest Path = " + shortestPath(src, dest, maze));
    }

}
