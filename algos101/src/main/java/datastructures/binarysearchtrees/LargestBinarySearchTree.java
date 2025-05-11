package datastructures.binarysearchtrees;


// https://www.geeksforgeeks.org/problems/largest-bst/1
// Explanation: https://www.youtube.com/watch?v=X0oXMdtUDwo
// https://takeuforward.org/data-structure/largest-bst-in-binary-tree
public class LargestBinarySearchTree {

    public static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static class Data {
        int size, min, max;

        public Data(int size, int min, int max) {
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    
    public static int largestBST(Node root) {
        Data data = largestBSTUtil(root);
        return (data == null) ? 0 : data.size;
    }

    private static Data largestBSTUtil(Node node) {
        if (node == null) {
            return null;
        }

        Data leftData = largestBSTUtil(node.left);
        Data rightData = largestBSTUtil(node.right);
        
        if (leftData == null) {
            leftData = new Data(0, Integer.MIN_VALUE, Integer.MIN_VALUE);
        } 
        if (rightData == null) {
            rightData = new Data(0, Integer.MAX_VALUE, Integer.MAX_VALUE);
        }
        
        if (leftData.max < node.data && node.data < rightData.min) {
            // BST found under given node.
            return new Data(leftData.size + rightData.size + 1, Math.max(leftData.max, node.data), Math.min(rightData.min, node.data));
        } else {
            return new Data(Math.max(leftData.size, rightData.size), Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

    }

    public static void main(String[] args) {

        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(3);
        root.left.right = new Node(7);
        root.right.right = new Node(18);
        root.right.left = new Node(12);
        
        System.out.println("Largest BST = " + largestBST(root));

        Node root2 = new Node(10);  
        root2.left = new Node(5);
        root2.right = new Node(7);
        root2.left.left = new Node(3);
        root2.left.right = new Node(8);
        root2.left.left.right = new Node(4);
        root2.right.left = new Node(6);
        
        System.out.println("Largest BST = " + largestBST(root2));
    }


}
