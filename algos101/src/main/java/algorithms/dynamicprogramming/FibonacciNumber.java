package algorithms.dynamicprogramming;

import java.util.Arrays;

/**
 * 
 * Return fibonacci number for a given number: fibonacci number is a sum of last two numbers. 
 * 
 * The following series is called the Fibonacci series: 0,1,1,2,3,5,8,13,21,...
 * 
 * For example : Fibonacci of (7) => sum of (5+8) = 13
 
 */

public class FibonacciNumber {

    /**** Recursion approach without DP ****/
    // TC = O(2^N) Worst 
    // SC = O(N) Stack Space to execute Recursion
    public static int fibonacci(int n) {
        if (n <= 1)
            return n;
        else 
            return fibonacci(n-1) + fibonacci(n-2);
    }

    /**** Better Approach: Recursion appraoch with DP (Memoization: top-bottom approach) */
    // TC = O(N)
    // SC = O(2N): N due to memo array + N due to recursion stack space
    public static int memo_fibonacci(int n) {
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        return memo_fibonacci(n, memo);
    }

    private static int memo_fibonacci(int n, int[] memo) {
        if (n <= 1) 
            return n;
        if (memo[n] != -1)
            return memo[n];
        memo[n] = memo_fibonacci(n-1, memo) + memo_fibonacci(n-2, memo);
        return memo[n];
    }

    /**** Optimal Approach: Recursion appraoch with DP (Tabulation: bottom-up approach) */
    // TC = O(N)
    // SC = 2 Constant due to prev and prev_prev variable.
    public static int tabulation_fibonacci(int n) {
        int prev = 1, prev_prev = 0;
        for (int i = 2; i <= n; i++) {
            int current = prev + prev_prev;
            prev_prev = prev;
            prev = current;
        }
        return prev;
        
    }

    public static void main(String[] args) {
        int n = 7;

        int f = fibonacci(n);
        System.out.println("Recursion Fibonacci of " + n + " = " + f);

        f = memo_fibonacci(n);
        System.out.println("Memoization Fibonacci of " + n + " = " + f);

        f = tabulation_fibonacci(n);
        System.out.println("Tabulation Fibonacci of " + n + " = " + f);
    }

}
