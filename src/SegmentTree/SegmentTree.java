package SegmentTree;

import javax.management.Query;

public class SegmentTree<E> {
	private E[] data;//存放数值，例如[0,7]
	private E[] tree;//存放树结点值，设置为data的4倍大小
	private Merger<E> merger;
	public SegmentTree(E[] arr,Merger<E> merger) {
		this.merger=merger;
		data=(E[])new Object[arr.length];
		for(int i=0;i<data.length;i++) {
			data[i]=arr[i];
		}
		tree=(E[])new Object[4*arr.length];
		builderSegmentTree(0, 0, data.length-1);
	}
	//在treeindex位置创建表示区间【l。。。r】的线段树
	private void builderSegmentTree(int treeIndex,int l,int r) {//l.r表示左右端点
		if(l==r) {
			tree[treeIndex]=data[l];
			return;
		}
		int leftTreeIndex=leftChild(treeIndex);
		int rightTreeIndex=rightChild(treeIndex);
		
		int mid=l+(r-l)/2;
		builderSegmentTree(leftTreeIndex, l, mid);
		builderSegmentTree(rightTreeIndex, mid+1, r);
		
		tree[treeIndex]= merger.merge(tree[leftTreeIndex],tree[rightTreeIndex]);
	}
	public E get(int index) {
		if(index<0||index>=data.length)
			throw new IllegalArgumentException("index no limit");
		return data[index];
	}
	private int leftChild(int index) {
		return 2*index+1;
	}
	private int rightChild(int index) {
		return 2*index+2;
	}
	//查询操作
	public E Query(int queryL,int queryR) {
		if(queryL<0||queryR>=data.length||queryR<0||queryR>=data.length||queryL>queryR) {
			throw new IllegalArgumentException("index is illegal");
		}
		return Query(0, 0,data.length-1,queryL,queryR);
	}
	//在以treeindex为根的线段树[l,r]的范围里，搜索区间[queryL,queryR]的值
	private E Query(int treeIndex,int l,int r,int queryL,int queryR) {
		if(l==queryL&&r==queryR) {
			return tree[treeIndex];
		}
		int leftTreeIndex=leftChild(treeIndex);
		int rightTreeIndex=rightChild(treeIndex);
		int mid=l+(r-l)/2;
		
		if(queryR<=mid)
			return Query(leftTreeIndex, l, mid, queryL, queryR);
		else if(queryL>mid)
			return Query(rightTreeIndex, mid+1, r, queryL, queryR);
		else {
			E leftResult=Query(leftTreeIndex, l, mid, queryL, mid);
			E rightResult=Query(rightTreeIndex, mid+1, r, mid+1, queryR);
			return merger.merge(leftResult, rightResult);
		}
	}
	//在以treeindex为根的线段树中更新index的值为e
	private void set(int treeIndex,int l,int r,int index,E e) {
		if(l==r) {
			tree[treeIndex]=e;
			return;
		}
		int leftindex=leftChild(treeIndex);
		int rightindex=rightChild(treeIndex);
		int mid=l+(r-l)/2;
		if(index>=mid+1)
			set(rightindex, mid+1, r, index, e);
		else
			set(leftindex, l, mid, index, e);
		tree[treeIndex]=merger.merge(tree[leftindex], tree[rightindex]);
	}
	@Override
	public String toString() {
		StringBuilder sBuilder=new StringBuilder();
		sBuilder.append('[');
		for(int i=0;i<tree.length;i++) {
			if(tree[i]!=null)
				sBuilder.append(tree[i]);
			else
				sBuilder.append("null");
			if(i==tree.length-1)
				sBuilder.append(']');
		}
		return sBuilder.toString();
	}	
}
