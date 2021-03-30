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
 Canvas  ->	1		2  		3 		4
 aabba   ->	aa  	bb   			a
 aabba   ->	aa  	bb   			a
 aaaca   ->	aaa    			c 		a
 
 */

public class StrokesToPaint {
	
	public static int strokesRequired(char[][] painting) {
		int h = painting.length;
		int w = painting[0].length;
		boolean[][] memo = new boolean[h][w];
		
		int strokes = 0;
		for (int r = 0; r < h; r++) {
			for (int c = 0; c < w; c++) {
				if (memo[r][c] == false) {
					stroke(painting, memo, r, c);
					strokes++;
				}
			}
		}
		return strokes;	
	}
	
	private static void stroke(char[][] painting, boolean[][] memo, int r, int c) {
        memo[r][c] = true;
        int h = painting.length;
        int w = painting[0].length;
         
        char ch = painting[r][c];
        
        int plus_col = c+1 < w ? c+1 : -1;
        if (plus_col != -1 && painting[r][plus_col] == ch && memo[r][plus_col] == false)
            stroke(painting, memo, r, plus_col);
            
        int plus_row = r+1 < h ? r+1 : -1;
        if (plus_row != -1 && painting[plus_row][c] == ch && memo[plus_row][c] == false)
            stroke(painting, memo, plus_row, c);
            
        int minus_col = c-1 >= 0 ? c-1 : -1;
        if (minus_col != -1 && painting[r][minus_col] == ch && memo[r][minus_col] == false)
            stroke(painting, memo, r, minus_col);
        
        int minus_row = r-1 >= 0  ? r-1 : -1; 
        if (minus_row != -1 && painting[minus_row][c] == ch && memo[minus_row][c] == false)
            stroke(painting, memo, minus_row, c);
	}

	public static void main(String[] args) {
		//aabba
		//aabba
		//aaaca
		char[][] painting = new char[][] {{'a','a','b','b','a'},{'a','a','b','b','a'}, {'a','a','a','c','a'}};
		int strokes = StrokesToPaint.strokesRequired(painting);
		// Expected = 4 
		System.out.println("Strokes = " + strokes);
		
		//bbba
		//abba
		//acaa
		//aaac
		char[][] painting1 = new char[][] {{'b','b','b','a'},{'a','b','b','a'}, {'a','c','a','a'}, {'a','a','a','c'}};
		int strokes1 = StrokesToPaint.strokesRequired(painting1);
		// Expected = 4 
		System.out.println("Strokes = " + strokes1);
		
	}

}
