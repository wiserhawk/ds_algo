package datastructures.binarysearchtrees;

public class MinAndMaxInBinarySearchTree {

    public static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static Node searchMinimumRecursively(Node root) {
        if (root == null) {
            return null;
        }
        return (root.left != null) ? searchMinimumRecursively(root.left) : root;
    }

    public static Node searchMaximumRecursively(Node root) {
        if (root == null) {
            return null;
        }
        return (root.right != null) ? searchMaximumRecursively(root.right) : root;
    }

    public static Node searchMinimumIteratively(Node root) {
        if (root == null) {
            return null;
        }
        Node curr = root;
        while (curr != null) {
            if (curr.left != null) {
                curr = curr.left;
            } else {
                return curr;
            }
        }
        return null;
    }

    public static Node searchMaximumIteratively(Node root) {
        if (root == null) {
            return null;
        }
        Node curr = root;
        while (curr != null) {
            if (curr.right != null) {
                curr = curr.right;
            } else {
                return curr;
            }
        }
        return null;

    }


    public static void main(String[] args) {

        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(6);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.right = new Node(7); 
        root.right.right.left = new Node(8);
        root.right.right.right = new Node(9);

        System.out.println("Minimum (Recursively) = " + searchMinimumRecursively(root).data);

        System.out.println("Maximum (Recursively)= " + searchMaximumRecursively(root).data);

        System.out.println("Minimum (Iteratively)= " + searchMinimumIteratively(root).data);

        System.out.println("Maximum (Iteratively)= " + searchMaximumIteratively(root).data);

    }

}
