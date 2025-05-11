package datastructures.binarytrees.traversal;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.stream.Collector;

public class TopViewOfBinaryTree {

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

    public static List<Integer> topView(Node root) {
        Map<Integer, Integer> map = new TreeMap<>();
        if (root == null) {
            return null;
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            Node node = current.node;
            int axis = current.axis;
            map.putIfAbsent(axis, node.data);

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
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(11);
        root.left.right.left.left= new Node(12);
        root.left.right.left.left.left= new Node(13);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.right = new Node(8);
        root.right.right.right.right = new Node(9);

        System.out.println("Top View = " + topView(root));
    }

}
