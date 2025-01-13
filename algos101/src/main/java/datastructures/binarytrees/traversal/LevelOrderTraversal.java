package datastructures.binarytrees.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://takeuforward.org/data-structure/level-order-traversal-of-a-binary-tree/
public class LevelOrderTraversal {

    public static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static List<List<Integer>> levelOrder(Node root) {  
        List<List<Integer>> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Node> nextLevel = nextLevel(queue, result);
            queue.addAll(nextLevel); 
        }
        return result;
    }

    private static List<Node> nextLevel(Queue<Node> queue, List<List<Integer>> result) {
        List<Node> nextLevel = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            level.add(node.data);
            if (node.left != null)
                nextLevel.add(node.left);
            if (node.right != null)
                nextLevel.add(node.right);
        }
        result.add(level);
        return nextLevel;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("Level Order Print = " + levelOrder(root));

    }

}
