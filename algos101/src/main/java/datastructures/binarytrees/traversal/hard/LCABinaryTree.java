package datastructures.binarytrees.traversal.hard;

// LCA (Lowest Common Ancestor) for given two numbers in Tree. 
// LCA of two nodes in a binary tree is the lowest node in the tree that has both nodes as descendants.
// https://takeuforward.org/data-structure/lowest-common-ancestor-for-two-given-nodes/
// Explained here: https://www.youtube.com/watch?v=_-QHfMDde90

public class LCABinaryTree {

    public static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static Node lca(Node root, int first, int second) {
        if (root == null || root.data == first || root.data == second) {
            return root;
        }

        Node left = lca(root.left, first, second);
        Node right = lca(root.right, first, second);

        if (left == null ) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root; // found LCA node.
        }
    }
        
    

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Node lca = lca(root, 4, 5);
        System.out.println("LCA of 4 and 5 = " + lca.data);

        lca = lca(root, 4, 6);
        System.out.println("LCA of 4 and 6 = " + lca.data);

        lca = lca(root, 3, 4);
        System.out.println("LCA of 3 and 4 = " + lca.data);

        lca = lca(root, 2, 4);
        System.out.println("LCA of 2 and 4 = " + lca.data);

    }

}
