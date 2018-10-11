package SegmentTree;

public class NumArray {
	private int[] num;
	private int[] tree;
	public NumArray(int[] nums) {
		if(nums.length>0) {
		num=new int[nums.length];
		for(int i=0;i<nums.length;i++) {
			num[i]=nums[i];
		}
		tree=new int[4*nums.length];
		//在treeindex位置创建表示区间【l。。。r】的线段树
		GenerateTree(0, 0, num.length-1);
		}
	}
	private void GenerateTree(int treeindex,int l, int r) {
		if(l==r) {
			tree[treeindex]=num[l];
			return;
		}
		int mid=l+(r-l)/2;
		GenerateTree(leftChild(treeindex), l, mid);
		GenerateTree(rightChild(treeindex), mid+1, r);
		tree[treeindex]=tree[leftChild(treeindex)]+tree[rightChild(treeindex)];
	}
	public void update(int i,int val) {
		 if(num==null)
			  throw new IllegalArgumentException("segment tree is null");
		 set(0, 0, num.length-1, i, val);
	}
	private void set(int treeIndex,int l,int r,int index,int e) {
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
		tree[treeIndex]=tree[leftindex]+tree[rightindex];
	}
	public int query(int treeindex,int l,int r,int qleft,int qright) {
		if(l==qleft&&r==qright)
			return tree[treeindex];
		int mid=l+(r-l)/2;
	    if(qright<=mid)
			return query(leftChild(treeindex), l, mid, qleft, qright);
		else if(qleft>mid)
			return query(rightChild(treeindex), mid+1, r, qleft, qright);
		else {
			int leftvalue=query(leftChild(treeindex), l, mid, qleft, mid);
			int rightvalue=query(rightChild(treeindex), mid+1, r, mid+1, qright);
			return leftvalue+rightvalue;
		}
		
	}
	private int leftChild(int index) {
		return 2*index+1;
	}
	private int rightChild(int index) {
		return 2*index+2;
	}

	public int sumRange(int i, int j) {
	  if(num==null)
		  throw new IllegalArgumentException("segment tree is null");
		return query(0, 0, num.length-1, i, j);
	}

}
