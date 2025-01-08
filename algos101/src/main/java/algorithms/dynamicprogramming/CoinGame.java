package algorithms.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * https://www.geeksforgeeks.org/optimal-strategy-for-a-game-dp-31/
 * 
 */

public class CoinGame {

    public static int winnerScore(int[] arr) {  
        Map<String, Integer> memo = new HashMap<>();
        int left = pickCoin(arr, 0, arr.length-1, 0, memo);
        int right = pickCoin(arr, 0, arr.length-1, arr.length-1, memo);

        System.out.println("Left = " + left + ", Right = " + right);
        return Math.max(left, right);
    }

    private static int pickCoin(int[] arr, int start, int end, int index, Map<String, Integer> memo) {
        String key = createKey(start, end, index);
        if (memo.get(key) != null) {
            System.out.println("Memoized value = " + memo.get(key));
            return memo.get(key);
        }

        // I have picked my coin here.
        int score = arr[index];
        
        // Shrink array start and end indices
        if (index == start)
            start++;
        else if (index == end)
            end--;
        
        // Opponent will pick max coin available.
        int maxIndex = arr[start] > arr[end] ? start : end;
        
        // Shrink array start and end indices
        if (maxIndex == start)
            start++;
        else if (maxIndex == end)
            end--;
        
        // calculate my max score so far.
        int maxScore = 0;
        if (start < end)
        {
            maxScore = Math.max(pickCoin(arr, start, end, start, memo), pickCoin(arr, start, end, end, memo)) ;
        }
        memo.put(key, score + maxScore);
        // return my total max score so far.
        return score + maxScore;
    }

    private static String createKey(int start, int end, int index) {
        return start + "-" + end + "-" + index;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {5, 3, 7, 10};
        System.out.println("Game-1 Winner Score = " + winnerScore(arr));

        arr = new int[] { 8, 15, 3, 7 };
        System.out.println("Game-2 Winner Score = " + winnerScore(arr));

        arr = new int[] { 20, 30, 2, 2, 2, 10 };
        System.out.println("Game-3 Winner Score = " + winnerScore(arr));

        arr = new int[] { 8, 10, 20, 7, 15, 15, 5, 10, 9, 18 };
        System.out.println("Game-4 Winner Score = " + winnerScore(arr));
 
    }


}
