package algorithms.maths;

/**
For an integer N find the number of trailing zeroes in N!.

Example 1:
============
Input:
N = 5
Output:
1
Explanation:
5! = 120 so the number of trailing zero is 1.
 *
 */

public class TrailingZeroes {
	
	public static int trailingZeroes(int N) {
		int count = 0;
       
		for(int i = 5; i <= N; i = i * 5)
			count += N / i ;
       
		return count;
	}

	public static void main(String[] args) {
		int n = trailingZeroes(15);
		System.out.println("Trailing Zeros = " + n);
	}

}
