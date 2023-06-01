package algorithms.string;

import java.util.HashSet;
import java.util.Set;

/**
You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have. 
Each character in stones is a type of stone you have. You want to know how many of the stones you have are also jewels.
Letters are case sensitive, so "a" is considered a different type of stone from "A".
 
============================================================
Example 1:

Input: jewels = "aA", stones = "aAAbbbb"
Output: 3

=============================================================
Example 2:

Input: jewels = "z", stones = "ZZ"
Output: 0


 * 
 */

public class JewelsAndStones {
	
	public static int numJewelsInStones(String jewels, String stones) {
        int result = 0;
        Set<Character> jewelsSet = new HashSet<>(); 
        for (int i = 0; i < jewels.length(); i++) {
            jewelsSet.add(jewels.charAt(i));
        }
        
        for (int i = 0; i < stones.length(); i++) {
            if (jewelsSet.contains(stones.charAt(i)))
                result++;
        }
        return result;
    }
	
	public static void main(String[] args) {
		
		String jewels = "aA";
		String stones = "aAAbbbb";
		
		int result = numJewelsInStones(jewels, stones);
		System.out.println(result);
		
	}

}
