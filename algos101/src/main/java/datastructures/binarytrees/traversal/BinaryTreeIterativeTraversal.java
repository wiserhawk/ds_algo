package datastructures.binarytrees.traversal;

import java.util.ArrayList;
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
    

    public static void main(String[] args) {    
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("Pre Order = " + preOrder(root));
        //System.out.println("In Order = " + inOrder(root));
        //System.out.println("Post Order = " + postOrderTraveral(root));
        

    }

}
