package datastructures.binarysearchtrees;

import redis.clients.jedis.search.querybuilder.Node;

// Insert new node in Binay Search Tree
// https://leetcode.com/problems/insert-into-a-binary-search-tree/
// Inseration explation: https://www.youtube.com/watch?v=LwpLXm3eb6A

// Delete a given node in Binay Search Tree
// https://leetcode.com/problems/delete-node-in-a-bst/
// Deletion explation: https://www.youtube.com/watch?v=kouxiP_H5WE


public class BinarySearchTreeOperations {

    public static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }


    public static void insertIntoBST(Node root, int data) {
        if (root == null) {
            return;
        }

        Node curr = root;
        while(curr != null) {
            if (curr.data == data) {
                return;
            }
            if (curr.data < data) {
                if (curr.right == null) {
                    curr.right = new Node(data);
                    return;
                }
                curr = curr.right;
            } else {
                if (curr.left == null) {
                    curr.left = new Node(data);
                    return;
                }
                curr = curr.left;
            }
        }
    }


    public static Node deleteNode(Node root, int data) {
        if (root == null) {
            return null;
        }

        if (root.data == data) {
            root = rearrangeChildNodes(root);
            return root;
        }

        Node curr = root;

        while (curr != null) {
            if (curr.data < data) {
                if (curr.right != null && curr.right.data == data) {
                    curr.right = rearrangeChildNodes(curr.right);
                    break;
                }
                curr = curr.right;
                
            } else {
                if (curr.left != null && curr.left.data == data) {
                    curr.left = rearrangeChildNodes(curr.left);
                    break;
                }
                curr = curr.left;  
            }
        }
        return root;
    }

    private static Node rearrangeChildNodes(Node node) {
        if (node.right != null) {
            Node leftNode = findLeftMostNode(node.right);
            leftNode.left = node.left;   
            return node.right;
        } else {
            return node.left;
        }


    }

    private static Node findLeftMostNode(Node node) {
        Node curr = node;
        while (curr != null) {
            if (curr.left != null) 
                curr = curr.left;
            else
                break;
        }
        return curr;
    }

    public static void printInOrder(Node root) {
        if (root == null) {
            return;
        }
        printInOrder(root.left);
        System.out.print(root.data + ",");
        printInOrder(root.right);

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

        System.out.println("### Insert New Node ###");
        insertIntoBST(root, 12);
        printInOrder(root);

        System.out.println("\n### Delete Node ###");
        Node newRoot = deleteNode(root, 10);
        printInOrder(newRoot);
        


    }

}
