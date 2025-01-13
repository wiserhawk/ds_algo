package datastructures.binarytrees.traversal;

//Java program to print left view of binary tree

public class LeftViewOfBinayTree {
	
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

	
	Node root;
	int max_level = 0;

	// recursive function to print left view
	void leftViewUtil(Node node, int level) {
		// Base Case
		if (node == null)
			return;

		// If this is the first node of its level, in this case it is left node.
		if (max_level < level) {
			System.out.print(" " + node.data);
			max_level = level;
		}

		// Recur for left and right subtrees
		leftViewUtil(node.left, level + 1);
		leftViewUtil(node.right, level + 1);
	}

	// A wrapper over leftViewUtil()
	void leftView() {
		leftViewUtil(root, 1);
	}

	/* testing for example nodes */
	public static void main(String args[]) {

		/* creating a binary tree and entering the nodes */
		LeftViewOfBinayTree tree = new LeftViewOfBinayTree();
		tree.root = tree.new Node(12);
		tree.root.left = tree.new Node(10);
		tree.root.right = tree.new Node(30);
		tree.root.right.left = tree.new Node(25);
		tree.root.right.right = tree.new Node(40);

		tree.leftView();
	}

}
