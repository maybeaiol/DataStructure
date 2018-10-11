package SegmentTree;

public class segmentDemo {

	public static void main(String[] args) {
//		Integer[] nums= {-2,0,3,-5,2,-1};
//		SegmentTree<Integer> segmentTree=new SegmentTree<Integer>(nums, (a,b)->a+b);
//		System.out.println(segmentTree);
//	    int result=	segmentTree.Query(0, 3);
//	    System.out.println(result);
		int[] nums= {1,2,3,4,5,6};
		NumArray numArray=new NumArray(nums);
	  int result=	numArray.sumRange(1, 4);
	  System.out.println(result);
		
		

	}

}
