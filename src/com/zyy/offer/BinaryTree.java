package com.zyy.offer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

	public static void main(String[] args) {
/*
		TreeNode node7 = new TreeNode(7);
		TreeNode node6 = new TreeNode(6);
		TreeNode node4 = new TreeNode(4);

		TreeNode node3 = new TreeNode(3);
		node3.setRightNode(node7);
		TreeNode node5 = new TreeNode(5, node6);
		TreeNode node2 = new TreeNode(2, node4, node5);
		TreeNode node1 = new TreeNode(1, node2, node3);

		// preOrderRecurseTraverse(node1);
		// System.out.println();
		// inOrderRecurseTraverse(node1);
		// System.out.println();
		 postOrderRecurseTraverse(node1);
		// System.out.println();
//		 inOrderTraverse(node1);
		// preOrderTraverseOne(node1);
//		 preOrderTraverseTwo(node1);
		// leveOrderTraverse(node1);
//		postOrderTraverse(node1);
		 System.out.println();
		 lastOrder(node1);
		 */

	}
	

	
	public static void preOrder(TreeNode node){
		if(node!=null){
			System.out.print(node.getValue() + "\t");
			preOrder(node.getLeftNode());
			preOrder(node.getRightNode());
		}
	}
	
	
	public static void midOrder(TreeNode node ){
		if(node!=null){
			midOrder(node.getLeftNode());
			System.out.print(node.getValue() + "\t");			
			midOrder(node.getRightNode());
		}
	}
	
	
	public static void lastOrder(TreeNode node ){
		if(node!=null){
			lastOrder(node.getLeftNode());
			lastOrder(node.getRightNode());
			System.out.print(node.getValue() + "\t");	
		}
	}
	
	
	
	
	

	public static void preOrderRecurseTraverse(TreeNode node) {
		if (node != null) {
			System.out.print(node.getValue() + "\t");
			BinaryTree.preOrderRecurseTraverse(node.getLeftNode());
			BinaryTree.preOrderRecurseTraverse(node.getRightNode());
		}
	}

	public static void inOrderRecurseTraverse(TreeNode node) {
		if (node != null) {
			BinaryTree.inOrderRecurseTraverse(node.getLeftNode());
			System.out.print(node.getValue() + "\t");
			BinaryTree.inOrderRecurseTraverse(node.getRightNode());
		}
	}

	public static void postOrderRecurseTraverse(TreeNode node) {
		if (node != null) {
			BinaryTree.postOrderRecurseTraverse(node.getLeftNode());
			BinaryTree.postOrderRecurseTraverse(node.getRightNode());
			System.out.print(node.getValue() + "\t");
		}
	}

	/**
	 * 先序遍历：方法一
	 */
	public static void preOrderTraverseOne(TreeNode node) {
		if (node != null) {
			Stack<TreeNode> stack = new Stack<TreeNode>();
			stack.push(node);
			while (stack.size() > 0) {
				TreeNode nod1 = stack.pop();
				System.out.print(nod1.getValue() + "\t");
				if (nod1.getRightNode() != null) {
					stack.push(nod1.getRightNode());
				}
				if (nod1.getLeftNode() != null) {
					stack.push(nod1.getLeftNode());
				}
			}
		}
	}

	/**
	 * 先序遍历：方法二
	 */
	public static void preOrderTraverseTwo(TreeNode node) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (node != null || stack.size() > 0) {
			while (node != null) {
				System.out.print(node.getValue() + "\t");
				stack.push(node);
				node = node.getLeftNode();
			}
			if (stack.size() > 0) {
				TreeNode nod = stack.pop();
				node = nod.getRightNode();
			}

		}

	}

	/**
	 * 中序遍历
	 */
	public static void inOrderTraverse(TreeNode p) {
		TreeNode node = p;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (node != null || stack.size() > 0) {
			while (node != null) {
				stack.push(node);
				node = node.getLeftNode();
			}
			if (stack.size() > 0) {
				TreeNode nod = (TreeNode) stack.pop();
				System.out.print(nod.getValue() + "\t");
				node = nod.getRightNode();
			}

		}

	}

	/**
	 * 后序
	 */
	public static void postOrderTraverse(TreeNode node) {
		TreeNode prev = node;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (node != null || stack.size() > 0) {
			while (node != null) {
				stack.push(node);
				node = node.getLeftNode();
			}
			if (stack.size() > 0) {
				TreeNode top1 = stack.peek().getRightNode();
				if (top1 == null | top1 == prev) {
					TreeNode n = stack.pop();
					System.out.print(n.getValue() + "\t");
					prev = n;
					node = null;
				} else {
					node = top1;
				}
			}
		}
	}

	public static void leveOrderTraverse(TreeNode node) {
		if (node != null) {
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			queue.add(node);
			while (queue.size() > 0) {
				TreeNode nod = queue.remove();
				System.out.print(nod.getValue() + "\t");
				if (nod.getLeftNode() != null) {
					queue.add(nod.getLeftNode());
				}
				if (nod.getRightNode() != null) {
					queue.add(nod.getRightNode());
				}
			}
		}
	}

	public static TreeNode createBinaryTree() {
		return null;
	}
	
	

}


class TreeNode {

	private int value;

	private TreeNode leftNode;

	private TreeNode rightNode;

	public TreeNode() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TreeNode(int value) {
		super();
		this.value = value;
	}

	public TreeNode(int value, TreeNode leftNode) {
		super();
		this.value = value;
		this.leftNode = leftNode;
	}

	public TreeNode(int value, TreeNode leftNode, TreeNode rightNode) {
		super();
		this.value = value;
		this.leftNode = leftNode;
		this.rightNode = rightNode;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public TreeNode getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(TreeNode leftNode) {
		this.leftNode = leftNode;
	}

	public TreeNode getRightNode() {
		return rightNode;
	}

	public void setRightNode(TreeNode rightNode) {
		this.rightNode = rightNode;
	}

}