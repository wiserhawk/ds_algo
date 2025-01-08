package algorithms.dynamicprogramming;

import java.util.Arrays;

/**
 * Problem Statement:
 * Given a number of stairs and a frog, the frog wants to climb from the 0th stair to the (N-1)th stair. 
 * At a time the frog can climb either one or two steps. A height[N] array is also given. Whenever the frog jumps 
 * from a stair i to stair j, the energy consumed in the jump is abs(height[i]- height[j]), where abs() means the absolute difference. 
 * We need to return the minimum energy that can be used by the frog to jump from stair 0 to stair N-1.
 */

public class FrogJump {


    // Without DP
    public static int minEnergyUsed(int[] stairs, int n) {
        if (n == 0) 
            return 0;

        int oneStepEnergy = minEnergyUsed(stairs, n-1) + Math.abs(stairs[n] - stairs[n-1]);
        int twoStepEnergy = Integer.MAX_VALUE;
        if (n>1)
            twoStepEnergy = minEnergyUsed(stairs, n-2) + Math.abs(stairs[n] - stairs[n-2]);
        return Math.min(oneStepEnergy, twoStepEnergy);
    }

    // With DP Memoization 
    public static int minEnergyUsed(int[] stairs, int n, int[] memo) {
        if (n == 0) 
            return 0;

        if (memo[n] != -1) return memo[n];
        int oneStepEnergy = minEnergyUsed(stairs, n-1, memo) + Math.abs(stairs[n] - stairs[n-1]);
        int twoStepEnergy = Integer.MAX_VALUE;
        if (n>1)
            twoStepEnergy = minEnergyUsed(stairs, n-2, memo) + Math.abs(stairs[n] - stairs[n-2]);
        memo[n] = Math.min(oneStepEnergy, twoStepEnergy);
        return memo[n];
    }

    // With DP Tabulation 
    public static int minEnergyUsed(int[] stairs, int n) {
        int energy = Integer.MAX_VALUE;
        int next = 0, next_next = 0;
        for (int i = 0; i <= n-1; i++ ) {
            int oneStep = Math.abs(stairs[i] - stairs[i+1]);
            int twoStep = Math.abs(stairs[i] - stairs[i+2]);
            int energy = Math.min( );
        }
    }

    public static void main(String[] args) {
        int[] stairs = new int[] {10, 20,30,10};
        int energy = minEnergyUsed(stairs, stairs.length-1);
        System.out.println("Minmum Energy Required = " + energy);

        int[] memo = new int[stairs.length];
        Arrays.fill(memo, -1);
        energy = minEnergyUsed(stairs, stairs.length-1, memo);
        System.out.println("Minmum Energy Required With DP = " + energy);
    }

}
