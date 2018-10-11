package Set;

public class LinkedlistSet<E> implements Set<E> {
	private Linkedlist<E> list;
	public LinkedlistSet() {
	
		list=new Linkedlist<E>();
	}

	@Override
	public void add(E e) {
		
		if(!list.contains(e))
			try {
				list.inserthead(e);
			} catch (Exception e1) {

				e1.printStackTrace();
			}
		
	}

	@Override
	public void remove(E e) {
		list.removeElement(e);
		
	}

	@Override
	public boolean contains(E e) {
	
		return list.contains(e);
	}

	@Override
	public int getSize() {
	
		return list.GetSize();
	}

	@Override
	public boolean isEmpty() {
		
		return list.isEmpty();
	}
	
	public String toString() {
		return list.toString();
		
	}
	

}
