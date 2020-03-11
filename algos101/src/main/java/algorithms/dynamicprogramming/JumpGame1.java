package algorithms.dynamicprogramming;

import java.util.Arrays;

/**
 * 
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.
===============================================================================
Example 1:

Input: [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

================================================================================
Example 2:

Input: [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum
             jump length is 0, which makes it impossible to reach the last index.
             
 ===============================================================================
 
 HINT: Recursion & Dynamic Programming 

 *
 */

public class JumpGame1 {
	
	// -1 = default/unused, 0 = false, 1 = true
	int[] memoization = null;
	
	public boolean canJump(int[] jumps) {
		int size = jumps.length;
		if (size == 1) return true;
		memoization = new int[size];
		Arrays.fill(memoization, -1);
		return jump(0, size-1, jumps);
    }
	
	// This is recursive function
	private boolean jump(int index, int lastIndex, int[] jumps) {
		if (memoization[index] == 0 ) 
			return false;
		else if (memoization[index] == 1)
			return true;
		
		if (index == lastIndex) {
			memoization[index] = 1;
			return true;
		}
		
		boolean reached = false;
		int steps = jumps[index];
		for (int step = steps; step > 0; step--) {
			if (index+step <= lastIndex) {
				reached = jump(index+step, lastIndex, jumps);
				memoization[index+step] = (reached == true) ? 1 : 0;
			}
		}
		
		return reached;
	}
	
	public static void main(String[] args) {

		JumpGame1 jumpGame = new JumpGame1();
		
		int[] array1 = new int[] {2,3,1,1,4};
		boolean canReach = jumpGame.canJump(array1);
		System.out.println("Can I reach to end = " + canReach);
		
		////////////////////////////////////////////////////////
		
		int[] array2 = new int[] {3,2,1,0,4};
		canReach = jumpGame.canJump(array2);
		System.out.println("Can I reach to end = " + canReach);
		
		
		
	}
}
