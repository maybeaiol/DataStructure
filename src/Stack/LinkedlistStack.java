package Stack;

public class LinkedlistStack<E> implements stack<E> {
	private Linkedlist linkedlist;
	public LinkedlistStack() {
		linkedlist=new Linkedlist<>();
	}
	@Override
	public void push(E e) {
		try {
			linkedlist.inserthead(e);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public E pop() {
	E value=null;
		
	try {
		value=  (E) linkedlist.deleteFirst();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return value;
	
	}

	@Override
	public E peek() {
		E value = null;
		try {
			value = (E) linkedlist.Get(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}

	@Override
	public int getSize() {
		
		return linkedlist.GetSize();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return linkedlist.isEmpty();
	}
	@Override
	public String toString() {
		StringBuilder sBuilder=new StringBuilder();
		sBuilder.append("stack:top");
		sBuilder.append(linkedlist);
		return sBuilder.toString();
	}
	

}
