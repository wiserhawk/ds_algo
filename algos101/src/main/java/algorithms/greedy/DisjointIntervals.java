package algorithms.greedy;

import java.util.Arrays;

/**
Given a set of N intervals, the task is to find the maximal set of mutually disjoint intervals. 
Two intervals [i, j] & [k, l] are said to be disjoint if they do not have any point in common. 

Examples:  
==========
Input: intervals[][] = {{1, 4}, {2, 3}, {4, 6}, {8, 9}} 
Output: 
[2, 3] 
[4, 6] 
[8, 9] 
Intervals sorted w.r.t. end points = {{2, 3}, {1, 4}, {4, 6}, {8, 9}} 
Intervals [2, 3] and [1, 4] overlap. 
We must include [2, 3] because if [1, 4] is included then 
we cannot include [4, 6]. 
Note: Always include interval with small end point so that we create more chance to all disjoint intervals. (Greedy Approach)
Input: intervals[][] = {{1, 9}, {2, 3}, {5, 7}} 
Output: 
[2, 3] 
[5, 7]  
 * 
 */

public class DisjointIntervals {

	
	public static int disjointIntervals(int[][] intervals) {
		if (intervals == null || intervals.length == 0) 
			return -1;
		if (intervals.length == 1) {
			return 1;
		}
		
		// Sorted on internal end-points in ascending order;
		Arrays.sort(intervals, (i1, i2) -> i1[1] - i2[1]);
		
		int count = 1;
		int lastInculdedIndex = 0;
		for (int i=1; i<intervals.length; i++) {
			// End-point of first interval must be less than Start-point of second interval.
			// If it is equal or greater then its overlapping
			if (intervals[lastInculdedIndex][1] < intervals[i][0]) {
				count++;
				lastInculdedIndex = i;
			}
		}
		
		return count;
		
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		int[][] intervals = new int[][] {{1, 4}, {2, 3}, {4, 6}, {8, 9}}; 
		int res = disjointIntervals(intervals);
		System.out.println("1. Max Disjoint Intervals = " + res);
		
		int[][] intervals1 = new int[][] {{1, 9}, {2, 3}, {5, 7}}; 
		int res1 = disjointIntervals(intervals1);
		System.out.println("2. Max Disjoint Intervals = " + res1);

	}

}
