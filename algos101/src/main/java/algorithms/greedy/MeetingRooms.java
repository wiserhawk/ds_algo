package algorithms.greedy;

import java.util.Arrays;
import java.util.List;

/**
Meeting Rooms (Complexity: Medium) 
Given an array of meeting time intervals consisting of start and end times[[s1,e1],[s2,e2],...]
(si < ei), find the minimum number of conference rooms required.

Example 1:
===========
Input:
[[0, 30],[5, 10],[15, 20]]
Output: 2

Example 2:
===========
Input:
[[7,10],[2,4]]
Output: 1
 
HINT : All start time consider as +1 room and end time as -1 room. In the end their would be minimum room required.
 */

public class MeetingRooms {
	
	
	public static int meetingRoomsRequired(int[][] meetings) {
		// If input is like [[0, 30],[5, 10],[15, 20]]
		
		int[][] meetingRooms = new int[meetings.length * 2][2];
		for (int i=0; i<meetings.length; i++) {
			meetingRooms[i*2] = new int[] {meetings[i][0], 1};
			meetingRooms[i*2 + 1] = new int[] {meetings[i][1], -1};
		}
		
		Arrays.sort(meetingRooms, (m1, m2) -> m1[0] - m2[0]);
		// meetingRooms after sort would be : [[0, 1], [5, 1], [10, -1], [15, 1], [20, -1], [30, -1]]

		int maxRooms = 0;
		int current = 0;
		for (int i=0; i<meetingRooms.length; i++) {
			current = current + meetingRooms[i][1];
			maxRooms = Math.max(maxRooms, current);
		}
		return maxRooms;
		
	}
	
	
	

	public static void main(String[] args) {
		int[][] meetings = new int[][] {{0,30},{5,10},{15,20}};
		int res = meetingRoomsRequired(meetings);
		System.out.println("1. Max Room Required = " + res);
		
		int[][] meetings1 = new int[][] {{7,10},{2,4}};
		int res1 = meetingRoomsRequired(meetings1);
		System.out.println("2. Max Room Required = " + res1);
		

	}

}
