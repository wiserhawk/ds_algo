package datastructures.linkedlist;

public class LinkedListOps {
	
	public static class Node {
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			next = null;
		}
		
	}
	
	Node header;
	
	// Insert at tail.
	public void insert(int data) {
		if (header == null)
			header = new Node(data);
		else {
			Node last = lastNode(header);
			last.next = new Node(data);
		}
				
	}
	
	// Delete given node.
	public void delete(int data) {
		if (header == null) 
			return;
		else {
			Node node = searchNode(header, data);
			Node next = node.next;
			node.data = next.data;
			node.next = next.next;
			next = null;
		}
	}
	
	// Insert at given index.
	public void insert(int index, int data) {
		if (header == null && index == 0) {
			header = new Node(data);
			return;
		} else {
			int i = 0;
			Node curr = header;
			while (curr != null) {
				if (i == index-1) {
					Node next = curr.next;
					curr.next = new Node(data);
					curr.next.next = next;
					return;
				}
				curr = curr.next;
				i++;
			}
		}
	}
	
	private Node lastNode(Node node) {
		if (node.next == null)
			return node;
		else
			return lastNode(node.next);
		
	}
	
	private Node searchNode(Node node, int data) {
		if (node == null) 
			return null;
		else {
			if (node.data == data)
				return node;
			else 
				return searchNode(node.next, data);
		}
	}
	
	public Node search(int data) {
		return searchNode(header, data);
	}
	
	public void printList() {
		Node current = header;
		while (current != null) {
			System.out.print(current.data + " -> ");
			current = current.next;
		}
		System.out.println("\n");
	}
	
	public static void main(String[] args) {
		LinkedListOps list = new LinkedListOps();
		list.insert(1);
		list.insert(2);
		list.insert(3);
		list.insert(4);
		list.insert(5); 
		list.insert(6);
		list.printList();
		
		// Delete a node.
		list.delete(4);
		list.printList();
		
		// Insert at given index.
		list.insert(3, 4);
		list.printList();
		
		// Search a element in list.
		Node node = list.search(4);
		System.out.println("Is Node found = " + ((node != null) ? true : false) );
		
	}
	
}
