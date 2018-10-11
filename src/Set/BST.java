package Set;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST<E extends Comparable<E>> {
	private class Node {
		private E e;
		private Node left;
		private Node right;

		public Node(E e) {
			this.e = e;
			left = null;
			right = null;
		}
	}

	private Node root;
	private int size;

	public BST() {
		root = null;
		size = 0;
	}

	public int size() {
		return size;
	}

	public boolean IsEmpty() {
		return size == 0;
	}

	public void insert(E e) {
		root = add(root, e);
	}

	// 第一种方法
	private void insert(Node node, E e) {
		if (e.equals(node.e)) {
			return;
		} else if (e.compareTo(node.e) < 0 && node.left == null) {
			node.left = new Node(e);
			size++;
			return;
		} else if (e.compareTo(node.e) > 0 && node.right == null) {
			node.right = new Node(e);
			size++;
			return;
		}
		if (e.compareTo(node.e) < 0) {
			insert(node.left, e);
		} else {// e.compareTo(node.e) > 0
			insert(node.right, e);
		}

	}

	// 第二种方法,递归
	private Node add(Node node, E e) {
		//终止条件
		if (node == null) {
			size++;
			return new Node(e);
		}
		//
		if (e.compareTo(node.e) < 0) {
			node.left = add(node.left, e);//算法
		} else if (e.compareTo(node.e) > 0) {
			node.right = add(node.right, e);
		}
		return node;
	}
	

	public boolean contains(E e) {
		return contains(root, e);
	}

	private boolean contains(Node node, E e) {
		if (node == null) {// 终止条件
			return false;
		}

		if (e.equals(node.e)) {
			return true;
		} else if (e.compareTo(node.e) < 0) {
			return contains(node.left, e);
		} else {// e.compareTo(node.e)>0
			return contains(node.right, e);
		}
	}
	//求二分搜索树的最小元素
	public E minimum() {
		if (size == 0)
			throw new IllegalArgumentException("BST is empty");
		return minimum(root).e;
	}
	private Node minimum(Node node) {
		if(node.left==null) 
			return node;

		return minimum(node.left);
	}
	//从二分搜索树中删除最小值所在节点，返回最小值
	public E removeMin() {
		E ret=minimum();
	    root=removeMin(root);
		return ret;
	}
	///从二分搜索树中删除最小值所在节点,返回删除节点后新的二分搜索树的根
	private Node removeMin(Node node) {
		if(node.left==null) {
			Node rightNode=node.right;
			node.right=null;
			size--;
			return rightNode;
		}
		
		node.left=removeMin(node.left);
		return node;
		
	}

	// 求二分搜索树的最大元素
	public E maximum() {
		if (size == 0)
			throw new IllegalArgumentException("BST is empty");
		return maximum(root).e;
	}
	private Node maximum(Node node) {
		if (node.right == null)
			return node;

		return maximum(node.right);
	}
	//从二分搜索树中删除最大值所在节点，返回最大值
	public E removeMax() {
		E max=maximum();
	   root=removeMax(root);
		return max;
	}
	///从二分搜索树中删除最大值所在节点,返回删除节点后新的二分搜索树的根
	private Node removeMax(Node node) {
		if(node.right==null) {
			Node leftnode=node.right;
			node.right=null;
			size--;
			return leftnode;
		}
		node.right=removeMax(node.right);
		return node;
	}
	//删除二分搜索树中的任意结点
	public void remove(E e) {
      root=	remove(root,e);
		
	}
	private Node remove(Node node,E e) {
		if (node == null)
			return null;
		if (e.compareTo(e) < 0) {
			node.left = remove(node.left, e);
			return node;
		} else if (e.compareTo(e) > 0) {
			node.right = remove(node.right, e);
			return node;
		} else {// e==node.e
			if (node.left == null) {
				Node rightnode = node.right;
				node.right = null;
				size--;
				return rightnode;
			}
			if (node.right == null) {
				Node leftnode = node.left;
				node.left = null;
				size--;
				return leftnode;
			}
			Node successor = minimum(node.right);
			successor.right = removeMin(node.right);
			successor.left = node.left;
			node.left=node.right=null;

			return successor;

		}
	}
	
	
	
	//二分搜索树的层序遍历，利用队列
	public void levelOrder() {
		Queue<Node> queue=new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			Node cur=queue.poll();
			System.out.println(cur.e);
			if(cur.left!=null)
				queue.offer(cur.left);
			if(cur.right!=null) 
				queue.offer(cur.right);
		}
	}

	// 前序遍历
	public void preOrder() {
		preOrder(root);
	}

	// 前序遍历以node为跟的二叉树，递归算法
	private void preOrder(Node node) {
		//终止条件
		if (node == null) {
			return;
		}
		
		
		System.out.println(node.e);
		preOrder(node.left);
		preOrder(node.right);
	}
	//前序遍历的非递归写法,使用栈
	public void preOrderNR() {
		Stack<Node> stack=new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			Node nownode=stack.pop();
			System.out.print(nownode.e+" ");
			if(nownode.right!=null)
			   stack.push(nownode.right);
			if(nownode.left!=null)
				stack.push(nownode.left);
		}
	}

	// 中序遍历,顺序排列
	public void inOrder() {
		inOrder(root);
	}

	private void inOrder(Node node) {
		if (node == null) {
			return;
		}
		inOrder(node.left);
		System.out.println(node.e);
		inOrder(node.right);
	}

	// 后序遍历
	public void postOrder() {
		postOrder(root);
	}

	private void postOrder(Node node) {
		if (node == null) {
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.e);
	}

	@Override
	public String toString() {
		StringBuilder sBuilder = new StringBuilder();
		GennerateString(root, 0, sBuilder);
		return sBuilder.toString();
	}

	private void GennerateString(Node node, int depth, StringBuilder res) {
		if (node == null) {
			res.append(generateDepthstring(depth) + "null\n");
			return;
		}
		res.append(generateDepthstring(depth) + node.e + "\n");
		GennerateString(node.left, depth + 1, res);
		GennerateString(node.right, depth + 1, res);

	}

	private String generateDepthstring(int depth) {
		StringBuilder sbBuilder = new StringBuilder();
		for (int i = 0; i < depth; i++) {
			sbBuilder.append("--");
		}
		return sbBuilder.toString();
	}
	
}
