package datastructures.binarytrees.traversal;

// https://takeuforward.org/data-structure/check-if-the-binary-tree-is-balanced-binary-tree/

public class BalancedBinaryTree {

    public static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static boolean isBalanced(Node root) {
        if (root == null) {
            return true;
        }

        int leftHeight = height(root.left, 0);
        int rightHeight = height(root.right, 0);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        } else {
            return true;
        }
    }

    private static int height(Node node, int height) {
        if (node == null) {
            return height;
        }

        int leftHeight = height(node.left, height+1);
        int rightHeight = height(node.right, height+1);
        return Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);   
        root.left.right = new Node(5);
        root.right.left = new Node(6);        
        root.right.right = new Node(7);        
        
        System.out.println("Is Tree Balanced = " + isBalanced(root));

        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);   
        root2.left.right = new Node(5);        
        root2.right.left = new Node(6); 
        root2.right.right = new Node(07);
        root2.right.right.right = new Node(8);
        root2.right.right.right.right = new Node(9);
        
        System.out.println("Is Tree Balanced = " + isBalanced(root2));
        
    }

}
