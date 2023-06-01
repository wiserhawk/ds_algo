package datastructures.trees;


/**
 * 	Symmetric Tree (Mirror Image of itself)
	Given a binary tree, check whether it is a mirror of itself.

	For example, this binary tree is symmetric:

	     1
	   /   \
	  2     2
	 / \   / \
	3   4 4   3
 *
 */
public class SymmetricTree {
	
	static class Node {
		int data;
		Node left, right;
		
		public Node(int data) {
			this.data = data;
			left = right = null;
		}
	}
	
	Node root;
	
	// Check recursively whether given node are mirror image of each other.
	private boolean isMirror(Node node1, Node node2) {
		if (node1 == null && node2 == null)
			return true;
		
		if (node1 != null && node2 != null && node1.data == node2.data)
			return isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
		
		return false;
	}
	
	// Check whether tree is symmetric (mirror image of itself)
	public boolean isSymmetric() {
		return isMirror(root, root);
	}
	
	

	public static void main(String[] args) {
		SymmetricTree tree = new SymmetricTree(); 
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(2); 
        tree.root.left.left = new Node(3); 
        tree.root.left.right = new Node(4); 
        tree.root.right.left = new Node(4); 
        tree.root.right.right = new Node(3); 
        boolean output = tree.isSymmetric(); 
        System.out.println("Is This Tree is Symmetric = " + output); 

	}

}
