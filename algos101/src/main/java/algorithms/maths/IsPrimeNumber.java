package algorithms.maths;

/**
Given a number, check whether it is prime or not. A prime number is a natural number that is only divisible by 1 and by itself.

Examples 1 2 3 5 7 11 13 17 19 …

Examples:

Example 1:
Input: N = 3
Output: Prime
Explanation: 3 is a prime number

Example 2:
Input: N = 26
Output: Non-Prime
Explanation: 26 is not prime
 
 */

public class IsPrimeNumber {

	public static void main(String[] args) {
		System.out.println("Is Prime Number = " + isPrimeNumber(19));
		System.out.println("Is Prime Number = " + isPrimeNumberUsingSqrt(19));

	}
	
	// Brute Force approach. O(n)
	public static boolean isPrimeNumber(int n) {
		for (int i = 2; i < n; i++) {
			if (n%i == 0)
				return false;
		}
		return true;
	}
	
	// Better approach. O(Sqrt(n))
	public static boolean isPrimeNumberUsingSqrt(int n) {
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n%i == 0) 
				return false;
		}
		return true;
	}

}
