package datastructures.binarytrees.traversal;

import java.util.ArrayList;
import java.util.List;

/**
 * Traverse Binary tree using Recursive approach.
 *  1. Pre Order Traversal
 *  2. In Order Traversal
 *  3. Post Order Traversal
 */
public class BinaryTreeRecursiveTraversal {

    public static class Node {
        int data;
        Node left, right;
        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }   

    // Root -> Left -> Right
    public static List<Integer> preOrderTraversal(Node root) {
        List<Integer> result = new ArrayList<>();
        preOrder(root, result);
        return result;
    }

    private static void preOrder(Node node, List<Integer> result) {
        if (node == null) 
            return;

        result.add(node.data);
        preOrder(node.left, result);
        preOrder(node.right, result);
    }

    // Left -> Root -> Right
    public static List<Integer> inOrderTraversal(Node root) {
        List<Integer> result = new ArrayList<>();
        inOrder(root, result);
        return result;
    }

    private static void inOrder(Node node, List<Integer> result) {
        if (node == null)
            return;
        inOrder(node.left, result);
        result.add(node.data);
        inOrder(node.right, result);
    }


    // Lift -> Right -> Root
    public static List<Integer> postOrderTraveral(Node root) {
        List<Integer> result = new ArrayList<>();
        postOrder(root, result);
        return result;
    }

    private static void postOrder(Node node, List<Integer> result) {
        if (node == null)
            return;

        postOrder(node.left, result);    
        postOrder(node.right, result);
        result.add(node.data);
    }



    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);        
        root.right.right = new Node(7);
        
        System.out.println("Pre Order = " + preOrderTraversal(root));
        System.out.println("In Order = " + inOrderTraversal(root));
        System.out.println("Post Order = " + postOrderTraveral(root));
    }

}
