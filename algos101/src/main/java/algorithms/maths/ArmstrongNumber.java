package algorithms.maths;

/**
 * 
For a given 3 digit number, find whether it is Armstrong number or not. 
An Armstrong number of three digits is an integer such that the sum of the cubes of its digits is equal to the number itself. 
Return "Yes" if it is a Armstrong number else return "No".

NOTE: 371 is an Armstrong number since (3*3*3) + (7*7*7) + (1*1*1) = 371
 * 
 */

public class ArmstrongNumber {
	
	public static boolean isArmstrongNumber(int n) {
		int a = 0;
		int x = n;
		
		while (x!=0) {
			int d = x%10;
			a += pow(d, 3);
			x/=10;
		}
		return n == a ? true : false;
	}
	
	private static int pow(int base, int exponent) {
		int result = 1;
		int e = exponent;
		while (e!=0) {
			result = result * base;
			e--;
		}
		return result;
	}

	public static void main(String[] args) {

		System.out.println("Is Armstrong Number = " + isArmstrongNumber(371));

	}

}
