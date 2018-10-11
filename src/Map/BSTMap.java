package Map;

import java.awt.RenderingHints.Key;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

public class BSTMap<K extends Comparable<K>,V>implements Map<K, V> {
	private class Node{
		public Node left;
		public Node right;
		public K key;
		public V value;
		public Node(K key,V value) {
			left=right=null;
			this.key=key;
			this.value=value;
		}
	}
	private Node root;
	private int size;
	public BSTMap() {
		root=null;
		size=0;
	}
	@Override
	public void add(K key, V value) {
	  root=	add(root, key,value);
	}
	private Node add(Node node,K key,V value) {
		if(node==null) {
			size++;
		    return new Node(key, value);
		}
		if(node.key.compareTo(key)>0) {
			node.left=add(node.left, key, value);
		}
		else if(node.key.compareTo(key)<0) {
			node.right=add(node.right, key, value);
		}
		else {
			node.value=value;
		}
		return node;
	}

	@Override
	public V remove(K key) {
		Node node=get(key, root);
		if(node!=null) {
			root=remove(key, root);
			return node.value;
		}
		return null;
	}
	private Node remove(K key,Node node) {
		if(node==null) {
			return null;
		}
		if(key.compareTo(node.key)<0) {
			node.left=remove(key, node.left);
			return node;
		}
		else if(key.compareTo(node.key)>0) {
			node.right=remove(key, node.right);
			return node;
		}
		else {//key.compareTo(node.key)=0
			if(node.left==null) {
				Node noderight=node.right;
				node.right=null;
				size--;
				return noderight;
			}
			else if(node.right==null) {
				Node nodeleft=node.left;
				node.left=null;
				size--;
				return nodeleft;
			}
			else {
				Node rightmin=getMinnode(node.right);
				rightmin.right=delMinnode(node.right);
				rightmin.left=node.left;
				node.left=node.right=null;
				return rightmin;
			}
		}
	}
	private Node getMinnode(Node node) {
		if(node.left==null)
			return node;
		return getMinnode(node.left);
	}
	private Node delMinnode(Node node) {
		if(node.left.left==null) {
			 node.left=null;
			 return node;
		}
		node.left= delMinnode(node.left);
		size--;
		return node;
	}
	public void preOrder() {
		preOrder(root);
	}
	private void preOrder(Node node) {
		if(node==null)
			return;
		System.out.println(node.key+":"+node.value);
		preOrder(node.left);
		preOrder(node.right);
	}
	public void setOrder() {
		setOrder(root);
	}
	private void setOrder(Node node) {
		if(node==null)
			return;
		System.out.println(node.key);
		setOrder(node.left);
		setOrder(node.right);
	}
	

	@Override
	public boolean contains(K key) {
		
		return get(key,root)!=null;
	}

	@Override
	public V get(K key) {
		
		Node node= get(key, root);
		return node==null?null:node.value;
	}
	private Node get(K key,Node node) {
		if(node==null) {
			return null;
		}
		if(node.key.equals(key)) {
			return node;
		}
		else if(node.key.compareTo(key)>0) {
			return get(key, node.left);
		}
		else {
			return get(key, node.right);
		}
	}

	@Override
	public void set(K key, V value) {
		Node rec=get(key,root);
		if(rec==null) {
			try {
				throw new Exception(key.toString()+":"+"does not exist");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		rec.value=value;
	}
	@Override
	public String toString() {
		return null;
	}
	@Override
	public int getSize() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}

}
