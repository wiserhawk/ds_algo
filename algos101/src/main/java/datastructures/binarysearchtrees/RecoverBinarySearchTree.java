package datastructures.binarysearchtrees;

// https://leetcode.com/problems/recover-binary-search-tree/description/
// Explanation : https://www.youtube.com/watch?v=ZWGW7FminDM

public class RecoverBinarySearchTree {

    public static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    private Node first, second, previous;

    private void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        if (previous != null && previous.data > root.data) {
            if(first == null) 
                first = previous;
            second = root;
            previous = root;
        } 
        previous = root;

        inorder(root.right);

    }
    
    
    public void recoverTree(Node root) {
        // Reset Variables
        first = second = previous = null;
        if (root == null) {
            return;
        }

        inorder(root);
        // Swap first and seccond nodes values;
        int temp = first.data;
        first.data = second.data;
        second.data = temp;
    }

    public String printInOrder(Node root) {
        if (root == null) {
            return "";
        }
        return printInOrder(root.left) + " " + root.data + " " + printInOrder(root.right);
    }

    public static void main(String[] args) {   
        // First Case
        Node root = new Node(5);        
        root.left = new Node(3);   
        root.right = new Node(6);   
        root.left.left = new Node(2);   
        root.left.right = new Node(7);   
        root.right.right = new Node(4);
        RecoverBinarySearchTree recoverBST = new RecoverBinarySearchTree();
        System.out.println("Before Recover = " + recoverBST.printInOrder(root));
        recoverBST.recoverTree(root);
        System.out.println("After Recover = " + recoverBST.printInOrder(root));

        // Second Case
        Node root1 = new Node(3);
        root1.left = new Node(1);
        root1.right = new Node(4);
        root1.right.left = new Node(2);
        System.out.println("Before Recover = " + recoverBST.printInOrder(root1));
        recoverBST.recoverTree(root1);
        System.out.println("After Recover = " + recoverBST.printInOrder(root1));

    }

}
