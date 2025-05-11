package datastructures.binarysearchtrees;

// https://takeuforward.org/data-structure/inorder-successor-predecessor-in-bst

public class InorderSuccessorPredecessorInBinarySearchTree {

    public static class Node {
        int data;
        Node left, right;

        public Node (int data) {
            this.data = data;
            left = right = null;
        }
    }



    // Optimized solution 
    public static Node findInorderSuccessor(Node root, int key) {
        if (root == null) {
            return null;
        }

        Node curr = root;
        Node successor = null;
        while (curr != null) {
            if (curr.data > key) {
                if (successor == null) {
                    successor = curr;
                } else {
                    // whoeven is smaller.
                    successor = (curr.data < successor.data) ? curr : successor;
                }
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        return successor;

    }

    // Optimized Approach
    public static Node findInorderPredecessor(Node root, int key) {
        if (root == null) {
            return null;
        }

        Node curr = root;
        Node predecessor = null; 

        while (curr != null) {
            if (curr.data < key) {
                if (predecessor == null) {
                    predecessor = curr;
                } else {
                    // Whoever is greater
                    predecessor = (curr.data > predecessor.data) ? curr : predecessor;
                }
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        return predecessor;
    }


    public static void main(String[] args) {
        
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.left.left.left = new Node(1);
        root.right.left = new Node(11);
        root.right.right = new Node(18);
        root.right.right.left = new Node(16);

        System.out.println("Successor = " + findInorderSuccessor(root, 11).data);

        System.out.println("Predecessor = " + findInorderPredecessor(root, 16).data);

    }

}
