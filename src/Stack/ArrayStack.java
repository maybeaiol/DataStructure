package Stack;

import Arraylist.ArrayList;

public class ArrayStack<E> implements stack<E> {
	//private int capacity;
	private ArrayList<E> aList;
	private int size;
	
	public  ArrayStack(int capacity) {
		
		aList=new ArrayList<>(capacity);
		size=0;
	}
	public ArrayStack() {
			this(10);
	}
	@Override
	public void push(E e) {
		try {
			aList.insertlast(e);
			size++;
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	@Override
	public E pop() {
		E result=null;
		try {
	    result=	aList.delete(size-1);
			size--;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public E peek() {
		E result=null;
		try {
			 result=aList.getEle(size-1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public E getelem(int index) throws Exception {
		return aList.getEle(index);
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size==0;
	}
	
	

}
