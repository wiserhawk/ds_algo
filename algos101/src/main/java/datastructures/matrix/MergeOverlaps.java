package datastructures.matrix;

public class MergeOverlaps {
	
	 public static int[][] mergeOverlap(int[][] values) {
	        int[][] results = new int[values.length][2];
	        int position = 0;
	        int[] mergeValue = values[0];
	        for (int x = 1; x < values.length; x++) {
	            int[] currentValue = values[x];
	            if (mergeValue[1] >= currentValue[0]) {
	                mergeValue[1] = currentValue[1];
	            } else {
	                results[position] = mergeValue;
	                mergeValue = currentValue;
	                position++;
	            }
	        }
	        results[position] = mergeValue;
	        return results;
	    }
	    
	    public static void printResult(int[][] values) {
	        for (int i=0; i < values.length; i++) {
	            int[] row = values[i];
	            System.out.println(row[0] + " , " + row[1]);
	        }
	    }
	    
	    
		public static void main(String[] args) {
			System.out.println("Running...");
			int[][] values = new int[][] {{-5, 0},{1, 3}, {2, 6}, {4, 8}, {9, 12}};
			int[][] results = mergeOverlap(values);
			System.out.println("results ======> " );
			printResult(results);
		}

}
