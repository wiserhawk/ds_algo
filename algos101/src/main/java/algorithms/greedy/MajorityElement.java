package algorithms.greedy;

import java.time.LocalDate;

/**
 * 
Majority Element (Complexity: Easy)
 
Given an array of size N, find the majority element. The majority element is the element that appears more than floor(N/2) times.
You may assume that the array is non-empty and the majority element always exist in the array.



Problem Constraints
1 <= |A| <= 106
1 <= Ai <= 109


Input Format
The first argument is an integer array A.


Output Format
Return the majority element.


Example Input
A = [2, 1, 2]


Example Output
2


Example Explanation
2 occurs 2 times which is greater than 3/2.
 
 */

public class MajorityElement {

	public static int majorityElement(final int[] A) {
		
    }
	
	public static void main(String[] args) {

		LocalDate a = LocalDate.of(2012, 7, 30);
		LocalDate b = LocalDate.of(2012, 6, 30);
		System.out.println(a.isAfter(b)); 

	}

}
