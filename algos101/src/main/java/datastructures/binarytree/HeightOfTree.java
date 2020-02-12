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
	
	
	
	public static void main(String[] args) {
		HeightOfTree tree = new HeightOfTree();
		tree.rootNode = tree.new Node(1);
		tree.rootNode.leftChild = tree.new Node(2);
		tree.rootNode.rightChild = tree.new Node(3);
		tree.rootNode.leftChild.leftChild = tree.new Node(7);
		tree.rootNode.leftChild.rightChild = tree.new Node(6);
		tree.rootNode.rightChild.leftChild = tree.new Node(5);
		tree.rootNode.rightChild.rightChild = tree.new Node(4);
		tree.rootNode.rightChild.rightChild.leftChild = tree.new Node(8);

		int height = tree.treeHeight(tree.rootNode);
		System.out.println("Height Of Tree Is = " + height);
	}

}
