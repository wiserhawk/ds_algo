package datastructures.binarytrees.traversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import javax.xml.transform.stax.StAXResult;

/**
 * 
 * Traverse Binary tree using Iterative approach.
 *  1. Pre Order Traversal
 *  2. In Order Traversal
 *  3. Post Order Traversal
 * 
 */

public class BinaryTreeIterativeTraversal {

    public static class Node {
        int data;
        Node left, right;
        public Node(int data) {
            this.data = data;
            left = right = null;
        }    
    }

    // Root -> Left -> Right
    public static List<Integer> preOrder(Node root) {
        if (root == null) {
            return null;
        }
        Stack<Node> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            result.add(node.data);
            if (node.right != null)
                stack.add(node.right);
            if (node.left != null)
                stack.add(node.left);
        }
        return result;
    }    

     // Left -> Root -> Right
    public static List<Integer> inOrder(Node root) {
        if (root == null) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.add(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                result.add(curr.data);
                curr = curr.right;
            }
        }
        return result;
    }

    // Lift -> Right -> Root
    public static List<Integer> postOrderUsingSingleStack(Node root) {
        if (root == null) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                result.add(curr.data);
                stack.push(curr);
                curr = curr.right;
            } else {
                curr = stack.pop();
                curr = curr.left;
            }
        }
        Collections.reverse(result);
        return result;
    }

    // Lift -> Right -> Root
    public static List<Integer> postOrderUsingDoubleStacks(Node root) { 
        if (root == null) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.add(root);
        while (!stack1.isEmpty()) {
            Node node = stack1.pop();
            stack2.add(node);
            if (node.left != null)
                stack1.add(node.left);
            if (node.right != null)
                stack1.add(node.right);
        }
        while (!stack2.isEmpty()) {
            result.add(stack2.pop().data);
        }
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

        System.out.println("Pre Order = " + preOrder(root));
        System.out.println("In Order = " + inOrder(root));
        System.out.println("Post Order Single Stack = " + postOrderUsingSingleStack(root));
        System.out.println("Post Order Double Stack = " + postOrderUsingDoubleStacks(root));
        

    }

}
