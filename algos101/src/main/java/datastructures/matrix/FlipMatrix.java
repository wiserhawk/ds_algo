package datastructures.matrix;

/**
 * A 2d array has 0 and 1 as values. In one flip, 0's are changed to 1 if and
 * only if any of the neighbors (left, right, top, bottom) is 1. Return the
 * total number of flips required to convert the whole grid to 1's.
 *
 */
public class FlipMatrix {
	
	public int flipCount(int[][] arr) {
		int count = 1;
		while(!flip(arr)) {
			count++;
		}
		return count;
	}
	
	// flip complete matrix once and return where it completely converted to 1s or not.
	private boolean flip(int[][] arr) {
		int rows = arr.length;
		int cols = arr[0].length;
		
		boolean isComplete = true;
		for (int r = 0; r < rows ; r++) {
			for (int c = 0; c < cols; c++) {
				if (checkCornerCase(arr, r, c)) {
					arr[r][c] = 1;
				} else {
					isComplete = false;
				}
			}
		}
		
		return isComplete;
		
	}
	
	// Check where any of left, right , top, bottom element is 1 or not.
	private boolean checkCornerCase(int[][] arr,int row, int col) {
		int rows = arr.length;
		int cols = arr[0].length;
		if (row-1 >= 0) {
			if(arr[row-1][col] == 1) return true; 
		}
		if (row+1 <= rows-1) {
			if(arr[row+1][col] == 1) return true; 
		}
		if (col-1 >= 0) {
			if(arr[row][col-1] == 1) return true;
		}
		if (col+1 <= cols-1) {
			if(arr[row][col+1] == 1) return true; 
		}
		return false;
	}

	public static void main(String[] args) {
		int[][] arr = new int[][] {{0,0,1},
									{0,0,0},
									{0,0,0}};
		FlipMatrix matrix = new FlipMatrix();
		int count = matrix.flipCount(arr);
		System.out.println("Flip Count = " + count);
		

	}

}
