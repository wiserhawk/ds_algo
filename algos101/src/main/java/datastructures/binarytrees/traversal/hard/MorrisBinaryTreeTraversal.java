package datastructures.binarytrees.traversal.hard;

import java.util.ArrayList;
import java.util.List;

// https://takeuforward.org/data-structure/morris-preorder-traversal-of-a-binary-tree/
// Approach: https://www.youtube.com/watch?v=80Zug6D1_r4

public class MorrisBinaryTreeTraversal {

    public static class Node {
        int data;
        Node left, right;   

        public Node(int data) {
            this.data = data;
            left = right = null;
        } 
    }

    // preorder traversal (Root -> Left -> Right)
    public static List<Integer> preOrderTraversal(Node root) {
        List<Integer> result = new ArrayList<>();
        Node current = root;
        while (current != null) {
            // If the current node has a left child, then right child will be the next node to visit;
            if (current.left == null) {
                result.add(current.data);
                current = current.right;
            } else {
                Node prev = current.left;
                while (prev.right != null && prev.right != current) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    result.add(current.data);
                    prev.right = current;
                    current = current.left;
                } else {
                    prev.right = null;
                    current = current.right;
                }

            }
        }
        return result;
    }

     // preorder traversal (Left -> Root -> Right)
     public static List<Integer> inOrderTraversal(Node root) {
        List<Integer> result = new ArrayList<>();
        Node current = root;
        while (current != null) {
            // If the current node has a left child, then right child will be the next node to visit;
            if (current.left == null) {
                result.add(current.data);
                current = current.right;
            } else {
                Node prev = current.left;
                while (prev.right != null && prev.right != current) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = current;
                    current = current.left;
                } else {
                    result.add(current.data);
                    prev.right = null;
                    current = current.right;
                }
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);    
        root.right = new Node(3);    
        root.left.left = new Node(4);    
        root.left.right = new Node(5);    
        root.left.right.right = new Node(6);
        
        System.out.println("Pre Order = " + preOrderTraversal(root));
        System.out.println("In Order = " + inOrderTraversal(root));
        
    }

}
