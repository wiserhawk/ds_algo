package algorithms.maths;

/**
 * 
Problem Statement: Given an integer N , write program to count number of digits in N.

Examples:

Example 1:
==========
Input: N = 12345
Output: 5
Explanation: N has 5 digits

Example 2:
==========
Input: N = 8394
Output: 4
Explanation: N has 4 digits


 */

public class CountDigitsInNumber {

	public static void main(String[] args) {
		System.out.println("Digits Count = " + countDigits(24010587));
	}
	
	private static int countDigits(int n) {
		int x = n, count = 0;
		while(x != 0) {
			x = x/10;
			count++;
		}
		return count;
	}

}
