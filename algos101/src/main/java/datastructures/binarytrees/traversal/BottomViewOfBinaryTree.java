package datastructures.binarytrees.traversal;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

// https://takeuforward.org/data-structure/bottom-view-of-a-binary-tree/
public class BottomViewOfBinaryTree {

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
        int axis;

        public Pair(Node node, int axis) {
            this.node = node;
            this.axis = axis;
        }
    }

    public static List<Integer> bottomView(Node root) {
        if (root == null) {
            return null;
        }

        Map<Integer, Integer> map = new TreeMap<>();

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        // Using BFS
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            Node node = current.node;
            int axis = current.axis;
            map.put(axis, node.data);

            if (node.left != null) {
                queue.add(new Pair(node.left, axis-1));
            }
            if (node.right != null) {
                queue.add(new Pair(node.right, axis+1));
            }
        }

       return map.entrySet().stream().map(entry -> entry.getValue()).toList();

    }
    
    
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(10);
        root.left.left.right = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right = new Node(3);
        root.right.right = new Node(11);
        root.right.left = new Node(9);

        System.out.println("Bottom View = " + bottomView(root));
    }

}
