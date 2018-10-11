package Queue;

import Arraylist.ArrayList;

public class ArrayQueue<E> implements Queue<E> {
	private ArrayList<E> array;
	 public ArrayQueue(int capacity) {
		array=new ArrayList<>(capacity);
	}
	 public ArrayQueue() {
			this(10);
		}

	@Override
	public void enqueue(E evalue) {
		try {
			array.insertlast(evalue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public E dequeue() {
		E value=null;
		try {
			value = array.getEle(0);
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		try {
			array.delete(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}

	@Override
	public E getFront() {
		E value=null;
		try {
			value = array.getEle(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}

	@Override
	public int Getsize() {
		return	array.getSize();
	
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return array.isEmpty();
	}
	@Override
	public String toString() {
		StringBuilder sBuilder=new StringBuilder();
		sBuilder.append("Queue:");
		sBuilder.append("front [");
		for(int i=0;i<array.getSize();i++) {
			try {
				sBuilder.append(array.getEle(i));
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(i!=array.getSize()-1) {
				sBuilder.append(',');
			}
			
		}
		sBuilder.append("] tali");
		return sBuilder.toString();
	}
}
