package datastructures.binarytrees.traversal.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

// https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/

// Explaination: https://www.youtube.com/watch?v=i9ORlEy6EsI

public class NodeDistanceK {

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
        int distance;

        public Pair(Node node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public static List<Integer> findNodesAtDistanceK(Node root, int target, int k) {
        Map<Node, Node> childParentMap = createChildParentMap(root);
        Node targetNode = searchTargetNode(root, target);
        List<Integer> resultNodes = searchNodesAtDistanceK(targetNode, k, childParentMap);
        return resultNodes;
    }

    private static Map<Node, Node> createChildParentMap(Node root) {
        Map<Node, Node> parentMap = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.left != null) {
                parentMap.put(node.left, node);
                queue.add(node.left);
            }
            if (node.right != null) {
                parentMap.put(node.right, node);
                queue.add(node.right);
            }
        }
        return parentMap;
    }

    private static Node searchTargetNode(Node root, int target) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.data == target) {
                return node;
            }
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return null;
    }

    private static List<Integer> searchNodesAtDistanceK(Node target, int k, Map<Node, Node> childParentMap) {
        List<Integer> result = new ArrayList<>();
        List<Node> visitedNodes = new ArrayList<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(target, 0));

        while (!queue.isEmpty()) {
            Pair currPair = queue.poll();
            Node currNode = currPair.node;
            int currDistance = currPair.distance;
            visitedNodes.add(currNode);
            
            if (currDistance == k) {
                result.add(currNode.data);
            }
            
            if (currDistance < k ) {
                if (currNode.left != null && !visitedNodes.contains(currNode.left)) {
                    queue.add(new Pair(currNode.left, currDistance+1));
                }
                if (currNode.right != null && !visitedNodes.contains(currNode.right)) {
                    queue.add(new Pair(currNode.right, currDistance+1));
                }
                
                Node parentNode = childParentMap.get(currNode);
                if (parentNode != null & !visitedNodes.contains(parentNode)) {
                    queue.add(new Pair(parentNode, currDistance+1));
                }
            }
            
        }
        return result;
    }

    public static void main(String[] args) {

        Node root = new Node(3);        
        root.left = new Node(5);   
        root.right = new Node(1);   
        root.left.left = new Node(6);   
        root.left.right = new Node(2);   
        root.right.left = new Node(0);   
        root.right.right = new Node(8);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(4);

        System.out.println("Nodes At Distance K = " + findNodesAtDistanceK(root, 5, 2));
    }

}
