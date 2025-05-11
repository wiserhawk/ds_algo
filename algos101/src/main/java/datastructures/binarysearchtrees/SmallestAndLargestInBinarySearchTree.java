package datastructures.binarysearchtrees;

import java.util.ArrayList;
import java.util.List;

// https://takeuforward.org/data-structure/kth-largest-smallest-element-in-binary-search-tree/

public class SmallestAndLargestInBinarySearchTree {

    public static class Node {
        int data;
        Node left, right;
        
        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static int kthSmallest(Node root, int k) {
        List<Integer> inorderList = new ArrayList<>();
        inorder(root, inorderList, k);
        System.out.println("Inorder = " + inorderList);
        return inorderList.get(k-1);
    }

    private static void inorder(Node root, List<Integer> inorderList, int count) {
        if (root == null || inorderList.size() >= count) {
            return;
        }
        inorder(root.left, inorderList, count);
        inorderList.add(root.data);
        inorder(root.right, inorderList, count);
    }

    public static int kthLargest(Node root, int k) {
        List<Integer> reverseInorderList = new ArrayList<>();
        reverseInorder(root, reverseInorderList, k);
        System.out.println("ReverseInorder = " + reverseInorderList);
        return reverseInorderList.get(k-1);
    }

    private static void reverseInorder(Node root, List<Integer> reverseInorderList, int count) {
        if (root == null || reverseInorderList.size() >= count) {
            return;
        }
        reverseInorder(root.right, reverseInorderList, count);
        reverseInorderList.add(root.data);
        reverseInorder(root.left, reverseInorderList, count);
    }



    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(13);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.left.left.left = new Node(1);
        root.right.left = new Node(11);
        root.right.right = new Node(15);    
        root.right.right.left = new Node(14);

        System.out.println("Kth Smallest = " + kthSmallest(root, 3));
        System.out.println("Kth Largest = " + kthLargest(root, 3));

    }

}
