import java.util.ArrayList;
public class Linkedlist<E> {
	private class Node{
		public Node next;
		public E e;
		public Node(Node node,E e) {
			this.next=node;
			this.e=e;
		}
		public Node() {
			this(null, null);
		}
		public Node(Node node) {
			this(node,null);
		}
		public Node(E e) {
			this(null,e);
		}
	}
	private Node dummyhead;
	private int size;
	public Linkedlist() {
		dummyhead=new Node();
		size=0;
	}
	public  int getSize() {
		return size;
	}
	public boolean isEmpty() {
		return size==0;
	}
	public void insert(E e,int index) throws Exception {
		if(index<0||index>size) {
			throw new Exception("插入不合法");
		}
	     Node pre=dummyhead;
	     for(int i=0;i<index;i++) {
	    	 pre=pre.next;
	     }
	     pre.next=new Node(pre.next,e);
	     size++;
	}
	public E getElem(int index) throws Exception {
		if(index<0||index>=size) {
			throw new Exception("查询不合法");
		}
		Node cur=dummyhead.next;
		for(int i=0;i<index;i++) {
			cur=cur.next;
		}
		return cur.e;
	}
	public boolean contains(E e) {
		return contains(e,dummyhead.next);
	}
	private boolean contains(E e,Node node) {
		if(node==null)
			return false;
		if(node.e==e) {
			return true;
		}
		else {
			return contains(e,node.next);
		}
	}
	public E delete(int index) throws Exception {
		if(index<0||index>=size) {
			throw new Exception("删除不合法");
		}
		Node pre=dummyhead;
		for(int i=0;i<index;i++) {
			pre=pre.next;
		}
		Node delnode=pre.next;
		pre.next=pre.next.next;
		size--;
		return delnode.e;
	}
	public void delElement(E e) {
		dummyhead.next=delElement(e,dummyhead.next);
	}
	private Node delElement(E e,Node node) {
		if(node==null)
			return null;
		node.next=delElement(e, node.next);
		if(node.e==e) size--;
		return node.e==e?node.next:node;
	}
	@Override
	public String toString() {
		StringBuilder sBuilder=new StringBuilder();
		Node cur=dummyhead.next;
		while(cur!=null) {
			sBuilder.append(cur.e+"→");
			cur=cur.next;
		}
		return sBuilder.toString();
	}
	 public void reverseList() {
	        ArrayList<E> arrayList=new ArrayList<>();
	       
	        Node cur=dummyhead.next;
	        while(cur!=null) {
	        	arrayList.add(cur.e);
	        	cur=cur.next;
	        }
	        E[] array;
	        array=(E[]) new Object[arrayList.size()];
	        for(int i=0;i<arrayList.size();i++) {
	        	array[i]=arrayList.get(arrayList.size()-i-1);
	        }
	        cur=dummyhead.next;int i=0;
	        while(cur!=null) {
	        	cur.e=array[i];
	        	cur=cur.next;
	        	i++;
	        }
	        
	      
	 }
	
	

}
