package Arraylist;

public class ArrayList<E> {
	private int size;
	private E[] elemlist;
	public ArrayList(int capacity){
		elemlist=(E[]) new Object[capacity];
		size=0;
	}
	public ArrayList() {
		this(10);
	}
	public int getCap() {
		return elemlist.length; 
	}
	public int getSize() {
		return size;
	}
	public boolean isEmpty() {
		return size==0;
	}
	public void insertlast(E value) throws Exception{
		insert(value, size);

	}
	public void insertfiest(E value) throws Exception{
		insert(value, 0);

	}
	public void insert(E value,int index) throws Exception{
		if(index<0||index>size) {
			throw new Exception("插入不合法");
		}
	   if(size==elemlist.length) {
			resize(2*elemlist.length);
		}
	
		for (int i = size - 1; i >= index; i--) {
			elemlist[i + 1] = elemlist[i];
		}
		elemlist[index] = value;
		size++;
		
	}
	public E delete(int index) throws Exception {
		
		if(index<0||index>=size) {
			throw new Exception("删除不合法");
		}
		E result=elemlist[index];
		for(int j= index;j<size-1;j++) {
			elemlist[j]=elemlist[j+1];
		}
		size--;
		if(size==elemlist.length/3) {
			resize(elemlist.length/2);
		}
		return result;
	}
	public void updata(int index,E value) throws Exception {
		if(index<0||index>=size) {
			throw new Exception("修改不合法");
		}
		elemlist[index]=value;
	}
	public E getEle(int index) throws Exception {
		if(index<0||index>=size) {
			throw new Exception("查找不合法");
		}
		return elemlist[index];
	}
	private void resize(int newcapacity) {
		E[] newElem=(E[]) new Object[newcapacity];
		for(int i=0;i<size;i++) {
			newElem[i]=elemlist[i];
		}
		elemlist=newElem;
	}

}
