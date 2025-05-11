package datastructures.binarytrees.traversal.hard;

/**
 * Given the root of a complete binary tree, return the number of the nodes in the tree.
 * According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, 
 * and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 * 
 * Note: Design an algorithm that runs in less than O(n) time complexity.
 */

// https://leetcode.com/problems/count-complete-tree-nodes/description/


public class CountNodesOfCompleteBinaryTree {

    public static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static int countNodes(Node root) {
        int leftHeight = leftHeight(root, 0);
        int rightHeight = rightHeight(root, 0);
        return calculateNodes(leftHeight, rightHeight);
    }

    private static int leftHeight(Node node, int height) {
        if (node == null) {
            return height;
        } 
        return leftHeight(node.left, height+1);
    }

    private static int rightHeight(Node node, int height) {
        if (node == null) {
            return height;
        } 
        return rightHeight(node.right, height+1);
    }

    private static int calculateNodes(int leftHeight, int rightHeight) {
        if (leftHeight == rightHeight)
            return ((int) Math.pow(2, leftHeight)) - 1;
        else
            return ((int) Math.pow(2, leftHeight)) - 2;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);

        System.err.println("Number of Nodes = " + countNodes(root));
    }


}
