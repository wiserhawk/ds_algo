package datastructures.binarytrees.traversal;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
	
	public Node rightChild(Node node) {
		if (node == null) return node;
		return node.right;
	}
	
	public Node leftChild(Node node) {
		if (node == null) return node;
		return node.left;
	}
	
	public List<Integer> diagonalSum(Node root) {
		
		if (root == null) return null;
		List<Integer> diagonalSum = new ArrayList<Integer>();
		
		Queue<Node> currentQueue = new LinkedList<Node>();
		currentQueue.add(root);
		
		Queue<Node> nextQueue = new LinkedList<Node>();
		
		Queue<Node> diagonalNodes = new LinkedList<Node>();
		while (!currentQueue.isEmpty()) {
			
			while(!currentQueue.isEmpty() ) { 
				Node currentNode = currentQueue.poll();
				diagonalNodes.add(currentNode);
				Node rightNode = rightChild(currentNode);
				Node leftNode = leftChild(currentNode);
				if (rightNode != null) 
					currentQueue.add(rightNode);
					
				if (leftNode != null)
					nextQueue.add(leftNode);
			}
			
			diagonalSum.add(calcSum(diagonalNodes));
			Queue<Node> temp = currentQueue;
			currentQueue = nextQueue;
			nextQueue = temp;
			nextQueue.clear();
		}
		
		return diagonalSum;
	}
	
	private int calcSum(Queue<Node> queue) {
		int sum = 0;
		while(!queue.isEmpty()) {
			sum += queue.poll().data;
		}
		return sum;
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
        
        List<Integer> diagonalSum = tree.diagonalSum(tree.root);
        System.out.println("Diagonal Sum = " + diagonalSum);

	}

}
