package algorithms.maths;

/**
 * 
Find GCD (Greatest Common Divisor) or HCF (Highest Common Factor) of two numbers.
NOTE- GCD of two or more numbers is the greatest common factor number that divides them, exactly. It is also called the HCF

Examples:
===========
Example 1:
Input: num1 = 4, num2 = 8
Output: 4
Explanation: Since 4 is the greatest number which divides both num1 and num2.

Example 2:
Input: num1 = 3, num2 = 6
Output: 3
Explanation: Since 3 is the greatest number which divides both num1 and num2.
 * 
 */

public class GCD_HCF {

	public static void main(String[] args) {
		
		System.out.println("GCD = " + gcd(10, 15));
		System.out.println("GCD = " + recursinveGcd(10, 15));

	}
	
	// Brute force approach. O(n)
	public static int gcd(int a, int b) {
		int x = b>a ? a : b;
		while (x != 1) {
			if (a%x == 0 && b%x == 0)
				return x;
			x--;
		}
		return x;
	}
	
	// Better approach (recursive) O(log n)
	public static int recursinveGcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}

}
