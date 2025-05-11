package datastructures.binarysearchtrees;

// https://takeuforward.org/binary-search-tree/ceil-in-a-binary-search-tree/
// https://takeuforward.org/binary-search-tree/floor-in-a-binary-search-tree/

public class FloorAndCeilingInBinarySearchTree {

    public static class  Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static Node findCeiling(Node root, int key) {
        if (root == null) {
            return null;
        }
        Node ceiling = null;
        Node curr = root;
        while (curr != null) {
            if (curr.data == key) {
                ceiling = curr;
                return ceiling;
            }

            if (curr.data < key) {
                curr = curr.right;
            } else {
                ceiling = curr;
                curr = curr.left;
            }
        }
        return ceiling;
    }

    public static Node findFloor(Node root, int key) {
        if (root == null) {
            return null;
        }
        Node ceiling = null;
        Node curr = root;
        while (curr != null) {
            if (curr.data == key) {
                ceiling = curr;
                return ceiling;
            }
            
            if (curr.data < key) {
                ceiling = curr;
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        return ceiling;
        
    }


    public static void main(String[] args) {

        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(13);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.left.left.left = new Node(1);
        root.right.left = new Node(11);
        root.right.right = new Node(15);    
        root.right.right.left = new Node(14);
        
        System.out.println("Ceiling = " + findCeiling(root, 4).data);
        System.out.println("Floor = " + findFloor(root, 4).data);
    }


}
