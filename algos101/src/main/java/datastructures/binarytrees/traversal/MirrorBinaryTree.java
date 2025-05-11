package datastructures.binarytrees.traversal;

import java.util.LinkedList;
import java.util.Queue;

// https://www.geeksforgeeks.org/write-an-efficient-c-function-to-convert-a-tree-into-its-mirror-tree/

public class MirrorBinaryTree {

    public static class Node {
        int data;
        Node left;
        Node right; 

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static void mirror(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            // swap children 
            Node temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (node.left != null) 
                queue.add(node.left);
            if (node.right != null) 
                queue.add(node.right);
        }
    }

    public static String preorderString(Node root) {
        if (root == null) {
            return "";
        }
        return root.data + preorderString(root.left) + preorderString(root.right);
    }

    public static void main(String[] args) {   
        
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("Original Pre Order = " + preorderString(root));
        mirror(root);
        System.out.println("Mirror Pre Order = " + preorderString(root));
        

    }

}
