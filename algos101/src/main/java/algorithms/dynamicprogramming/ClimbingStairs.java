package algorithms.dynamicprogramming;

/**
 * https://takeuforward.org/data-structure/dynamic-programming-climbing-stairs/
 * 
 * Problem Statement: Given a number of stairs. Starting from the 0th stair we need to climb to the “Nth” stair. 
 * At a time we can climb either one or two steps. We need to return the total number of distinct ways to reach from 0th to Nth stair.
 * 
 */


public class ClimbingStairs {

    // Using Tabulation DP
    // TC = O(N)
    // SC = O(1)
    public static int distinctWaysToClimbStairs(int n) {
        int prev = 1, prev_prev = 1;
        for (int i = 2; i <= n ; i++) {
            int current = prev + prev_prev;
            prev_prev = prev;
            prev = current;
        }
        return prev;
    }


    public static void main(String[] args) {
        int n = 4;
        int w = distinctWaysToClimbStairs(n);
        System.out.println("Distinct Ways for " + n + " stairs are = " + w);
    
    }

}
