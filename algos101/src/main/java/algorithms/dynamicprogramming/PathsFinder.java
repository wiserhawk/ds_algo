package algorithms.dynamicprogramming;

/**
* 
* Given a grid of size m * n, let us assume you are starting at (1, 1) and your goal is to reach (m, n). At any instance, 
* if you are on (x, y), you can either go to (x, y + 1) or (x + 1, y).
* Now consider if some obstacles are added to the grids. How many unique paths would there be?
* An obstacle and empty space are marked as 1 and 0 respectively in the grid.

	Examples:  

	Input: [[0, 0, 0],
			[0, 1, 0],
			[0, 0, 0]]
	Output : 2
	There is only one obstacle in the middle.
 * 
 */

public class PathsFinder {
	
	
	public static int findPaths(int[][] grid, int rows, int cols) {
		int[][] memo = new int[rows][cols];

	}
	
	private static findPath(int[][] grid, int[][] memo, int row, int col) {
		
	}
	
	public static void main(String[] args) {
		int[][] grid = new int[][] {{0,0,0}, {0,1,0}, {0,0,0}};
		int paths = findPaths(grid, 3, 3);
		System.out.println("Total Paths = " + paths);
	}

}
