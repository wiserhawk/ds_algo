package datastructures.array;

public class PeakFinder {
	
	
	
	public static int findPeak(int[] arr) {
		int pointer = (arr.length-1)/2;
		return divide(pointer, arr);
	}
	
	
	private static int divide(int pointer, int[] arr) {
		
		
		if (pointer < 0 || pointer > arr.length-1) 
			return 0;
		
		if (pointer == 1 && arr[pointer] >= arr[0]) {
			return arr[pointer];
		}
		
		if (pointer == arr.length-2 && arr[pointer] >= arr[arr.length-1]) {
			return arr[pointer];
		}
		
		if (arr[pointer] >= arr[pointer-1] && arr[pointer] >= arr[pointer+1]) 
			return arr[pointer];
		
		int peak = divide(pointer/2, arr) ;
		if (peak > 0) return peak;
		
		peak = divide((pointer + arr.length-1)/2, arr);
		if (peak > 0) return peak;
		
		return 0;
		
		
	}
	
	public static int findPeak(int[][] matrix) {
		return 0;
	}

	public static void main(String[] args) {
		
		int[] array = new int[] {1,2,3,4,5,6,7,9,10};
		
		int[][] matrix = new int[][] {	{ 3, 5, 9, 0, 7 }, 
							            { 0, 6, 7, 0, 1 }, 
							            { 1, 6, 2, 1, 1 }, 
							            { 5, 3, 3, 5, 3 }, 
							            { 1, 8, 8, 6, 1 } };
	
		int peak = findPeak(array);
		System.out.println("Peak Element = " + peak);

	}

}
