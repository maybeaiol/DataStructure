package Heap;

import java.util.ArrayList;
import java.util.Arrays;

import Stack.stack;

public class MaxHeap<E extends Comparable<E>> {//最大堆的实现，底层以动态数组实现
	private ArrayList<E> arrayList;
	public MaxHeap() {
		arrayList=new ArrayList<>();
	}
	public MaxHeap(int capacity) {
		arrayList=new ArrayList<>(capacity);
	}
	public MaxHeap(E[] arr) {//任意数组整理成堆的形状，从最后一个非叶子节点siftdown
		arrayList=new ArrayList<>(Arrays.asList(arr));
		for(int i=parent(arrayList.size()-1);i>=0;i--) {
			siftDown(i);
		}
	}
	public int getSize() {
		return arrayList.size();
	}
	public boolean isEmpty() {
		return arrayList.isEmpty();
	}
	//返回完全二叉树数组表示中，一个索引所表示的元素的父亲结点的索引
	private int parent(int index) {
		if(index==0)
			throw new IllegalArgumentException("index0 does not have parent");
		return (index-1)/2;
	}
	private int leftChild(int index) {
		return index*2+1;
	}
	private int rightChild(int index) {
		return index*2+2;
	}
	//向堆中添加元素
	public void add(E e) {
		arrayList.add(e);
		siftUp(arrayList.size()-1);
	}
	private void siftUp(int k) {
		while(k>0&&arrayList.get(parent(k)).compareTo(arrayList.get(k))<0) {
			swap(parent(k), k);//交换两结点的值
			k=parent(k);
		}
	}
	private  void swap(int i,int j) {
		if(i<0||i>=arrayList.size()||j<0||j>=arrayList.size())
			throw new IllegalArgumentException("can not swap,index is illegal");
		E temp=arrayList.get(i);
		arrayList.set(i, arrayList.get(j));
		arrayList.set(j, temp);
	}
	public E findMax() {
		if(arrayList.size()==0)
			throw new IllegalArgumentException("can not findmax,when the heap is empty");
		return arrayList.get(0);
	}
	//取出堆中最大元素
	public E extractMax() {/*交换最后一个结点和首结点，然后删除末尾结点，将新的头结点
			与左右结点比较，与较大值交换*/
		E maxvalue=findMax();
	    swap(0,arrayList.size()-1);
	    arrayList.remove(arrayList.size()-1);
	    siftDown(0);
		return maxvalue;
	}
	private void siftDown(int k) {
		while(leftChild(k)<arrayList.size()) {
			int j=leftChild(k);
			if(j+1<arrayList.size()&&arrayList.get(j).compareTo(arrayList.get(j+1))<0) 
				 j=rightChild(k);//j为左右结点中的较大者的索引
			if(arrayList.get(k).compareTo(arrayList.get(j))>0)
				 break;
			swap(j, k);	 
			k=j;
		}
	}
	//取出最大元素，替换为e
	public E replace(E e) {
		E max=findMax();
		arrayList.set(0, e);
		siftDown(0);
		return max;
	}
	
	

}
