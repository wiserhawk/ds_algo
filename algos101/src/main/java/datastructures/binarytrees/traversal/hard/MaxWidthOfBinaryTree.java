package datastructures.binarytrees.traversal.hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://takeuforward.org/data-structure/maximum-width-of-a-binary-tree/
public class MaxWidthOfBinaryTree {

    public static class Node {
        int data;
        Node left, right;
        
        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static class Pair {
        Node node;
        int number;

        public Pair(Node node, int number) {
            this.node = node;
            this.number = number;
        }
    }

    public static int maxWidth(Node root) {
        if (root == null) {
            return 0;
        }
        int maxWidth = 0;
        Queue<Pair> queue = new LinkedList<>();
        int number = 0;
        queue.add(new Pair(root, number));
        int min = Integer.MAX_VALUE;
        int max = 0;
        List<Pair> nextLevelNodes = new ArrayList<>();
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            Node node = pair.node;
            min = Math.min(pair.number, min);
            max = Math.max(pair.number, max);
            number++;  
            if (node.left != null) {
                nextLevelNodes.add(new Pair(node.left, number));
            }
            number++;
            if (node.right !=null) {
                nextLevelNodes.add(new Pair(node.right, number));
            }
            
            if (queue.isEmpty()) {
                maxWidth = Math.max(maxWidth, width(max, min));
                queue.addAll(nextLevelNodes);
                nextLevelNodes.clear();
                min = Integer.MAX_VALUE;
                max = 0;
            }
        }
        return maxWidth;
    }

    private static int width(int max, int min) {
        return (max - min) + 1;
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("Maximum Width = " + maxWidth(root));

        Node root1 = new Node(1);    
        root1.left = new Node(2);    
        root1.right = new Node(3);    
        //root1.left.left = new Node(4);    
        root1.left.right = new Node(5);    
        root1.right.right = new Node(6); 

        System.out.println("Maximum Width = " + maxWidth(root1));

    }

}
