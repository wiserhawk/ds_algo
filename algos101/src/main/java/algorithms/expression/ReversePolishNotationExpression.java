package algorithms.expression;

import java.util.Stack;

/**
 * The problem:
Evaluate the value of an arithmetic expression in Reverse Polish Notation. 
Valid operators are + , -, * , /. Each operand may be an integer or another expression.
Some examples:
[ " 2 " , " 1 " , "+ " , " 3 " , " * " ] -> ( ( 2 + 1) * 3) -> 9
[ " 4 " , " 13 " , " 5 " , "/ " , "+ " ] -> (4 + (1 3 / 5) ) -> 6
 * 
 * 
 *
 */
public class ReversePolishNotationExpression {
	
	public static int evaluate(String[] tokens) {
	
		String operators = "+-*/";
		Stack<String> stack = new Stack<>();
		
		for (String token : tokens) {
			
			if (!operators.contains(token)) {
				stack.push(token);
			}
			else {
				int first = Integer.parseInt(stack.pop());
				int second = Integer.parseInt(stack.pop());
				switch (token) {
				case "+": {
					stack.push(String.valueOf(first + second));		
					break;
				}
				case "-": {
					stack.push(String.valueOf(second - first));		
					break;
				}
				case "*": {
					stack.push(String.valueOf(first * second));		
					break;
				}
				case "/": {
					stack.push(String.valueOf(second / first));		
					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + token);
				}
			}
		}
		
		return Integer.parseInt(stack.pop());
		
	}
	
	public static void main(String[] args) {
		String[] token1 = new String[] {"2" , "1" , "+" , "3" , "*" }; 
		String[] token2 = new String[] {"4" , "13" , "5" , "/" , "+" };
		int output1 = evaluate(token1);
		System.out.println("Evaluated Value1 = " + output1);
		
		int output2 = evaluate(token2);
		System.out.println("Evaluated Value2 = " + output2);
		
	}

}
