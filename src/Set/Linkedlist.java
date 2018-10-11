package Set;

import javax.annotation.Resource;

import Stack.stack;

public class Linkedlist<E> {
	private class Node {
		public E e;
		public Node next;
		public Node(E e,Node next) {
			this.e=e;
			this.next=next;
		}
		public Node(E e) {
			this(e, null);
		}
		public Node() {
			this(null,null);
		}
		@Override 
		public String toString() {
			return e.toString();
		}
	}
	private Node dummyhead;
	private int size;
	public Linkedlist() {
		dummyhead=new Node(null,null);
		size=0;
	}
	public void removeElement(E e) {
		removeElement(e,dummyhead,-1);
		
	}
	int ssize;
	private void removeElement(E e,Node node,int size) {
		ssize=size;
		if(node==null) {
			return;
		}
		if(node.e!=e) {
			ssize++;
			removeElement(e,node.next,ssize);} 
		else
			try {
				delete(ssize);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
	}
	//
	public int GetSize(){
		return size;
	}
	public boolean isEmpty() {
		return size==0;
	}
	//链表头添加元素
	public void inserthead(E e) throws Exception {
//		Node node=new Node(e);
//		node.next=head;
//		head=node;
//		head=new Node(e,head);//优雅写法
//		size++;
		insert(e, 0);
	}
	public void insert(E e,int index) throws Exception {
		if(index<0||index>size) {
			throw new Exception("插入非法");
		}
	
		Node pre = dummyhead;
		for (int i = 0; i < index; i++) {
			pre = pre.next;
		}
		// Node node=new Node(e);
		// node.next=pre.next;
		// pre.next=node;
		pre.next = new Node(e, pre.next);
		size++;
		
	}
	public void insertlast(E e) throws Exception {
		this.insert(e,size);
	}
	public E Get(int index) throws Exception {
		if(index<0||index>=size) {
			throw new Exception("查询非法");
		}
		Node cur=dummyhead.next;
		for(int i=0;i<index;i++) {
			cur=cur.next;
		}
		return cur.e;
	}
	public E Getfirst() throws Exception {
		return Get(0);
	}
	public E Getlast() throws Exception{
		return Get(size-1);
	}
	public void Set(E e,int index) throws Exception {
		if(index<0||index>=size) {
			throw new Exception("查询非法");
		}
		Node cur=dummyhead.next;
		for(int i=0;i<index;i++) {
			cur=cur.next;
		}
		cur.e=e;
	}
	public boolean contains(E e) {
		Node cur=dummyhead.next;
		while(cur!=null) {
			if(cur.e.equals(e)) {
				return true;
			}
			cur=cur.next;
		}
		return false;
	}
	@Override
	public String toString() {
		StringBuilder sBuilder=new StringBuilder();
		Node cur =dummyhead.next;
		while(cur!=null) {
			sBuilder.append(cur+"---");
			cur=cur.next;
		}
		sBuilder.append("null");
		return sBuilder.toString();
	}
	public E delete(int index) throws Exception {
		if(index<0||index>=size) {
			throw new Exception("删除非法");
		}
		Node prev=dummyhead;
		for(int i=0;i<index;i++) {
			prev =prev.next;
		}
		Node ret=prev.next;
		prev.next=ret.next;
		ret.next=null;
		size--;
		return ret.e;
	}
	public E deleteFirst() throws Exception {
	   return delete(0);
	}
	public E deletelast() throws Exception {
		return delete(size-1);
	}

	
	
	
	
	
}
