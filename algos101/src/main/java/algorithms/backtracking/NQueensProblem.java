package algorithms.backtracking;

/**
 * Let us discuss N Queen as another example problem that can be solved using
 * Backtracking. The N Queen is the problem of placing N chess queens on an N×N
 * chess board so that no two queens attack each other. For example, following is
 * a solution for 4 Queen problem.
 * 
 * The expected output is a binary matrix which has 1s for the blocks where
 * queens are placed. For example, following is the output matrix for above 4
 * queen solution.
 * 
 * { 0, 1, 0, 0} 
 * { 0, 0, 0, 1} 
 * { 1, 0, 0, 0} 
 * { 0, 0, 1, 0}
 * 
 */
public class NQueensProblem {
	
	
	
	
	/* A utility function to print solution */
    public static void printSolution(int[][] board) 
    { 
    	int n = board.length;
        for (int i = 0; i < n; i++) { 
            for (int j = 0; j < n; j++) 
                System.out.print(" " + board[i][j] 
                                 + " "); 
            System.out.println(); 
        } 
    } 
    
    private boolean place
    
    public int[][] solveNQueenProblem(int n) {
    	int[][] borad = new int[n][n];
    	
    }
     

	public static void main(String[] args) {
		int[][] board = {{ 0, 0, 0, 0 }, 
			             { 0, 0, 0, 0 }, 
			             { 0, 0, 0, 0 }, 
			             { 0, 0, 0, 0 }}; 
		
		printSolution(board);
		
		int N = 4;
	}

}
