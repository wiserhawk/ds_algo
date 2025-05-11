package datastructures.binarytrees.traversal.hard;

//https://takeuforward.org/data-structure/check-for-children-sum-property-in-a-binary-tree/

public class ChildrenSumPropertyInBinaryTree {

    public static class Node {
        int data;
        Node left, right;
        
        public Node(int data) {
            this.data = data;
            left = right = null;
        } 
    }

    public static void changeToChildrenSumProperty(Node root) {
        if (root == null) {
            return;
        }
        changeTree(root);
    }

    private static int changeTree(Node node) {
        if (node == null) {
            return 0;
        }
        int leftVal = 0, rightVal = 0;
        if (node.left != null) {
            leftVal = changeTree(node.left);
        }
        if (node.right != null) {
            rightVal = changeTree(node.right);
        }
        int totalVal = leftVal + rightVal;
        
        if (totalVal == 0) {
            return node.data;
        } 
        node.data = totalVal;
        return totalVal;
    }

    public static void printInOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        printInOrderTraversal(root.left);
        System.out.print(root.data + " ");
        printInOrderTraversal(root.right);
    }


    public static void main(String[] args) {
        System.out.println("===============Example 1===========================");
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        changeToChildrenSumProperty(root);
        printInOrderTraversal(root);

        System.out.println("\n================Exmple 2==========================");

        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
        root1.left.right.right = new Node(9);
        root1.right.left = new Node(6);
        root1.right.right = new Node(7);
        changeToChildrenSumProperty(root1);
        printInOrderTraversal(root1);
    }

}
