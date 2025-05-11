package datastructures.binarytrees.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalOrderTraversal {

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

    private static Map<Integer,List<Node>> verticalOrderTraversal(Node root) {
        Map<Integer,List<Node>> nodes = new TreeMap<>(); 
        if (root == null) {
            return nodes;
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            Node node = pair.node;
            int axis = pair.axis;
            if (nodes.get(axis) == null) {
                nodes.put(axis, new ArrayList<>());
            }
            List<Node> list = nodes.get(axis);
            list.add(node);
            if (node.left != null)
                queue.add(new Pair(node.left, axis-1));
            if (node.right!= null)
                queue.add(new Pair(node.right, axis+1));
        }
        return nodes;
    }
    

    public static void printVerticalOrder(Node root) {
        Map<Integer, List<Node>> map = verticalOrderTraversal(root);
        
        for (Map.Entry<Integer, List<Node>> entry: map.entrySet()) {
            System.out.print("Axis="+ entry.getKey() + ":");
            for (Node node : entry.getValue()) {
                System.out.print(", " + node.data);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(10);
        root.left.left.right = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right = new Node(3);
        root.right.right = new Node(10);
        root.right.left = new Node(9);

        printVerticalOrder(root);
    }

}
