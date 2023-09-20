package algorithms.greedy;

import java.util.ArrayList;
import java.util.List;

/**
Seats (Complexity: Medium)
There is a row of seats represented by string A. Assume that it contains N seats adjacent to each other. 
There is a group of people who are already seated in that row randomly. i.e. some are sitting together & some are scattered.

An occupied seat is marked with a character 'x' and an unoccupied seat is marked with a dot ('.')

Now your target is to make the whole group sit together i.e. next to each other, without having any vacant seat between them in such a way that the total number of hops or jumps to move them should be minimum.

In one jump a person can move to the adjacent seat (if available).

NOTE:  1. Return your answer modulo 107 + 3.



Problem Constraints
1 <= N <= 1000000

A[i] = 'x' or '.'



Input Format
The first and only argument is a string A of size N.


Output Format
Return an integer denoting the minimum number of jumps required.

Example

Input-1:
===========
A = "....x..xx...x.."
Output-1: 5
Hint: Now to make them sit together one of approaches is:  . . . . . . x x x x . . . . .


Input-2:
=========
 A = "....xxx"
Example Output
Output-2: 0


HINT: Middle point of all Xs will be minimum number of jumps. So the median of all positions of Xs would be a central point.
 */


public class Seats {
	
	public static int seats(String A) {
		
		List<Integer> positions = new ArrayList<>();
		for (int i = 0; i < A.length(); i++) {
			if (A.charAt(i) == 'x')
				positions.add(i);
		} 
		
		int count = 0;
		int middle = median(positions);
		char[] arr = A.toCharArray();
		int lx = middle-1, ldot = middle, rx = middle+1, r = middle;
		
		while (lx > 0) {
			if (arr[ldot] == '.' && arr[lx] == 'x') {
				count = count + ldot - lx;
				char temp = arr[ldot];
				arr[ldot] = arr[lx];
				arr[lx] = temp;
			}
			if (arr[ldot] != '.' )
				ldot--;
			lx--;
		}
		
		
//		while(lx > 0 || rx < arr.length) {
//			if (arr[l] == '.' && arr[lx] == 'x') {
//				count = count + l - lx;
//				char temp = arr[l];
//				arr[l] = arr[lx];
//				arr[lx] = temp;
//				l--;
//			}
//			lx--;
//				
//		}
		
		
	}
	
	
	public static int median(List<Integer> positions) {
		int size = positions.size();
		if (size%2 == 1) {
			return positions.get(size/2);
		} else {
			return (positions.get(size-1/2) + positions.get(size/2)) / 2;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
