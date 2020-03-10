package algorithms.expression;

import java.util.Stack;

public class ExpressionScore {
	
	/**
	 * Problem : Find score of given balanced expression based of below rules.
	 * 
	 * 1. () has score 1.
	 * 2. ()() or AB has score of A+B, where A and B are balanced parentheses string.
	 * 3. (()) or (A) has score 2*A, where A is a balanced parentheses string
	 * 
	 * Input: (()(()))
	 * Output: 6
	 * 
	 * Input: (()())(()())
	 * Output: 8
	 * 
	 * HINT : Using Recursion & Stack
	 * 
	 * Solution Link: https://www.youtube.com/watch?v=TUl1AsOfKP4
	 * 
	 * Tags: Google, Facebook, Microsoft, Amazon
	 * 
	 */
	
	public static int evalScore(String expression) {
		
		if (expression == null) 
			return 0;
		
		char[] charArr = expression.toCharArray();
		int size = charArr.length;
		
		Stack<Integer> stack = new Stack<Integer>();
		
		int[] indices = new int[size];
		
		int idx = 0;
		for (char c : charArr) {
			if (c == '(') {
				stack.add(idx);
			}
			else { // when c == ')'
				int openIdx = stack.pop();
				// Keep track of all closed indices for each open indices.
				indices[openIdx] = idx;
			}
			
			idx++;
		}
		
		return eval(0, size-1, indices);
	}
	
	/**
	 * This is a recursive function will take start and end indices from expression to evaluate its score. 
	 */
	private static int eval(int start, int end, int[] indices) {	
		if (start+1 == end) return 1;
		
		int mid = indices[start];
		
		if (mid == end) 
			return 2 * eval(start+1, end-1, indices);
		
		return eval(start, mid, indices) + eval(mid+1, end, indices); 
	}

	public static void main(String[] args) {
		String input1 = "(()(()))";
		String input2 = "(()())(()())";
		
		int score = evalScore(input1);
		System.out.println("Score for Input 1 = " + score);
		
		score = evalScore(input2);
		System.out.println("Score for Input 2 = " + score);

	}

}
