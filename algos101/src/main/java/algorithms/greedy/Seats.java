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

	public static int moveSeats(String A) {
		List<Integer> currentPositions = new ArrayList<>();
		for (int i=0; i < A.length(); i++) {
			if (A.charAt(i) == 'x')
				currentPositions.add(i);
		}

		int median = median(currentPositions);
		System.out.println("Median = " + median);
		char[] seats = A.toCharArray();
		return moveLeftSeats(seats, median) + moveRightSeats(seats, median);
	}

	private static int moveRightSeats(char[] seats, int median) {
		int count = 0;
		int dot = median;
		int x = median;
		while (dot < seats.length) {
			if (dot >= seats.length) break;
			if (x >= seats.length) break;
			if (seats[dot] == '.') {
				if (seats[x] == 'x') {
					count += swap(seats, dot, x);
					dot++;
					x++;
				} else {
					x++;
				}
			} else {
				dot++;
				x=dot+1;
			}
		}
		return count;
	}

	private static int moveLeftSeats(char[] seats, int median) {
		int count = 0;
		int dot = median;
		int x = median;
		while (dot > -1) {
			if (dot <= -1) break;
			if (x <= -1) break;
			if (seats[dot] == '.') {
				if (seats[x] == 'x') {
					count += swap(seats, dot, x);
					dot--;
					x--;
				} else {
					x--;
				}
			} else {
				dot--;
				x=dot-1;
			}
		}
		return count;
	}

	private static int swap(char[] seats, int dot, int x) {
		seats[dot] = 'x';
		seats[x] = '.';
		return Math.abs(dot-x);
	}
	
	
	public static int median(List<Integer> positions) {
		int size = positions.size();
		if (size%2 == 1) {
			return positions.get(size/2);
		} else {
			return (positions.get((size-1)/2) + positions.get(size/2)) / 2;
		}
	}

	public static void main(String[] args) {
		String A = "....x..xx...x..";
		int movements = moveSeats(A);
		System.out.println("Number of movements: " + movements);

		String A1 = "....xxx";
		int movements1 = moveSeats(A1);
		System.out.println("Number of movements: " + movements1);


	}

}
