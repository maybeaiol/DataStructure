package Queue;


public class LinkedlistQueue<E> implements Queue<E>{
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
	private Node head,tail;
	private int size;
	public LinkedlistQueue() {
		head=tail=null;
		size=0;
	}
	@Override
	public void enqueue(E evalue) {
		if(tail==null) {
			tail=new Node(evalue);
			head=tail;
		}
		else {
			tail.next=new Node(evalue);
			tail=tail.next;
		}
		size++;
		
	}

	@Override
	public E dequeue() {
		if(isEmpty()) {
			try {
				throw new Exception("mirro");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Node rev=head;
		head=rev.next;
		if(head==null) {
			tail=null;
		}
		size--;
		return rev.e;
	}

	@Override
	public E getFront() {
		if(isEmpty()) {
			try {
				throw new Exception("mirro");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return head.e;
	}

	@Override
	public int Getsize() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size==0;
	}
	@Override
	public String toString() {
		StringBuilder sBuilder=new StringBuilder();
		sBuilder.append("Queue:front");
		Node node=head;
		while(node!=null) {
			sBuilder.append(node+"---");
			node=node.next;
		}
		sBuilder.append("null tail");
		return sBuilder.toString();
	}

}
