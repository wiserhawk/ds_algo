package datastructures.binarysearchtrees;

import java.util.Stack;

// https://leetcode.com/problems/binary-search-tree-iterator/description/
// Solution Explanation: https://www.youtube.com/watch?v=D2jMcmxU4bs

// Hint: follow InOrder Traversal (sorted order). (left -> Root -> Right)

public class BinarySearchTreeIterator {

    public static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Space Complexity O(H) : H - Hight of tree.
    private Stack<Node> stack = new Stack<>();

    public BinarySearchTreeIterator(Node root) {
        fillStack(root);
    }

    // Add the given node in the stack and all left children of given node. 
    private void fillStack(Node node) {
        if (node != null) {
            Node curr = node;
            while (curr != null) {
                stack.add(curr);
                curr = curr.left;
            }
        }
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int next() {
        Node next = null;
        if (hasNext()) {
            next = stack.pop();
            // if there any right node exist we will refill that and all the stack with all the left children of it.
            if (next.right != null) {
                fillStack(next.right);
            }
            return next.data;
        }
        throw new IndexOutOfBoundsException("Index is out of range");
    }

    public static void main(String[] args) {

        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(6);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.right = new Node(7);

        BinarySearchTreeIterator it = new BinarySearchTreeIterator(root);
        System.out.println("Has Next = " + it.hasNext());
        System.out.println("Next = " + it.next());
        System.out.println("Has Next = " + it.hasNext());
        System.out.println("Next = " + it.next());
        System.out.println("Has Next = " + it.hasNext());
        System.out.println("Next = " + it.next());
        System.out.println("Has Next = " + it.hasNext());
        System.out.println("Next = " + it.next());
        System.out.println("Has Next = " + it.hasNext());
        System.out.println("Next = " + it.next());
        System.out.println("Has Next = " + it.hasNext());
        System.out.println("Next = " + it.next());
        System.out.println("Has Next = " + it.hasNext());
        System.out.println("Next = " + it.next());
       
    }

}
