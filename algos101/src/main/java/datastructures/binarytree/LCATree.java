package datastructures.binarytree;

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
	public int getLCA(int first, int second) {
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
	
	public static void main(String[] args) {
		LCATree tree = new LCATree();
		
		tree.root = new Node(7);
		tree.root.left = new Node(4);
		tree.root.right = new Node(14);
		tree.root.left.left = new Node(2);
		tree.root.left.right = new Node(6);
		tree.root.right.left = new Node(11);
		
		int lca = tree.getLCA(6, 2);
		System.out.println("Lowest Common Ancester = " + lca);
		
	}
	
	

}
