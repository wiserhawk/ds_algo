package algorithms.maths;

public class ReverseTheNumber {

	public static void main(String[] args) {
		
		System.out.println("Reverse Numner = " + reverseIt(123456789));

	}
	
	public static int reverseIt(int n) {
		int reverse = 0;
		int x = n;
		while(x != 0) {
			int m = x%10;
			x = x/10;
			reverse = reverse * 10 + m;
		}
		return reverse;
	}

}
