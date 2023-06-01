package datastructures.trees;

/**
 * Check whether tree is Binary Search Tree or not.
 *
 */
public class CheckBST {
	
	static class Node {
		int data;
		Node left, right;
		
		public Node(int data) {
			this.data = data;
			left = right = null;
		}
	}
	
	Node root;
	
	/**
	 * Check whether tree is BST.
	 * @param root
	 * @return
	 */
	public boolean isBST(Node root) {
		if (root == null) return true;
		
        boolean leftStatus = false, rightStatus = false;
        
        if ( (root.left != null && root.left.data > root.data) ) {
           return false;
        } else {
           leftStatus = isBST(root.left);
        }
        
        if ( (root.right != null && root.right.data < root.data) ) {
            return false;
        } else {
            rightStatus = isBST(root.right);
        }       
        
        if (leftStatus && rightStatus) 
            return true;
        else 
            return false;
	}
	
	
	

	public static void main(String[] args) {

		CheckBST tree = new CheckBST();
		tree.root = new Node(7);
		tree.root.left = new Node(4);
		tree.root.right = new Node(14);
		tree.root.left.left = new Node(2);
		tree.root.left.right = new Node(6);
		tree.root.right.left = new Node(11);
		//tree.root.right.left.right = new Node(10);

		boolean bst = tree.isBST(tree.root);
		
		System.out.println("Is BST = " + bst);
	}

}
 