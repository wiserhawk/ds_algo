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
		
		boolean[][] visited = new boolean[rows][cols];
		
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (visited[row][col] == false && matrix[row][col] == 1) {
					List<AdjecentElement> adjecents = islandDFS(row, col, matrix, visited, new ArrayList<AdjecentElement>());
					islandMap.put(++count, adjecents);
				}
			}
		}
		
		printIslands(islandMap);
		
		return islandMap.size();
		
	}
	
	private List<AdjecentElement> islandDFS(int row, int col, int[][] matrix, boolean[][] visited, List<AdjecentElement> adjecents) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		visited[row][col] = true;
		adjecents.add(new AdjecentElement(row, col));
	
		// Check Top Element
		if (row-1 > -1) {
			if (visited[row-1][col] == false) {
				if (matrix[row-1][col] == 1) {
					islandDFS(row-1, col, matrix, visited, adjecents);
					//adjecents.add(new AdjecentElement(row-1, col));
				}
				// Mark Visited
				visited[row-1][col] = true;
			}
			// Top left 
			if (col-1 > -1) {
				if (visited[row-1][col-1] == false) {
					if (matrix[row-1][col-1] == 1) {
						islandDFS(row-1, col-1, matrix, visited, adjecents);
						//adjecents.add(new AdjecentElement(row-1, col-1));
					}
					// Mark Visited
					visited[row-1][col-1] = true;
				}
			}
			// Top Right
			if (col+1 < cols) {
				if (visited[row-1][col+1] == false) {
					if (matrix[row-1][col+1] == 1) {
						islandDFS(row-1, col+1, matrix, visited, adjecents);
						//adjecents.add(new AdjecentElement(row-1, col+1));
					}
					// Mark Visited
					visited[row-1][col+1] = true;
				}
			}
		}
		// Check Bottom Element
		if (row+1 < rows) {
			if (visited[row+1][col] == false) {
				if (matrix[row+1][col] == 1) {
					islandDFS(row+1, col, matrix, visited, adjecents);
					//adjecents.add(new AdjecentElement(row+1, col));
				}
				// Mark Visited
				visited[row+1][col] = true;
			}
			// Bottom left 
			if (col-1 > -1) {
				if (visited[row+1][col-1] == false) {
					if (matrix[row+1][col-1] == 1) {
						islandDFS(row+1, col-1, matrix, visited, adjecents);
						//adjecents.add(new AdjecentElement(row+1, col-1));
					}
					// Mark Visited
					visited[row+1][col-1] = true;
				}
			}
			// Bottom Right
			if (col+1 < cols) {
				if (visited[row+1][col+1] == false) {
					if (matrix[row+1][col+1] == 1) {
						islandDFS(row+1, col+1, matrix, visited, adjecents);
						//adjecents.add(new AdjecentElement(row+1, col+1));
					}
					// Mark Visited
					visited[row+1][col+1] = true;
				}
			}
		}
		// Check Left Element
		if (col-1 > -1) {
			if (visited[row][col-1] == false) {
				if (matrix[row][col-1] == 1) {
					islandDFS(row, col-1, matrix, visited, adjecents);
					//adjecents.add(new AdjecentElement(row, col-1));
				}
				// Mark Visited
				visited[row][col-1] = true;
			}
		}
		// Check Right Element
		if (col+1 < cols) {
			if (visited[row][col+1] == false) {
				if (matrix[row][col+1] == 1) {					
					islandDFS(row, col+1, matrix, visited, adjecents);
					//adjecents.add(new AdjecentElement(row, col+1));
				}
				// Mark Visited
				visited[row][col+1] = true;
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
	
	
	public int findIslands(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		boolean[][] visited = new boolean[rows][cols];
		
		int islandCount = 0;
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (visited[row][col] != true && matrix[row][col] == 1) {
					dfs(row, col, matrix, visited);
					islandCount++;
				}
					
			}
			
		}
		return islandCount;
		
	}
	
	private void dfs(int row, int col, int[][] matrix, boolean[][] visited) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		// Mark Current row and column visited
		visited[row][col] = true;
		
		// Check Top Element
		if (row-1 > -1) {
			if (visited[row-1][col] == false) {
				if (matrix[row-1][col] == 1) {
					dfs(row-1, col, matrix, visited);
				}
				// Mark Visited
				visited[row-1][col] = true;
			}
			// Top left 
			if (col-1 > -1) {
				if (visited[row-1][col-1] == false) {
					if (matrix[row-1][col-1] == 1) {
						dfs(row-1, col-1, matrix, visited);
					}
					// Mark Visited
					visited[row-1][col-1] = true;
				}
			}
			// Top Right
			if (col+1 < cols) {
				if (visited[row-1][col+1] == false) {
					if (matrix[row-1][col+1] == 1) {
						dfs(row-1, col+1, matrix, visited);
					}
					// Mark Visited
					visited[row-1][col+1] = true;
				}
			}
		}
		// Check Bottom Element
		if (row+1 < rows) {
			if (visited[row+1][col] == false) {
				if (matrix[row+1][col] == 1) {
					dfs(row+1, col, matrix, visited);
				}
				// Mark Visited
				visited[row+1][col] = true;
			}
			// Bottom left 
			if (col-1 > -1) {
				if (visited[row+1][col-1] == false) {
					if (matrix[row+1][col-1] == 1) {
						dfs(row+1, col-1, matrix, visited);
					}
					// Mark Visited
					visited[row+1][col-1] = true;
				}
			}
			// Bottom Right
			if (col+1 < cols) {
				if (visited[row+1][col+1] == false) {
					if (matrix[row+1][col+1] == 1) {
						dfs(row+1, col+1, matrix, visited);
					}
					// Mark Visited
					visited[row+1][col+1] = true;
				}
			}
		}
		// Check Left Element
		if (col-1 > -1) {
			if (visited[row][col-1] == false) {
				if (matrix[row][col-1] == 1) {
					dfs(row, col-1, matrix, visited);
				}
				// Mark Visited
				visited[row][col-1] = true;
			}
		}
		// Check Right Element
		if (col+1 < cols) {
			if (visited[row][col+1] == false) {
				if (matrix[row][col+1] == 1) {
					dfs(row, col+1, matrix, visited);
				}
				// Mark Visited
				visited[row][col+1] = true;
			}
		}
	}
	
	
	public static void main(String[] args) {
		int[][] matrix = new int[][] {{ 1, 1, 0, 0, 0 }, 
						              { 0, 1, 0, 0, 1 }, 
						              { 1, 0, 0, 1, 1 }, 
						              { 0, 0, 0, 0, 0 }, 
						              { 1, 0, 1, 0, 1 }}; 
        IslandsInMatrix instance = new IslandsInMatrix();
        instance.numberOfIslands(matrix);
        
        System.out.println("=======================================================");
        
        int count =  instance.findIslands(matrix);
       System.out.println("Number of Islands Found =  " + count);
	}

}
 