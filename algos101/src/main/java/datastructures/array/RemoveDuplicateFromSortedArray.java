package datastructures.array;

/**
Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.

Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.

Return k after placing the final result in the first k slots of nums.

Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.


Example 1:
======================================
Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).


Example 2:
======================================
Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).

*/

public class RemoveDuplicateFromSortedArray {
	
	
	public static int removeDuplicates(int[] nums) {
		if (nums == null)
			return 0;
		if (nums.length < 2)
			return nums.length;

		int slow = 0; // slow pointer
		int fast = 1; // fast pointer
		for (; fast < nums.length; fast++) {
			if (nums[slow] != nums[fast]) {
				nums[++slow] = nums[fast];
			}
		}
		printArray(nums);
		return slow+1;
	}
	
	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ",");
		}
		System.out.println("\n");
	}

	public static void main(String[] args) {


		 int[] nums = new int[] {0,0,1,1,1,2,2,3,3,4};
		 int output = removeDuplicates(nums);
		 System.out.println("Output = " + output);

	}

}
