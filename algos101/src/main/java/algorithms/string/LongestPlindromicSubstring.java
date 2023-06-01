package algorithms.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 	Given a string s, find the longest palindromic substring in s. You may assume
 *	that the maximum length of s is 1000.
 *	Example 1:
 *	Input: "babad"
 *	Output: "bab"
 *	Note: "aba" is also a valid answer.
 *	Example 2:
 *	Input: "cbbd"
 *	Output: "bb"
 *
 */
public class LongestPlindromicSubstring {
	
	
	// Brute Force 
	public static String getLongestPlindromicSubstring(String str) {
		Map<Integer, String> substringMap = new HashMap<>(); 
		int max = 0;
		int length = str.length();
		for(int i=0; i < length-1; i++) {
			for (int j=i+1; j < length; j++) {
				String subStr = str.substring(i, j+1);
				if (isPlindromicString(subStr)) {
					substringMap.put(subStr.length(), subStr);
					max = Math.max(max, subStr.length());
				}
			}
		}
		
		printMap(substringMap);
		return substringMap.get(max);
	}
	
	private static boolean isPlindromicString(String str) {
		int length = str.length();
		int start = 0;
		int end = length -1;
		while(start < end) {
			if (str.charAt(start) != str.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
	
	private static void printMap(Map<Integer, String> map) {
		System.out.println("====== MAP VALUES ======");
		for (Integer key : map.keySet()) {
			System.out.println(map.get(key));
		}
		System.out.println("========================");
	}
	
	public static void main(String[] args) {
		
		String str = "xatmtaxleemsmeel";
		String output = getLongestPlindromicSubstring(str);
		
		System.out.println("Longest Substring = " + output);
		
	}

}
