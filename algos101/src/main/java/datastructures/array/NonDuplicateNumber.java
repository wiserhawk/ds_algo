package datastructures.array;

/**
 * Find a non duplicate number in an Array.
 * 
 * HINT: Solve this problem by XOR of whole array. which will return non repeated number.
 * 		X^X = 0
 * 		0^Y = Y
 * 
 * Solution Like : https://www.youtube.com/watch?v=u5-ss5kKy7g&list=PLfBJlB6T2eOshO8-LYaMt-Pes1IFojJ_l&index=21
 *
 */

public class NonDuplicateNumber {
	
	// Find one duplicate number in given array.
	public static int findUniqueNumber(int[] arr) {
		int xor = 0;
		for (int i : arr) {
			xor = xor ^ i;
		}
		return xor;
	}
	
	// Find all non duplicate numbers in given array.
	public static int[] findUniqueNumbers(int[] arr) {
		// TODO write algo here...
		return new int[] {};
	}
 
	public static void main(String[] args) {
		int[] arr = new int[] {3,6,4,7,5,3,5,6,4};
		int number = findUniqueNumber(arr);
		System.out.println("Non Duplicate Number = " + number);
	}

}
