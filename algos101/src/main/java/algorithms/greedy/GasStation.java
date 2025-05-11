package algorithms.greedy;

/**
 * Gas Station (Complexity : Medium)
 * 
 * Problem: https://www.geeksforgeeks.org/find-a-tour-that-visits-all-stations/
 * 
 * Given two integer arrays A and B of size N. There are N gas stations along a circular route, where the amount of gas at station i is A[i].
 * You have a car with an unlimited gas tank and it costs B[i] of gas to travel from station i to its next station (i+1). 
 * You begin the journey with an empty tank at one of the gas stations.
 * 
 * Return the minimum starting gas station's index if you can travel around the circuit once, otherwise return -1.
 * 
 * You can only travel in one direction. i to i+1, i+2, ... n-1, 0, 1, 2.. Completing the circuit means starting at i and ending up at i again.


Problem Constraints
1 <= |A| <= 5 * 105
|A| == |B|
0 <= Ai <= 5 * 103
0 <= Bi <= 5 * 103


Input Format
The first argument given is the integer array A. The second argument given is the integer array B.


Output Format
Return the minimum starting gas station's index if you can travel around the circuit once, otherwise return -1.


Example Input
A = [1, 2]
B = [2, 1]


Example Output
1


Example Explanation
=====================
If you start from index 0, you can fill in A[0] = 1 amount of gas.
Now your tank has 1 unit of gas. But you need B[0] = 2 gas to travel to station 1.

If you start from index 1, you can fill in A[1] = 2 amount of gas.
Now your tank has 2 units of gas. You need B[1] = 1 gas to get to station 0.
So, you travel to station 0 and still have 1 unit of gas left over.
You fill in A[0] = 1 unit of additional gas, making your current gas = 2. It costs you B[0] = 2 to get to station 1, which you do and complete the circuit.

 * 
 * 
 */

public class GasStation {
	
	
    public static int canCompleteCircuit(final int[] gas, final int[] cost) {
		int totalStations = gas.length;
		int currentGas = 0;
		for (int startPtr=0; startPtr < totalStations; startPtr++) {
			int g = gas[startPtr];
			int c = cost[startPtr];
			if (currentGas + g - c >= 0) {
				currentGas = currentGas + g - c;
				int current = (startPtr + 1) % totalStations;
				boolean startingPointFound = true;
				while (current != startPtr) {
					if (currentGas + gas[current] - cost[current] < 0) {
						currentGas = 0;
						startingPointFound = false;
						break;
					}
					currentGas = currentGas + gas[current] - cost[current];
					current = (current + 1) % totalStations;
				}
				if (startingPointFound)
					return startPtr;

			} 
		}
		return -1;
    }

	public static void main(String[] args) {
		int[] gas = new int[] {4, 5, 7, 4};
		int[] cost = new int[] {6, 6, 3, 5};

		int startIndex = canCompleteCircuit(gas, cost);
		System.out.println("Start Index = " + startIndex);

		gas = new int[] {1, 2, 3, 4, 5};
        cost = new int[] {3, 4, 5, 1, 2};
		startIndex = canCompleteCircuit(gas, cost);
		System.out.println("Start Index = " + startIndex);

		gas = new int[] {2,3,4};
		cost = new int[] {3,4,3};
		startIndex = canCompleteCircuit(gas, cost);
		System.out.println("Start Index = " + startIndex);

	}

}
