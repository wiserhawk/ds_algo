package algorithms.dynamicprogramming;

import java.util.Arrays;

/**
 * 
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

=====================================================================
Example:

Input: [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2.
    Jump 1 step from index 0 to 1, then 3 steps to the last index.
=====================================================================

Note: You can assume that you can always reach the last index.

HINT: Recursion & Dynamic Programming

 *
 */

public class JumpGame2 {
	
	int MAX_NUMBER = Integer.MAX_VALUE;
	
	// -1 = default/unused, 0 > minimum jumps
	int[] memoization = null;
	
	
	public int minJumps(int[] jumps) {
		int size = jumps.length;
		if (size == 1) 
			return 1;
		
		memoization = new int[size];
		Arrays.fill(memoization, -1);
		return jumps(0, size-1, jumps, 0);
        
    }
	
	private int jumps(int index, int lastIndex, int[] jumps, int currStep) {
		if (memoization[index] > -1) {
			return memoization[index];
		}
		
		if (index == lastIndex)
			return 1;
		
		int steps = jumps[index];
		
		int minJumps = MAX_NUMBER;
		for (int step = steps; step > 0; step--) {
			if (index+step < jumps.length)
				minJumps = Integer.min(minJumps, jumps(index+step, lastIndex, jumps, step) + currStep);
		}
		memoization[index] = minJumps ;
		return minJumps;
	}
	
	

	public static void main(String[] args) {
		JumpGame2 jumpGame = new JumpGame2();
		
		//========================================================================
		int[] array = new int[] {2,3,1,1,4};
		int minJumps = jumpGame.minJumps(array);
		System.out.println("Minimum jumpes I need to reach end are " + minJumps);
		
		//========================================================================
		int[] array1 = new int[] {2,4,1,1,3,2,1,2,1,4};
		minJumps = jumpGame.minJumps(array1);
		 EXPECTED = 4
		System.out.println("Minimum jumpes I need to reach end are " + minJumps);
		
		
		
		

	}

}
