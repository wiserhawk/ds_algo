package algorithms.maths;

/**
Given an integer x, return true if x is a palindrome, and false otherwise.

Example 1:
=============
Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.

Example 2:
===============
Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

Example 3:
===============
Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * 
 */

public class PalindromeNumber {
	
	
	public static boolean isPolindromeNumber(int n) {
		int r = reverseNumber(n);
		return n==r? true : false;
	}
	
	private static int reverseNumber(int n) {
		int r = 0;
		int x = n;
		while (x != 0) {
			int m = x%10;
			x/=10;
			r=r*10+m;
		}
		return r;
	}

	public static void main(String[] args) {
		System.out.println("Is Polindrome = " + isPolindromeNumber(12321));
	}

}
