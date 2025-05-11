package datastructures.binarytrees.traversal.hard;

import java.util.Stack;

// https://takeuforward.org/data-structure/flatten-binary-tree-to-linked-list/

public class FlattenBinaryTree {

    public static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    private static Node prev = null;

    public static void flattenRecursively (Node root) {
        if (root == null) {
            return;
        }
        flattenRecursively(root.right);
        flattenRecursively(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    public static void flattenIteratively (Node root) {
        if (root == null) {
            return;
        }
      
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            Node cur = stack.pop();
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (!stack.empty()) {
                cur.right = stack.peek();
            }
            cur.left = null;
        }
    }

    public static void flattenUsingMorris(Node root) {
         Node curr = root;

        while (curr != null) {
            
            if (curr.left != null) {
                Node pre = curr.left;
                while (pre.right != null) {
                    pre = pre.right;
                }

                pre.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }

    public static void printPreorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + ", ");
        printPreorder(root.left);
        printPreorder(root.right);
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
    
        flattenRecursively(root);
        System.out.println("\nFlattened Tree Using Recursion");
        printPreorder(root);

        flattenIteratively(root);
        System.out.println("\nFlattened Tree Using Iteration");
        printPreorder(root);

        flattenUsingMorris(root);
        System.out.println("\nFlattened Tree Using Morris");
        printPreorder(root);
        
    }

}
