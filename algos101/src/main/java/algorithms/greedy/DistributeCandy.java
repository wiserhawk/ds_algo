package algorithms.greedy;

import java.util.Iterator;
import java.util.PriorityQueue;

/**
Distribute Candy (Complexity: Hard)
There are N children standing in a line. Each child is assigned a rating value given in the integer array ratings.
You are giving candies to these children subjected to the following requirements:

--> Each child must have atleast one candy.
--> Children with a higher rating get more candies than neighbors.

Return the minimum number of candies you need to have to distribute the candies to the children.

Example 1:
==================
Input:
N = 3
ratings [ ] = {1, 0, 2}
Output: 5
Explanation: 
You can allocate to the first, second and third child with 2, 1, 2 candies respectively.

Example 2:
==================
Input:
N = 3
ratings [ ] = {1, 2, 2}
Output: 4
Explanation: 
You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
The third child gets 1 candy because it satisfies the above two conditions.

Your Task:
You don't need to read input or print anything. Your task is to complete the function minCandy() which takes the integer N 
and integer array ratings[ ] as parameters and returns the minimum number of candies you need to have to distribute the candies to the children.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 <= N <=  5*104
0 <= ratings <= 105

*/
public class DistributeCandy {
	
	
	public static int minCandy(int n, int[] ratings) {
		// You can use Min Heap or Sort Array in asc order.
		PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> a-b);
		// Added all rating into min heap.
		for (int i = 0; i < ratings.length; i++) {
			minHeap.add(ratings[i]);
		}
		
		int[] candies = new int[n];
		int total = 0;
		int lastRate = -1;
		while(!minHeap.isEmpty()) {
			int r = minHeap.poll();
			if (lastRate == r) 
				continue;
			lastRate = r;
			
			for (int i = 0; i < ratings.length; i++) {
				if (ratings[i] == r) {
					int defCan = 1;
					if (i>0 && r > ratings[i-1])
						defCan = candies[i-1]+1;
					if (i<n-1 && r> ratings[i+1])
						defCan = Math.max(candies[i+1], defCan);
					candies[i] = defCan;	 
					total= total + defCan;
				}
			}
		}
		
		return total;
	}

	public static void main(String[] args) {
		int n = 3;
		int[] ratings = new int[] {1,2,2};
		int total = minCandy(n, ratings);
		System.out.println("1. Min Distributed Candies = " + total);


		int n1 = 8;
		int[] ratings1 = new int[] {3,5,4,11,2,9,7,9};
		int total1 = minCandy(n1, ratings1);
		System.out.println("2. Min Distributed Candies = " + total1);

	}

}
