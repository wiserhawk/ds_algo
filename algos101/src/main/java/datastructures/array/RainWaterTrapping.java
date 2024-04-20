package datastructures.array;

/**
 * Problem Statement: Given an array of non-negative integers representation elevation of ground. Your task is to find the water that can be trapped after rain.

    Examples:
    https://takeuforward.org/data-structure/trapping-rainwater/

    Example 1:

    Input: height= [0,1,0,2,1,0,1,3,2,1,2,1]

    Output: 6

    Explanation: As seen from the diagram 1+1+2+1+1=6 unit of water can be trapped

    Example 2:

    Input:  [4,2,0,3,2,5]

    Output:9
 */

public class RainWaterTrapping {

    // Approach: For each index, we have to find the amount of water that can be stored and we have to sum it up.
    // If we observe carefully the amount the water stored at a particular index is the minimum of maximum elevation to the left and right of the index minus the elevation at that index.
    //  Water trapped on index = Min (LeftMax, RightMax) - array[index]

    // Time Complexity = O(N^2)
    public static int bruteForce_trapWater(int[] arr) {
        int length = arr.length;
        int units = 0;
        
        for (int i = 0; i < length; i++) {
            int leftMax = 0, rightMax = 0;
            // left Max 
            int left = i;
            while (left > -1) {
                if (leftMax < arr[left])
                    leftMax = arr[left];
                left--;
            }

            int right = i;
            while (right < length) {
                if (rightMax < arr[right])
                    rightMax = arr[right];
                right++;    
            }
            units += Math.min(leftMax, rightMax) - arr[i];
        }
        return units;
    }

    // Time Complexity = O(3N) = O(N)
    // Space Compexity = O(2N)
    public static int betterApproach_trapWater(int[] arr) {
        int length = arr.length;
        int units = 0;

        int leftMax = 0;
        int[] prefixMax = new int[length];
        prefixMax[0] = arr[0];
        for (int i = 1; i < length; i++) {
            prefixMax[i] = Math.max(prefixMax[i-1], arr[i]);
        }

        int rightMax = 0;
        int[] sufixMax = new int[length];
        sufixMax[length-1] = arr[length-1];
        for (int i = length-2; i >= 0; i--) {
            sufixMax[i] = Math.max(sufixMax[i+1], arr[i]);
        }
        
        for (int i = 0; i < length; i++) {
            leftMax = prefixMax[i];
            rightMax = sufixMax[i];
            units += Math.min(leftMax, rightMax) - arr[i];
        }
        return units;
    }

    // Two Pointers Technique
    // Time Complexity = O(N)
    public static int twoPointers_trapWater(int[] arr) {
        int result = 0;
        int len = arr.length;
        int l = 0, r = len-1;
        int leftMax = 0, rightMax = 0;
        while (l < r) {  
            if (arr[l] <= arr[r]) {
                if (arr[l] > leftMax) {
                    leftMax = arr[l];
                }
                else {
                    result += leftMax - arr[l];
                }
                l++;
            } else {
                if (arr[r] > rightMax) {
                    rightMax = arr[r];
                } else {
                    result += rightMax - arr[r];
                }
                r--;
            }
        }
        return result;
    }
    

    public static void main(String[] args) {
        int[] elevation = new int[]{1,1,0,2,1,0,1,3,2,1,2,1};
        int units = bruteForce_trapWater(elevation);
        System.out.println("(Brute Force) Water Units Trapped = " + units);

        units = betterApproach_trapWater(elevation);
        System.out.println("(Better Approach) Water Units Trapped = " + units);

        units = twoPointers_trapWater(elevation);
        System.out.println("(Optimal Approach) Water Units Trapped = " + units);
    }



}
