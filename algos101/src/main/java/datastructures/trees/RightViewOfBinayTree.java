package datastructures.trees;

//Java program to print right view of binary tree

public class RightViewOfBinayTree {
	
	/*
	* Class containing left and right child of current node and key value
	*/
	class Node {
		int data;
		Node left, right;

		public Node(int item) {
			data = item;
			left = right = null;
		}
	}
	
	/* Class to print the right view */

	Node root;
	int max_level = 0;

	// recursive function to print right view
	void rightViewUtil(Node node, int level) {
		// Base Case
		if (node == null)
			return;

		// If this is the first node of its level, in this case it is right node.
		if (max_level < level) {
			System.out.print(" " + node.data);
			max_level = level;
		}

		// Recur for right and left subtrees
		rightViewUtil(node.right, level + 1);
		rightViewUtil(node.left, level + 1);
		
	}

	// A wrapper over rightViewUtil()
	void rightView() {
		rightViewUtil(root, 1);
	}
	
	/* testing for example nodes */
	public static void main(String args[]) {

		/* creating a binary tree and entering the nodes */
		RightViewOfBinayTree tree = new RightViewOfBinayTree();
		tree.root = tree.new Node(12);
		tree.root.left = tree.new Node(10);
		tree.root.right = tree.new Node(30);
		tree.root.left.right = tree.new Node(11);
		tree.root.right.left = tree.new Node(25);
		tree.root.right.right = tree.new Node(40);

		tree.rightView();
	}

}
