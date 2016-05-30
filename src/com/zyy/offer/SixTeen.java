package com.zyy.offer;

import java.util.Stack;


public class SixTeen {

	public static void main(String[] args) {
		Node nod4 = new Node(4, null);
		Node nod3 = new Node(3, nod4);
		Node nod2 = new Node(2, nod3);
		Node nod1 = new Node(1, nod2);
		printList(nod1);
		Node nod = reverse(nod1);
		System.out.println("---------------");
		printList(nod);
	}

	public static void printList(Node node) {
		while (node != null) {
			System.out.print(node.getNode() + "\t");
			node = node.getNext();
		}
	}
	
	
	
	
	public static Node reverse(Node node){
		if(node ==null) return node;
		Node pReverseHead = null;  //新的 头结点
		Node current = node;	//当前结点
		Node next = null;		//当前结点的后面结点
		while(current!=null){
			Node pNext = current.getNext();
			if(pNext==null){
				pReverseHead = current;
			}

			current.setNext(next);
			next = current;
			current = pNext;
		}
		return pReverseHead;
		
		
/*		
		Node pre = node;
		Node current = node.getNext();
		Node next = current.getNext();
		while(next.getNext()!=null){
			current.setNext(pre);
			pre = current;
			current = next;
			next = next.getNext();
			
		}
		
		return null;*/
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
