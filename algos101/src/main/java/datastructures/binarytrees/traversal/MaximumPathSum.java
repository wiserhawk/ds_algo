package datastructures.binarytrees.traversal;

// https://takeuforward.org/data-structure/maximum-sum-path-in-binary-tree/

public class MaximumPathSum {
    
    public static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static int maxPathSum(Node root) {
        if (root == null) {
            return 0;
        }

        int[] max = new int[1];

        depth(root, max);
        return max[0];
    }

    private static int depth(Node node, int[] max) {
        if (node == null) {
            return 0;
        }

        int leftMax = 0;
        int rightMax = 0;

        if (node.left != null) {
            leftMax = depth(node.left, max);
        }

        if (node.right != null) {
            rightMax = depth(node.right, max);
        }

        max[0] = Math.max(max[0], leftMax + rightMax + node.data);

        return node.data + Math.max(leftMax, rightMax);
        
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(-2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(-6);
        System.out.println("Maximum Path Sum: " + maxPathSum(root));

        Node root1 = new Node(-10);
        root1.left = new Node(9);
        root1.right = new Node(20);
        root1.right.left = new Node(15);
        root1.right.right = new Node(7);
        System.out.println("Maximum Path Sum: " + maxPathSum(root1));
    
    }
}
