package datastructures.binarytree;

import java.util.LinkedList;
import java.util.Queue;

// Get Lowest Common Ancestor for given two numbers in Tree.
public class LCATree {
	
	static class Node {
		int data;
		Node left, right;
		
		public Node(int data) {
			this.data = data;
			left = right = null;
		}
	}
	
	Node root;
	
	private Node nextNode(Node node, int num ) {
		if (node == null)
			return node;
		
		if (num < node.data) 
			return node.left;
		if (num > node.data)
			return node.right;
		
		return node;
	}
	
	// Returns LCA number from tree for given two numbers.
	// Using Iteration
	// OPTIMIZED SOLUTION
	public int getLcaUsingIteration(int first, int second) {
		if (root == null)
			return 0;
		Node fstNode, secNode;
		fstNode = secNode = root;
		Node lcaNode = root;
		while (fstNode.data == secNode.data) {
			lcaNode = fstNode;
			fstNode = nextNode(fstNode, first);
			secNode = nextNode(secNode, second);
		}
		return lcaNode.data;
		
	}
	
	
	// Returns LCA number from tree for given two numbers.
	// Using Queues
	public int getLcaUsingQueue(int first, int second) {
		if (root == null)
			return 0;
		
		Queue<Node> leftQueue = new LinkedList<>();
		Queue<Node> rightQueue = new LinkedList<>();
		Node leftNode, rightNode;
		leftNode = rightNode = root;
		while (true) {
			leftNode = nextNode(leftNode, first);
			rightNode = nextNode(rightNode, second);
			leftQueue.add(leftNode);
			rightQueue.add(rightNode);
			// Terminate loop if left or right node are null or 
			// same node which are given to find LCA.
			if (leftNode == null || rightNode == null || 
					leftNode.data == first || rightNode.data == second) {
				break;
			}
		}
		
		Node lcaNode = root;
		leftNode = rightNode = null;
		while (true) {
			leftNode = leftQueue.poll();
			rightNode = rightQueue.poll();
			if ( leftNode == null || rightNode == null ) {
				break;
			}
			if ( leftNode == rightNode ) {
				lcaNode = leftNode;
				continue;
			}
			
		}
		
		return (lcaNode != null) ? lcaNode.data : 0;
	}
	
	public static void main(String[] args) {
		LCATree tree = new LCATree();
		
		tree.root = new Node(7);
		tree.root.left = new Node(4);
		tree.root.right = new Node(14);
		tree.root.left.left = new Node(2);
		tree.root.left.right = new Node(6);
		tree.root.right.left = new Node(11);
		
		// Get LCA using iteration; OPTIMIZED SOLUTION
		int lca = tree.getLcaUsingIteration(2, 6);
		System.out.println("Lowest Common Ancester Using Iteration = " + lca);
		
		// Get LCA using Queue;
		lca = tree.getLcaUsingQueue(2, 6);
		System.out.println("Lowest Common Ancester Using Queue = " + lca);
		
	}
	
	

}
