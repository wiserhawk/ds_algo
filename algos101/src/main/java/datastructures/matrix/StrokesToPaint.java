package datastructures.matrix;

/**
 *
Problem Statement
Alex wants to paint a picture but hates taking the brush off the canvas. In one stroke, 
Alex can only paint the same colored cells which are joined via some edge.

Given the painting, determine the minimum number of strokes to completely paint the picture.

Take for example, the canvas with height given by h = 3 and width given by w = 5 is to be painted with picture picture=[“aabba”, “aabba”, “aaaca”], 
the diagram below shows the 4 strokes needed to paint the canvas.

        Strokes
 Canvas  1   	2  	3 	4
 aabba   aa  	bb   	a
 aabba   aa  	bb   	a
 aaaca   aaa    	c 	a
 *
 */

public class StrokesToPaint {
	
	public static int strokesRequired(char[][] painting) {
		int row = painting.length;
		int col = painting[0].length;
		boolean[][] visited = new boolean[row][col];
		
		int stroks = 0;
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				if (visited[r][c] == false) {
					// Check if Adjacent elements are same, 
					// if yes, mark them visited to avoid further analysis. 
					markStrok(r, c, row, col, painting, visited);
					stroks++;
				}
			}
		}
		return stroks;
	}
	

	// Recursive method that check whether Adjacent elements are same, 
	// if yes, mark them visited (memoization technique) to avoid further analysis on them.
	private static void markStrok(int r, int c, int h, int w, char[][] painting, boolean[][] visited) {
		// Mark element visited.
		visited[r][c] = true;
		
		// Check right adjacent
		if (c+1 < w) // Check is column index out of range. 
			if (painting[r][c] == painting[r][c+1]) // right adjacent
				markStrok(r, c+1, h, w, painting, visited);
		
		// Check bottom adjacent
		if (r+1 < h) // Check is row index out of range.
			if (painting[r][c] == painting[r+1][c]) // bottom adjacent
				markStrok(r+1, c, h, w, painting, visited);
	}

	public static void main(String[] args) {
		
		char[][] painting = new char[][] {{'a', 'a', 'b', 'b', 'a'},
								 		  {'a', 'a', 'b', 'b', 'a'}, 
								          {'a', 'a', 'a', 'c', 'a'}};
								        
		int stroks = strokesRequired(painting);
		
		System.out.println("Number of Stroks Request to Point = " + stroks);
	}

}
