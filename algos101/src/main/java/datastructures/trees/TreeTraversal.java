package datastructures.trees;

public class TreeTraversal {
	
	class Node {
		int data;
		Node left, right;
		
		public Node(int data) {
			this.data = data;
			left = right = null;
		}
	}
	
	Node root;
	
	// Traverse Left -> Parent -> Right
	// Prints elements in sorted order
	public void inorderTraversal(Node node) {
		if (node == null) {
			return;
		}
		
		if (node.left != null) {
			inorderTraversal(node.left);
		} 
		
		System.out.print(" " + node.data);
		
		if (node.right != null) {
			inorderTraversal(node.right);
		}
	}
	
	// Traverse Parent -> Left -> Right
	public void preorderTraversal(Node node) {
		if (node == null)
			return;
		
		System.out.print(" " + node.data);
		
		if (node.left != null) {
			preorderTraversal(node.left);
		}
		
		if (node.right != null) {
			preorderTraversal(node.right);
		}
	}
	
	// Traverse left -> Right -> Parent
	public void postorderTraversal(Node node) {
		if (node == null)
			return;
		
		if (node.left != null) {
			postorderTraversal(node.left);
		}
		
		if (node.right != null) {
			postorderTraversal(node.right);
		}
		
		System.out.print(" " + node.data);
	}
	
	public static void main(String[] args) {
		TreeTraversal tree = new TreeTraversal();
		tree.root = tree.new Node(5);
		tree.root.left = tree.new Node(3);
		tree.root.right = tree.new Node(10);
		tree.root.left.left = tree.new Node(1);
		tree.root.left.right = tree.new Node(4);
		tree.root.right.left = tree.new Node(7);
		tree.root.right.right = tree.new Node(12);
		tree.inorderTraversal(tree.root);
		System.out.println("");
		System.out.println("================================================");
		tree.preorderTraversal(tree.root);
		System.out.println("");
		System.out.println("================================================");
		tree.postorderTraversal(tree.root);
		
	}

}
