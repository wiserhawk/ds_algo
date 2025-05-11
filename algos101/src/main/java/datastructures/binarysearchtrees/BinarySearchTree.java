package datastructures.binarysearchtrees;

public class BinarySearchTree {

    public static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static Node searchRecursively(Node root, int key) { 
        if (root == null) { 
            return null;
        }

        if (root.data == key) {
            return root;
        }
        if (root.data > key) {
            return searchRecursively(root.left, key);
        } 
        if (root.data < key) {
            return searchRecursively(root.right, key);
        }
        return null;
    }    


    public static Node searchIteratively(Node root, int key) {
        if (root == null) {
            return null;
        }
        Node current = root;
        while (current != null) {
            if (current.data == key) {
                return current;
            }
            if (current.data > key) {
                current = current.left;
            }
            else if (current.data < key) {
                current = current.right;
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

        Node node = searchRecursively(root, 4);
        System.out.println("Recursive Result Node = " + ((node != null) ? node.data : null));
        
        node = searchIteratively(root, 2);
        System.out.println("Iterative Result Node = " + ((node != null) ? node.data : null));
    }

}
