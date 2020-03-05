package datastructures.matrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Find numbers of Islands 
// https://www.geeksforgeeks.org/find-number-of-islands/
public class IslandsInMatrix {
	
	
	public int numberOfIslands(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		Map<Integer, List<AdjecentElement>> islandMap = new HashMap<Integer, List<AdjecentElement>>();
		//Islands count
		int count = 0;
		
		int[][] visited = new int[rows][cols];
		
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (visited[row][col] != 1) {
					islandMap.put(count++, island(row, col, matrix, visited));
				}
			}
		}
		
		printIslands(islandMap);
		
		return islandMap.size();
		
	}
	
	private List<AdjecentElement> island(int row, int col, int[][] matrix, int[][] visited) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		List<AdjecentElement> adjecents = new ArrayList<AdjecentElement>();
		// Check Top Element
		if (row-1 >= 0) {
			if (visited[row-1][col] != 1) {
				if (matrix[row-1][col] == 1) {
					adjecents.add(new AdjecentElement(row-1, col));
					// Mark Visited
					visited[row-1][col] = 1;
				}
			}
			// Top left 
			if (col-1 >= 0) {
				if (visited[row-1][col-1] != 1) {
					if (matrix[row-1][col-1] == 1) {
						adjecents.add(new AdjecentElement(row-1, col-1));
						// Mark Visited
						visited[row-1][col-1] = 1;
					}
				}
			}
			// Top Right
			if (col+1 <= 0) {
				if (visited[row-1][col+1] != 1) {
					if (matrix[row-1][col+1] == 1) {
						adjecents.add(new AdjecentElement(row-1, col+1));
						// Mark Visited
						visited[row-1][col+1] = 1;
					}
				}
			}
		}
		// Check Bottom Element
		if (row+1 <= rows-1) {
			if (visited[row+1][col] != 1) {
				if (matrix[row+1][col] == 1) {
					adjecents.add(new AdjecentElement(row+1, col));
					// Mark Visited
					visited[row+1][col] = 1;
				}
			}
			// Bottom left 
			if (col-1 >= 0) {
				if (visited[row+1][col-1] != 1) {
					if (matrix[row+1][col-1] == 1) {
						adjecents.add(new AdjecentElement(row+1, col-1));
						// Mark Visited
						visited[row+1][col-1] = 1;
					}
				}
			}
			// Bottom Right
			if (col+1 <= 0) {
				if (visited[row+1][col+1] != 1) {
					if (matrix[row+1][col+1] == 1) {
						adjecents.add(new AdjecentElement(row+1, col+1));
						// Mark Visited
						visited[row+1][col+1] = 1;
					}
				}
			}
		}
		// Check Left Element
		if (col-1 >= 0) {
			if (visited[row][col-1] != 1) {
				if (matrix[row][col-1] == 1) {
					adjecents.add(new AdjecentElement(row, col-1));
					// Mark Visited
					visited[row][col-1] = 1;
				}
			}
		}
		// Check Right Element
		if (col+1 <= 0) {
			if (visited[row][col+1] != 1) {
				if (matrix[row][col+1] == 1) {
					adjecents.add(new AdjecentElement(row, col+1));
					// Mark Visited
					visited[row][col+1] = 1;
				}
			}
		}
		return adjecents;
	}
	
	private void printIslands(Map<Integer, List<AdjecentElement>> islands) {
		Set<Integer> keySet = islands.keySet();
		for (Integer key : keySet) {
			List<AdjecentElement> island = islands.get(key);
			System.out.println(key + " Island = " + island);
		}
	}
	
	public static class AdjecentElement {
		int row, col;
		
		public AdjecentElement(int row, int col) {
			this.row = row;
			this.col = col;
		}
		
		@Override
		public String toString() {
			return "["+row + "," + col+"]";
		}
	}
	
	
	
	
	

	public static void main(String[] args) {
		int[][] matrix = new int[][] {   { 1, 1, 0, 0, 0 }, 
						            { 0, 1, 0, 0, 1 }, 
						            { 1, 0, 0, 1, 1 }, 
						            { 0, 0, 0, 0, 0 }, 
						            { 1, 0, 1, 0, 1 } }; 
        IslandsInMatrix instance = new IslandsInMatrix();
        instance.numberOfIslands(matrix);
	}

}
 