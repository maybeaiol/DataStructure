package Map;

import javax.xml.soap.Node;

public class LinkedlistMap<K,V> implements Map<K, V> {
	private class Node{
		public Node next;
		public K key;
		public V value;
		public Node(Node next,K key,V value) {
			this.next=next;
			this.key=key;
			this.value=value;
		}
		public Node(K key) {
			this(null, key, null);
		}
		public Node() {
			this(null,null,null);
		}
		@Override
		public String toString() {
			return key.toString()+":"+value.toString();
		}
	}
	private Node dummyNode;
	private int size;
	public LinkedlistMap() {
		dummyNode=new Node();
		size=0;
	}
	private Node getNode(K key) {
		Node cur=dummyNode.next;
		while(cur!=null) {
			if(cur.key.equals(key))
				return cur;
			else
				cur=cur.next;
		}
		return null;
	}

	@Override
	public void add(K key, V value) {
		Node node=getNode(key);
		if(node==null) {
			dummyNode.next=new Node(dummyNode.next,key,value);
			size++;
		}
		else
			node.value=value;
	}

	@Override
	public V remove(K key) {
		Node node=getNode(key);
		if(node!=null) {
			Node pre=dummyNode;
			while(pre.next!=node) {
				pre=pre.next;
			}
			pre.next=pre.next.next;
			size--;
		}
		return node.value;
		
	}

	@Override
	public boolean contains(K key) {
	
		return getNode(key)!=null;
	}

	@Override
	public V get(K key) {
		Node node=getNode(key);
		return  node==null?null:node.value;
	}

	@Override
	public void set(K key, V value) {
		Node node=getNode(key);
		if(node!=null) {
			node.value=value;
		}
		else
			throw new IllegalArgumentException(key+"does not exist!");
	}

	@Override
	public int getSize() {
	
		return size;
	}

	@Override
	public boolean isEmpty() {
	
		return size==0;
	}
	@Override
	public String toString() {
		StringBuilder sBuilder=new StringBuilder();
		Node cur=dummyNode.next;
		while(cur!=null) {
			sBuilder.append(cur.key.toString()+":"+cur.value.toString()+" ");
			cur=cur.next;
		}
		return sBuilder.toString();
	}
	

}
