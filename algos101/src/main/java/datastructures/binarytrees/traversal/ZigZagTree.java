package datastructures.binarytrees.traversal;

import java.util.Stack;

/*
 * Print tree nodes as zig zap form.
 */

//Java implementation of a O(n) time  
//method for Zigzag order traversal 
public class ZigZagTree {

	// Binary Tree node
	class Node {
		int data;
		Node leftChild;
		Node rightChild;

		Node(int data) {
			this.data = data;
		}
	}

	Node rootNode;

	// function to print the
	// zigzag traversal
	void printZigZagTraversal() {
		// if null then return
		if (rootNode == null) {
			return;
		}
		// declare two stacks
		Stack<Node> currentLevel = new Stack<>();
		Stack<Node> nextLevel = new Stack<>();
		// push the root
		currentLevel.push(rootNode);
		boolean leftToRight = true;
		// check if stack is empty
		while (!currentLevel.isEmpty()) {
			// pop out of stack
			Node node = currentLevel.pop();
			// print the data in it
			System.out.print(node.data + " ");
			// store data according to current
			// order.
			if (leftToRight) {
				if (node.leftChild != null) {
					nextLevel.push(node.leftChild);
				}
				if (node.rightChild != null) {
					nextLevel.push(node.rightChild);
				}
			} else {
				if (node.rightChild != null) {
					nextLevel.push(node.rightChild);
				}
				if (node.leftChild != null) {
					nextLevel.push(node.leftChild);
				}
			}

			if (currentLevel.isEmpty()) {
				leftToRight = !leftToRight;
				Stack<Node> temp = currentLevel;
				currentLevel = nextLevel;
				nextLevel = temp;
			}
		}
	}

	
	public static void main(String[] args) {
		ZigZagTree tree = new ZigZagTree();
		tree.rootNode = tree.new Node(1);
		tree.rootNode.leftChild = tree.new Node(2);
		tree.rootNode.rightChild = tree.new Node(3);
		tree.rootNode.leftChild.leftChild = tree.new Node(7);
		tree.rootNode.leftChild.rightChild = tree.new Node(6);
		tree.rootNode.rightChild.leftChild = tree.new Node(5);
		tree.rootNode.rightChild.rightChild = tree.new Node(4);

		System.out.println("ZigZag Order traversal of binary tree is");
		tree.printZigZagTraversal();
	}

}
