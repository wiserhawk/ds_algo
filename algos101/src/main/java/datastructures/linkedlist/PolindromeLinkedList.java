package datastructures.linkedlist;

import java.util.Stack;

import datastructures.linkedlist.LinkedListOps.Node;

public class PolindromeLinkedList {
	

	public static class Node {
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			next = null;
		}
		
	}
	
	Node header;
	
	public boolean checkPolindrome() {
		
		if (header == null) return false;
		Stack<Integer> stack = new Stack<Integer>();
		Node curr = header;
		while (curr != null) {
			stack.add(curr.data);
			curr = curr.next;
		}
		
		curr = header;
		while (curr != null) {
			if (stack.pop() != curr.data)
				return false;
			curr = curr.next;
		}
		
		return true;
	}

	public static void main(String[] args) {
		PolindromeLinkedList list = new PolindromeLinkedList();
		list.header = new Node(1);
		list.header.next = new Node(2);
		list.header.next.next = new Node(2);
		list.header.next.next.next = new Node(1);
		
		boolean isPolindrome = list.checkPolindrome();
		System.out.println("Is Polindrome = " + isPolindrome);
	}

}
