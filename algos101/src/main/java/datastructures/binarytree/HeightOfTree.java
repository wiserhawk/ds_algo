package datastructures.binarytree;

// Java program to get height of binary tree
public class HeightOfTree {
	
	class Node {
		int data;
		Node leftChild, rightChild;

		Node(int data) {
			this.data = data;
			this.leftChild = this.rightChild = null;
		}
	}
	
	private Node rootNode;
	private int maxLevel = 0;
	
	/*
	 * Compute the max height of a tree.
	 */
	private void getTreeHeight(Node node, int level) {
		if (node == null) return;
		
		if (maxLevel < level) {
			maxLevel ++;
		}
		getTreeHeight(node.leftChild, level+1);
		getTreeHeight(node.rightChild, level+1);
	}
	
	public int treeHeight(Node root) {
		if (root == null)
			return 0;
		getTreeHeight(root, 1);
		return maxLevel;
	}
	
	/*
	 * Other way to Compute the "maxDepth" of a tree -- the number of nodes along the longest
	 * path from the root node down to the farthest leaf node.
	 */
	int maxDepth(Node node) {
		if (node == null)
			return 0;
		
		/* compute the depth of each subtree */
		int lDepth = maxDepth(node.leftChild);
		int rDepth = maxDepth(node.rightChild);

		/* use the larger one */
		if (lDepth > rDepth)
			return (lDepth + 1);
		else
			return (rDepth + 1);
	}
	
	
	
	public static void main(String[] args) {
		HeightOfTree tree = new HeightOfTree();
		tree.rootNode = tree.new Node(1);
		tree.rootNode.leftChild = tree.new Node(2);
		tree.rootNode.rightChild = tree.new Node(3);
		tree.rootNode.leftChild.leftChild = tree.new Node(7);
		tree.rootNode.leftChild.rightChild = tree.new Node(6);
		tree.rootNode.rightChild.leftChild = tree.new Node(5);
		tree.rootNode.rightChild.rightChild = tree.new Node(4);
		tree.rootNode.rightChild.rightChild.rightChild = tree.new Node(8);

		int height = tree.treeHeight(tree.rootNode);
		int depth = tree.maxDepth(tree.rootNode);
		System.out.println("Height Of Tree Is = " + height);
		System.out.println("Depth Of Tree Is = " + height);
	}

}
