package datastructures.binarysearchtrees;

import java.util.ArrayList;
import java.util.List;

import datastructures.binarysearchtrees.BinarySearchTreeIterator.Node;

// https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/

// Hint: To further optimize this solution, you can use BinarySearchTreeIterator to traverse the tree in O(n) time and Space O(h). 
// Use Iterator insteand of sorted int array.

public class TwoSumInBinarySearchTree {

    // Is there any two nodes in Binary Search Tree which sum is equal to given number (k).
    public static boolean findTarget(Node root, int k) {
        if (root == null) {
            return false;
        }
        List<Integer> inorder = new ArrayList<>();
        inOrder(root, inorder);
        int[] nums = inorder.stream().mapToInt(i -> i).toArray();

        int i = 0;
        int j = nums.length-1;
        while (i < j) {
            if (nums[i] + nums[j] > k) {
                j--;
            } else if (nums[i] + nums[j] < k) {
                i++;
            } else if (nums[i] + nums[j] == k) {
                return true;
            }  
        }
        return false;
    } 

    private static void inOrder(Node root, List<Integer> inorder) {
        if (root != null) {
            inOrder(root.left, inorder);
            inorder.add(root.data);
            inOrder(root.right, inorder);
        }
    }


    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(6);        
        root.left.left = new Node(2);   
        root.left.right = new Node(4);   
        root.right.right = new Node(7);

        System.out.println("Find Target = " + findTarget(root, 3));
    }

}
