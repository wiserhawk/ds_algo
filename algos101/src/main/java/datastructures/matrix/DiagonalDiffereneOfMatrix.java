package datastructures.matrix;

import java.math.BigDecimal;
import java.util.List;

/*
 * Given a square matrix, calculate the absolute difference between the sums of its diagonals.

For example, the square matrix arr is shown below:

1 2 3
4 5 6
9 8 9  
The left-to-right diagonal = 1 + 5 + 9 = 15 . The right to left diagonal = 3 + 5 + 9 = 17. 
Their absolute difference is 15 - 17 = 2.
 */
public class DiagonalDiffereneOfMatrix {

    public static int diagonalDifference(int[][] arr) {
        int leftToRightSum = 0, rightToLeftSum = 0;
    	
    	int rowSize = arr.length;
        int colSize = arr[0].length;
        
        for (int row = 0; row < rowSize; row++) {
        	for (int col = 0; col < colSize; col++) {
        		// left to right diagonal condition, row == col
        		if (row == col)
        			leftToRightSum += arr[row][col];
        		// right to left diagonal condition, row == (numberOfRows - Col - 1)
        		if (row == (rowSize - col -1)) 
        			rightToLeftSum += arr[row][col];
        	}
        }
        return Math.abs(leftToRightSum - rightToLeftSum);	
        
    }
    
    
    public static void main(String[] args) {
		int[][] arr = new int[][] {{1,2,3},{4,5,6},{9,8,9}};
		int result = diagonalDifference(arr);
		System.out.println("Diagonal Difference = " + result);
	}

}

