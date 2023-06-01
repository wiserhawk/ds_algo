package algorithms.maths;

/**
Given an array of size N-1 such that it only contains distinct integers in the range of 1 to N. Find the missing element.

Example 1:
=================
Input: N = 5
A[] = {1,2,3,5}
Output: 4

*/

public class MissingNumber {
	
	public static int findMissingNumber(int[] arr) {
		int n = arr.length + 1;
		int expectedSum = n * (n + 1) / 2;
		int sum = 0;
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return expectedSum - sum;
	}
	
	public static void main(String[] args) {
		int[] array = new int[]{6,1,2,8,3,4,7,10,5};
		int missingNum = findMissingNumber(array);
		System.out.println("Missing Number = " + missingNum);
	}

}
