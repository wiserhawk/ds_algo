package datastructures.binarytrees.traversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://takeuforward.org/data-structure/boundary-traversal-of-a-binary-tree/

public class BoundaryTraversalBinaryTree {

    public static class Node {

        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    private static boolean isLeafNode(Node node) {
        return (node.left == null && node.right == null);
    }

    private static void leftBoundaryTraversal(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }

        Node current = root;
        while (current != null) {
            if (!isLeafNode(current)) {
                result.add(current.data);
            }
            if (current.left != null) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
    }

    private static void rightBoundaryTraversal(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }
        List<Integer> tempResult = new ArrayList<>();
        Node current = root.right;
        while (current != null) {
            if (!isLeafNode(current)) {
                tempResult.add(current.data);
            }

            if (current.right != null) {
                current = current.right;
            } else {
                current = current.left;
            }
        }

        Collections.reverse(tempResult);
        result.addAll(tempResult);
    }

    private static void leafNodesTraversal(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }

        if (isLeafNode(root)) {
            result.add(root.data);
            return;
        }

        leafNodesTraversal(root.left, result);
        leafNodesTraversal(root.right, result);
    }

    public static List<Integer> boundaryTraversal(Node root) {
        List<Integer> result = new ArrayList<>();
        leftBoundaryTraversal(root, result);
        leafNodesTraversal(root, result);
        rightBoundaryTraversal(root, result);
        return result;
    }

    public static void main(String[] args) {

       Node root = new Node(1);
       root.left = new Node(2);
       root.right = new Node(3);
       root.left.left = new Node(4);
       root.left.right = new Node(5);
       root.right.left = new Node(6);
       root.right.right = new Node(7);
       root.right.left.right = new Node(8);
       root.right.right.right = new Node(9);
       List<Integer> result = boundaryTraversal(root);
       System.out.println("Boundary Traversal = " + result);
      

    }

}
