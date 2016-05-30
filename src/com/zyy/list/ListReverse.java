package com.zyy.list;

import java.util.Stack;

/**
 * @author:zyy
 * @算法名称:链表反转
 * @基本思路:</br>
 * 
 */
public class ListReverse {

	public static void main(String[] args) {
		Node nod4 = new Node(4, null);
		Node nod3 = new Node(3, nod4);
		Node nod2 = new Node(2, nod3);
		Node nod1 = new Node(1, nod2);
		printList(nod1);
		Node nod = reverseList(nod1);
		System.out.println("---------------");
		printList(nod);
	}

	public static void printList(Node node) {
		while (node != null) {
			System.out.print(node.getNode() + "\t");
			node = node.getNext();
		}
	}

	public static Node reverseList(Node node) {
		if (node == null)
			return null;
		Node result = null;
		Stack<Node> stack = new Stack<Node>();
		while (node.getNext() != null) {
			stack.push(node);
			node = node.getNext();
		}
		result = node;
		while (stack.size() > 0) { // 取对象
			Node nod = stack.pop();
			node.setNext(nod);
			node = nod;
		}
		node.setNext(null);
		return result;
	}
}

class Node {
	private int node;

	private Node next;

	public Node(int node, Node next) {
		super();
		this.node = node;
		this.next = next;
	}

	public int getNode() {
		return node;
	}

	public void setNode(int node) {
		this.node = node;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

}
