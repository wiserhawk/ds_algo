package datastructures.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
How Many Numbers Are Smaller Than the Current Number
 
Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. 
That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].

Return the answer in an array.

Example 1:
=====================================================================
Input: nums = [8,1,2,2,3]
Output: [4,0,1,1,3]
Explanation: 
For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3). 
For nums[1]=1 does not exist any smaller number than it.
For nums[2]=2 there exist one smaller number than it (1). 
For nums[3]=2 there exist one smaller number than it (1). 
For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).


Example 2:
======================================================================
Input: nums = [6,5,4,8]
Output: [2,1,0,3]


Example 3:
======================================================================
Input: nums = [7,7,7,7]
Output: [0,0,0,0]
 
 
 */
public class SmallerThanCurrentNumber {
	
	
	//O(n log (n))
	public static int[] smallerNumbersThanCurrent(int[] nums) {
    
		int[] result = new int[nums.length];
		int[] originalArray = Arrays.copyOf(nums, nums.length);
		//O (n log(n))
		Arrays.sort(nums);
		Map<Integer, Integer> map = new HashMap<>();
		
		//O(n)
		for (int i = nums.length - 1; i >= 0; i--) {
			map.put(nums[i], i);
		}
		
		//O(n)
		for (int i = 0; i < originalArray.length; i++) {
			result[i] = map.get(originalArray[i]);
		}
		
		// Overall n log(n) + n + n = n log(n)
		return result;
		
     }
	
	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ",");
		}
	}
	
	public static void main(String[] args) {
		int[] nums = new int[] {8,1,2,2,3};
		int[] result = smallerNumbersThanCurrent(nums);
		printArray(result);
	}

}
