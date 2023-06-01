package datastructures.array;

/**
 * 
 * A leader in an array is an element which is greater than all the elements on
 * its right side in the array.
 * 
 * Leaders by default: Two types of elements are leaders by default.
 * 
 * 1. Last element of an array is a leader by default because there is no element
 * on the right side of it and so its right element is NULL. 
 * 2. Greatest element of an array is also a leader by default. 
 * 
 * For example, take an array
 * {2,5,8,7,3,6}. Here 6,7,8 are leaders. Let's take a look at them one by one.
 *
 * 
 */

public class LeadersInArray {

	public static int[] findLeaders(int[] values) {
		int[] leaders = new int[values.length]; 
		int count = 0;
		boolean last = true;
		int max = 0;
		for (int i = values.length-1; i >= 0 ; i--) {
			if (last) {
				leaders[count++] = values[i];
				max = values[i];
				last = false;
			}
			else {
				if (values[i] > max) {
					leaders[count++] = values[i];
					max = values[i];
				}
			}
		}
		
		return leaders;
	}
	
	public static void printArrayValues(int[] values) {
		for (int i = 0; i < values.length; i++) {
			System.out.println(values[i]);
		}
	}
	
	public static void main(String[] args) {
		int[] values = new int[]{2,5,8,7,3,6};
		int[] leaders = findLeaders(values);
		System.out.println("All Leaders Are:");
		printArrayValues(leaders);

	}

}
