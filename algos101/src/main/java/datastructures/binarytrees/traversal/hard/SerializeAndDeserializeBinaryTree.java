package datastructures.binarytrees.traversal.hard;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

// https://takeuforward.org/data-structure/serialize-and-deserialize-a-binary-tree/

public class SerializeAndDeserializeBinaryTree {

    public static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static String serialize(Node root) {
        StringBuilder serializer = new StringBuilder();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node == null) {
                 if (serializer.length() == 0)
                    serializer.append("#");
                 else 
                    serializer.append(",#");
            } else {
                if (serializer.length() == 0)
                    serializer.append(node.data);
                else
                    serializer.append("," + node.data);
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return serializer.toString();
    }

    public static Node deserialize(String serializedData) {
        String[] dataArray = serializedData.split(",");
        if (dataArray == null || dataArray.length == 0) {
            return null;
        }
        // Child Index --> Parent Node
        Map<Integer, Node> childParentMap = new HashMap<>(); 
        Queue<Integer> queue = new LinkedList<>();
        
        Node root = null;
        queue.add(0);
        
        while (!queue.isEmpty()) {
            int index = queue.poll();
            String strVal = dataArray[index];
            Node node = null;
            if (!"#".equals(strVal)) {
                Integer data = Integer.parseInt(strVal);
                node = new Node(data);
            }
            
            if (root == null) {
                root = node;
            } else {
                Node parentNode = childParentMap.get(index);
                if (parentNode != null) {
                    boolean even = (index%2) == 0 ;
                    if (even)
                        parentNode.right = node;
                    else
                        parentNode.left = node;
                }
            }
            
            int leftChildIndex = leftChildIndex(index);
            int rightChildIndex = rightChildIndex(index);
            if (leftChildIndex < dataArray.length) {
                childParentMap.put(leftChildIndex, node);
                queue.add(leftChildIndex);
            }
            if (rightChildIndex < dataArray.length) {
                childParentMap.put(rightChildIndex, node);
                queue.add(rightChildIndex);
            }
            
        }
        return root;
       
    }

    private static int leftChildIndex(int parentIndex) {
        return (2 * parentIndex) + 1;
    }

    private static int rightChildIndex(int parentIndex) {
        return (2 * parentIndex) + 2;
    }

    public static void preOrderTraversal(Node root) {
        if(root == null) 
            return;
        System.out.print(root.data + ",");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);    
        root.right = new Node(3);    
        root.right.left = new Node(4);    
        root.right.right = new Node(5);

        String serialized = serialize(root);
        System.out.println("Serialized Tree = " + serialized);

        Node mainRoot = deserialize(serialized);
        System.out.println("/n === Deserialized ===");
        preOrderTraversal(mainRoot);


    }


}
