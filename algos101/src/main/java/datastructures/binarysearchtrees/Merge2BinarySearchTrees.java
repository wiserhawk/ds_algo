package datastructures.binarysearchtrees;

import java.util.ArrayList;
import java.util.List;

import datastructures.binarysearchtrees.BinarySearchTreeIterator.Node;

//https://www.geeksforgeeks.org/merge-two-bsts-with-limited-extra-space/
// Solution explained : https://www.youtube.com/watch?v=D2jMcmxU4bs

public class Merge2BinarySearchTrees {


    public static List<Integer> mergeBSTs(Node root1, Node root2) {
        List<Integer> result = new ArrayList<>();
        BinarySearchTreeIterator iterator1 = new BinarySearchTreeIterator(root1);
        BinarySearchTreeIterator iterator2 = new BinarySearchTreeIterator(root2);

        while (iterator1.hasNext() || iterator2.hasNext()) {
            Integer first = iterator1.hasNext() ? iterator1.next() : null;
            Integer second = iterator2.hasNext() ? iterator2.next() : null;
            
            if (first != null && second != null) {
                if (first < second) {
                    result.add(first);
                    result.add(second);
                } else {
                    result.add(second);
                    result.add(first);
                }
            } else if (first != null) {
                result.add(first);
            } else {
                result.add(second);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        Node root1 = new Node(5);
        root1.left = new Node(3);
        root1.right = new Node(6);
        root1.left.left = new Node(2);
        root1.left.right = new Node(4);

        Node root2 = new Node(2);
        root2.left = new Node(1);
        root2.right = new Node(3);
        root2.right.right = new Node(7);
        root2.right.right.left = new Node(6);

        List<Integer> merged = mergeBSTs(root1, root2);
        System.out.println("Merged Tree = " + merged);
    }

}
