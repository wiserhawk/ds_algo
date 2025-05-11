package datastructures.binarytrees.traversal;

import java.util.LinkedList;
import java.util.Queue;

// Java program to get height of binary tree
public class HeightOfTree {
	
	public static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}
	
	private static  Node rootNode;
	private static int maxLevel = 0;
	
	/*
	 * Compute the max height of a tree.
	 */
	private static void getTreeHeight(Node node, int level) {
		if (node == null) return;
		
		if (maxLevel < level) {
			maxLevel ++;
		}
		getTreeHeight(node.left, level+1);
		getTreeHeight(node.right, level+1);
	}
	
	public static int treeHeight(Node root) {
		if (root == null)
			return 0;
		getTreeHeight(root, 1);
		return maxLevel;
	}
	
	/*
	 * Other way to Compute the "maxDepth" of a tree -- the number of nodes along the longest
	 * path from the root node down to the farthest leaf node.
	 */
	public static int maxDepth(Node node) {
		if (node == null)
			return 0;
		
		/* compute the depth of each subtree */
		int lDepth = maxDepth(node.left);
		int rDepth = maxDepth(node.right);

		/* use the larger one */
		if (lDepth > rDepth)
			return (lDepth + 1);
		else
			return (rDepth + 1);
	}

	public static int maxheightUsingQueue(Node root) {
		if (root == null) {
			return 0;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		int height = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i=0; i< size; i++) {
				Node node = queue.poll();
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
			height++;
		}
		return height;

	}
	
	
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);        
		root.right.right = new Node(7);
		
		System.out.println("Height = " + treeHeight(root));
		System.out.println("Height = " + maxDepth(root));
		System.out.println("Height = " + maxheightUsingQueue(root));
	

	}

}
