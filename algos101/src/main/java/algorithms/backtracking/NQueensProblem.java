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
    public static void solveNQueens(int n) { 
    	int[][] board = new int[n][n];
    	int row = 0;
    	placeQueen(board, n, row);
    	printBoard(board);
    } 
    
    private static boolean placeQueen(int[][] board, int n, int row) {
    	if (row >= n) 
    		return true;
    	
    	for (int col = 0; col < n; col++) {
			if (col-1 > -1) 
				board[row][col-1] = 0;
			if (isSafe(board, row, col)) {
				board[row][col] = 1;
				if (placeQueen(board, n, row+1))
					return true;
			}
		}
    	return false;
    }
    
   
    private static boolean isSafe(int[][] board, int row, int col) {
    	int i, j;

        /* Check this row on left side */
        for (i = 0; i < row; i++)
            if (i != row && board[i][col] == 1)
                return false;

        /* Check upper diagonal on left side */
        for (i=row, j=col; i>=0 && j>=0; i--, j--)
            if (i != row && j != col && board[i][j] == 1)
                return false;

        /* Check lower diagonal on left side */
        for (i=row, j=col; j>=0 && i<board.length; i++, j--)
            if (i != row && j != col && board[i][j] == 1)
                return false;

        return true;
    }
    
    public static void printBoard(int[][] board) {
    	for (int i = 0; i < board.length; i++) {
    	    for (int j = 0; j < board[i].length; j++) {
    	        System.out.print(board[i][j] + " ");
    	    }
    	    System.out.println();
    	}
    }
    
    
     

	public static void main(String[] args) {
		int[][] board1 = {{ 0, 0, 0, 0 }, 
			             { 0, 0, 0, 0 }, 
			             { 0, 0, 0, 0 }, 
			             { 0, 0, 0, 0 }}; 
		
		solveNQueens(8);
		
		
	}

}
