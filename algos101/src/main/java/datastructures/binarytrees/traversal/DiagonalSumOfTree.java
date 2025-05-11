package datastructures.binarytrees.traversal;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


// https://www.geeksforgeeks.org/diagonal-sum-binary-tree/

public class DiagonalSumOfTree {

	public static class Node {
		int data;
		Node left, right;
		
		public Node(int data) {
			this.data = data;
			left = right = null;
		}
	}
	
	Node root;


	public static List<Integer> diagonalSum(Node root) {
		List<Integer> diagonalSum = new ArrayList<>();

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		List<Node> nextDiagonal = new ArrayList<>();
		int sum = 0;
		
		while (!queue.isEmpty()) {
			Node curr = queue.poll();
			sum += curr.data;

			if (curr.right != null)
				queue.add(curr.right);

			if (curr.left != null) {
				nextDiagonal.add(curr.left);
			}

			if (queue.isEmpty()) {
				diagonalSum.add(sum);
				sum = 0;
				queue.addAll(nextDiagonal);
				nextDiagonal.clear();
			}
		}
		return diagonalSum;
	}
	
	
	
	public static void main(String[] args) {
		DiagonalSumOfTree tree = new DiagonalSumOfTree(); 
        tree.root = new Node(1);
		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 
		tree.root.left.left = new Node(9); 
		tree.root.left.right = new Node(6); 
		tree.root.right.left = new Node(4); 
		tree.root.right.right = new Node(5); 
		tree.root.right.left.left = new Node(12); 
		tree.root.right.left.right = new Node(7); 
		tree.root.left.right.left = new Node(11); 
		tree.root.left.left.right = new Node(10); 

		System.out.println("Diagonal Sum = " + diagonalSum(tree.root));

	}

}
