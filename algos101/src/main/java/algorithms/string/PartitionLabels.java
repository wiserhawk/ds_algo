package algorithms.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.

Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.

Return a list of integers representing the size of these parts.
 

Example 1:
===================================
Input: s = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.


Example 2:
===================================
Input: s = "eccbbbbdec"
Output: [10]
 

Constraints:

1 <= s.length <= 500
s consists of lowercase English letters.
 
 */
public class PartitionLabels {

	public static List<Integer> partitionLabels(String s) {
		List<Integer> result = new ArrayList<>();
		Map<Character, Integer> charEndIndexMap = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			charEndIndexMap.put(s.charAt(i), i);
		}

		int index = 0, end = 0;
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			end = Math.max(end, charEndIndexMap.get(c));
			if (i == end) {
				result.add(i - index + 1);
				index = i + 1;
			}
		}
		return result;
	}
	
	public static void printList(List<Integer> list) {
		for(Integer i : list) {
			System.out.print(i+",");
		}
	}
	
	public static void main(String[] args) {
		
		String s = "ababcbacadefegdehijhklij";
		List<Integer> result = partitionLabels(s);
		printList(result);
		
		System.out.println("\n======================");
		
		s = "eccbbbbdec";
		result = partitionLabels(s);
		printList(result);
		
		
	}

}
