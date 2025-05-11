package algorithms.greedy;

import java.time.LocalDate;

/**
 * 
 * Majority Element (Complexity: Easy)
 * 
 * Explanation : https://www.geeksforgeeks.org/majority-element/
 * 
 * Given an array of size N, find the majority element. The majority element is the element that appears more than floor(N/2) times.
 * You may assume that the array is non-empty and the majority element always exist in the array.

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


	/**
	 * Possible Solutions:
	 * [Naive Approach] Using Two Nested Loops – O(n^2) Time and O(1) Space
	 * [Better Approach] Using Sorting – O(n log n) Time and O(1) Space
	 * [Optimal Approach] Using Hashing – O(n) Time and O(n) Space
	 * [Expected Approach] Using Moore’s Voting Algorithm- O(n) Time and O(1) Space
	 */


	// [Expected Approach] Using Moore’s Voting Algorithm- O(n) Time and O(1) Space
	public static int majorityElement(final int[] arr) {
		int count = 0;
		int candidate = -1;

		// find possible majority candidate, which might have appreared more then half time;
		for (int element : arr) {
			if (count == 0) {
				// found new candidate and reset initialize counter with 1.
				candidate = element;
				count = 1;
			} else if (element == candidate) {
				count++;
			} else {
				count--;
			}
		}
		System.out.println("Majority Candidate = " + candidate);

		count = 0;
		for (int element : arr) {
			if (element == candidate) 
				count++;
		}

		return (count > (arr.length / 2)) ? candidate : -1;
    }

	public static void main(String[] args) {
		int[] arr = new int[] {2, 1, 2, 2, 2, 5, 6, 6, 2, 2, 9};
		System.out.println("Majority Element = " + majorityElement(arr));

	}

}
