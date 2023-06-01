package datastructures.array;

/**
 * There is a corridor in a Jail which is N units long. Given an array A of size N. The ith index of this array is 0 if the light at ith position is faulty otherwise it is 1.

All the lights are of specific power B which if is placed at position X, it can light the corridor from [ X-B+1, X+B-1].

Initially all lights are off.

Return the minimum number of lights to be turned ON to light the whole corridor or -1 if the whole corridor cannot be lighted.
 
Example:

Input 1:
==========
A = [ 0, 0, 1, 1, 1, 0, 0, 1].
B = 3
Output 1= 2

Input 2:
==========
A = [ 0, 0, 0, 1, 0].
B = 3
Output 2: -1
 
 *
 */

public class MinimumLightsToActivate {

	public static void main(String[] args) {
		//int[] lights = new int[] {0,0,1,1,0,0,1,0,0,1,0,0,1};
		int[] lights = new int[] {1,1,1,1};
		int b = 3;
		
		int result = solveWithGreedyApproach(lights, b);
		System.out.println("Result = " + result);

	}
	
	public static int solveWithGreedyApproach(int[] lights, int b) {
		int count = 0;
		int lightUpto = 0;
		
		int left = 0, right = 0;
		
		for (int i = 0; i < lights.length;) {
			left = leftRange(i, b) >= 0 ? leftRange(i, b) : 0;
			right = rigthtRange(i, b) < lights.length ? rigthtRange(i, b) : lights.length-1; 
			int lightOn = lightOn(lights, left, right);
			if (lightOn == -1) 
				return -1;
			lightUpto = rigthtRange(lightOn, b);
			i = lightUpto+1;
			count++;
		}
		return count;
	}
	
	private static int leftRange(int i, int b) {
		return i-b+1;
	}
	
	private static int rigthtRange(int i, int b) {
		return i+b-1;
	}
	
	// Select right most non-faulty light
	private static int lightOn(int[] lights, int start, int end) {
		for (int i = end; i > start; i--) {
			if (lights[i] == 1)
				return i;
		}
		return -1;
	}

}
