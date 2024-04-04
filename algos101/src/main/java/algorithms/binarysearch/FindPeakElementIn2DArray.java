package algorithms.binarysearch;

/**
 * Problem : https://leetcode.com/problems/find-a-peak-element-ii/description/
 */

public class FindPeakElementIn2DArray {

    // Using Binary Search on 2D Array
    public static int[] findPeakElement(int[][] matrix) {
        int low = 0, high = matrix[0].length;
        while (low < high) {
            int midCol = (low + high) / 2;
            int maxRow = getMaxElementIndexInColumn(matrix, midCol);

            int currentElement = matrix[maxRow][midCol];
            int left = midCol-1 > -1 ? matrix[maxRow][midCol-1] : -1;
            int right = midCol+1 < matrix[0].length ? matrix[maxRow][midCol+1] : -1;

            if (currentElement > left && currentElement > right)
                return new int[] {maxRow , midCol};
            else if (left > currentElement)
                high = midCol;
            else
                low = midCol;
            
        }
        return new int[] {-1,-1};
    }

    private static int getMaxElementIndexInColumn(int[][] matrix, int colIndex) {
        int maxRowIndex = 0;
        int maxElement = -1;
        for (int i=0; i < matrix.length; i++) {
            if (matrix[i][colIndex] > maxElement) {
                maxElement = matrix[i][colIndex];
                maxRowIndex = i;
            }
        }
        return maxRowIndex;
    } 

    public static void main(String[] args) {

        int[][] matrix = new int[][] {{ 1, 1, 6, 3, 2 }, 
						              { 0, 3, 7, 0, 1 }, 
						              { 2, 5, 8, 9, 2 }, 
						              { 0, 6, 7, 8, 3}, 
						              { 5, 9, 8, 1, 1 }}; 
        int[] peak = findPeakElement(matrix);
        System.out.println("Peak element is at = " + peak[0] + "," + peak[1]);
        System.out.println("Peak element is = " + matrix[peak[0]][peak[1]] );
    }


}
