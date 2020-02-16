package datastructures.binarytree;

/**
 * Basic Binary Tree operations like Add , Delete and Search.
 * @author Manoj
 *
 */
public class BinaryTreeOperations {
	
	static class Node {
		int data;
		Node left, right;
		
		public Node(int data) {
			this.data = data;
			left = right = null;
		}
	}
	
	// Root Node of Tree
	Node root;
	
	/**
	 * Add new node in binary tree to its correct position.
	 * @param parent
	 * @param node
	 */
	private void addNode(Node parent, Node node) {
		if (node == null) return;
		
		if (parent != null) {
			if (node.data < parent.data) {
				if (parent.left != null)
					addNode(parent.left, node);
				else 
					parent.left = node;
				
			} else if (node.data > parent.data) {
				if (parent.right != null)
					addNode(parent.right, node);
				else
					parent.right = node;
			}
		}
	}
	
	/**
	 * This is a wrapper method to add new node in binary tree.
	 */
	public void add(int data) {
		Node node = new Node(data);
		addNode(root, node);
	}
	
	/**
	 * Search given element from binary tree.
	 * @param parent
	 * @param data
	 * @return
	 */
	private Node searchNode(Node parent, int data) {
		if (parent == null) return null;
		
		if (data < parent.data) {
			return searchNode(parent.left, data);
		} else if (data > parent.data) {
			return searchNode(parent.right, data);
		} else {
			return parent;
		}
	}
	
	/**
	 * This is a wrapper method to search an element from binary tree.
	 * @param data
	 * @return
	 */
	public Node search(int data) {
		if (root == null) return null;
		return searchNode(root, data);
	}
	
	/**
	 * Search a given element in binary tree and delete it.
	 * @param parent
	 * @param data
	 * @return
	 */
	private boolean deleteNode(Node parent, int data) {
		if (parent == null) return false;
		
		if (data < parent.data) {
			boolean status = deleteNode(parent.left, data);
			if (status) 
				parent.left = null;
			return false;
		} else if (data > parent.data) {
			boolean status = deleteNode(parent.right, data);
			if (status) 
				parent.right = null;
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * This is a wrapper method to delete an element from tree.
	 * @param data
	 */
	public void delete(int data) {
		if (root != null)
			deleteNode(root, data);
	}

	public static void main(String[] args) {
		
		BinaryTreeOperations tree = new BinaryTreeOperations();
		
		tree.root = new Node(7);
		tree.root.left = new Node(4);
		tree.root.right = new Node(14);
		tree.root.left.left = new Node(2);
		tree.root.left.right = new Node(6);
		tree.root.right.left = new Node(11);
		
		System.out.println("Adding New Node");
		tree.add(1);
		System.out.println("Node Added Successfully");
		
		System.out.println("###########################################");
		
		System.out.println("Searching A Node");
		Node node = tree.search(6);
		int data = (node != null) ? node.data : 0 ;
		System.out.println("Search Result is find a node = " + data );
		
		System.out.println("###########################################");
		
		System.out.println("Deleting A Node");
		tree.delete(6);
		System.out.println("Node Deleted Successfully");
	}

}