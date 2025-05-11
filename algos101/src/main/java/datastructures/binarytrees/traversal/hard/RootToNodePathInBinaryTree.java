package datastructures.binarytrees.traversal.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://takeuforward.org/data-structure/print-root-to-node-path-in-a-binary-tree/

public class RootToNodePathInBinaryTree {

    public static class Node {
        int data;
        Node left, right;
        
        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static List<Integer> findPath(Node root, int num) {
        List<Integer> path = new ArrayList<>();
        findPath(root, num, path);
        // So far path is from bottom to top. Therefore need to reverse the path (top to bottom).
        Collections.reverse(path);
        return path;
    }

    private static boolean findPath(Node node, int target, List<Integer> path) {
        if (node == null) {
            return false;
        }

        if (node.data == target) {
            path.add(node.data);
            return true;
        }

        if (findPath(node.left, target, path) || findPath(node.right, target, path)) {
            path.add(node.data);
            return true;
        }
        
        return false;
    }

    public static List<Integer> getPath(Node root, int num) {
        List<Integer> path = new ArrayList<>();
        getPath(root, num, path); 
        return path;
    }

     private static boolean getPath(Node node, int target, List<Integer> path) {
        // Base case: If the current
        // node is null, return false
        if (node == null) {
            return false;
        }

        // Add the current node's
        // value to the path list
        path.add(node.data);

        // If the current node's value is equal
        // to the target value 'x', return true
        if (node.data == target) {
            return true;
        }

        // Recursively search for the target value
        // 'x' in the left and right subtrees
        if (getPath(node.left, target, path) || getPath(node.right, target, path)) {
            return true;
        }

        // If the target value 'x' is not found
        // in the current path, backtrack
        path.remove(path.size() - 1);
        return false;
    }
    

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(9);
        root.right.right = new Node(6);
        root.right.left = new Node(7);

        System.out.println("path Using findPath() = " + findPath(root, 9));
        System.out.println("Path Using getPath() = " + getPath(root, 9));

    }

}
