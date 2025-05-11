package datastructures.binarysearchtrees;

// https://www.geeksforgeeks.org/construct-bst-from-given-preorder-traversa/


public class PreorderToBinarySearchTree {

    public static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Brute Force 
    // Preorder [Root -> Left -> Right]
    public static Node buildTree(int[] preorder) {
        if (preorder.length == 0) {
            return null;
        }
        Node root = null;
        for (int i = 0; i < preorder.length; i++) {
            root = buildTree(root, preorder, i);
        }
        return root;
    }

    private static Node buildTree(Node node, int[] preorder, int index) {
        Node root = null;
        if (node == null) {
            root = new Node(preorder[index]);
        } else {
            root = node;
            Node curr = root;
            int data = preorder[index];
            while (curr != null) {
                if (curr.data > data) {
                    if (curr.left == null) {
                        curr.left = new Node(data);
                        break;
                    } else {
                        curr = curr.left;
                    }
                } else {
                    if (curr.right == null) {
                        curr.right = new Node(data);
                        break;
                    } else {
                        curr = curr.right;
                    }
                }
            }
        }
        return root;
    }


    private static int index = 0;
    // Optimized Approach (Using Uppper Bound Approach)
    public static Node buildTreeOptimizally(int[] preorder) {
        // Reset Index;
        index = 0;
        if (preorder.length == 0) {
            return null;
        }
        Node root = buildTreeRecursively(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return root;
    }

    private static Node buildTreeRecursively(int[] preorder, int minRange, int maxRange) { 
        if (index >= preorder.length) {
            return null;
        }

        int value = preorder[index];
        if (value <= minRange || value >= maxRange) {
            return null;
        }

        Node root = new Node(value);
        index++;
        root.left = buildTreeRecursively(preorder, minRange, value);
        root.right = buildTreeRecursively(preorder, value, maxRange);
        return root;
       
    }
    
    public static String traversePreOrderString(Node root) {
        if (root == null) {
            return "";
        }
        return root.data + " " + traversePreOrderString(root.left) + traversePreOrderString(root.right);
    }

    public static void main(String[] args) {
        int[] preorder = new int[] {8, 5, 1, 7, 10, 12};

        Node root = buildTree(preorder);
        System.out.println("Brute Force = " + traversePreOrderString(root));

        root = buildTreeOptimizally(preorder);
        System.out.println("Optimized = " + traversePreOrderString(root));

        preorder = new int[] {10, 5, 1, 7, 12, 11};
        root = buildTree(preorder);
        System.out.println("Brute Force = " + traversePreOrderString(root));

        root = buildTreeOptimizally(preorder);
        System.out.println("Optimized = " + traversePreOrderString(root));

    }

}
