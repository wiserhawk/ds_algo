package algorithms.maths;

import java.util.ArrayList;
import java.util.List;

/**
Given a number, print all the divisors of the number. A divisor is a number that gives remainder as zero when divided.

Examples:
==================
Example 1:
Input: n = 36
Output: 1 2 3 4 6 9 12 18 36
Explanation: All the divisors of 36 are printed.

Example 2:
Input: n = 97
Output: 1 97
Explanation: Since 97 is a prime number, only 1 and 97 are printed.
 
*/

public class DivisorsOfNumber {

	public static void main(String[] args) {
		List<Integer> divisors = divisorsOfNumber(36);
		System.out.println(divisors);
		
		List<Integer> divisorsOutput = divisorsOfNumberUsingSquareRoot(36);
		System.out.println(divisorsOutput);
		

	}
	
	// Brute Force approach. O(n)
	public static List<Integer> divisorsOfNumber(int n) {
		List<Integer> divisors = new ArrayList<>();
		for (int i=n; i>0; i--) {
			if (n%i == 0)
				divisors.add(i);
		}
		return divisors;
	}
	
	// Better approach. O(Sqrt(n))
	public static List<Integer> divisorsOfNumberUsingSquareRoot(int n) {
		List<Integer> divisors = new ArrayList<>();
		for (int i=1; i <= Math.sqrt(n); i++) {
			if (n%i == 0) {
				divisors.add(i);
				if (i != Math.sqrt(n)) // to remove last duplicate divisor element.
					divisors.add(n/i);
			}
		}
		return divisors;
	}
	
	
}
