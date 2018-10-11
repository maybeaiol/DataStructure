package SegmentTree;

public class NumArray2 {
	private int sum[];
	private int[] data;
	public NumArray2(int[] nums) {
		if(nums.length==0)
				throw new IllegalArgumentException("no legal");

		data=new int[nums.length];
		for(int i=0;i<nums.length;i++) {
			data[i]=nums[i];
		}
		sum=new int[nums.length];
		sum[0]=nums[0];
		for(int i=1;i<sum.length;i++) {
			sum[i]=sum[i-1]+nums[i];
		}
	}

	public void update(int i, int val) {
		if (sum.length > 0) {
			data[i] = val;
			if (i == 0) {
				sum[0] = data[0];
				for (int m = 1; m < sum.length; m++) {
					sum[m] = sum[m - 1] + data[m];
				}
			} 
			else {
				for (int j = i; j < sum.length; j++) {
					sum[j] = sum[j - 1] + data[j];
				}
			}
		}

	}
	public int sumRange(int i, int j) {
		return i==0?sum[j]:sum[j]-sum[i-1];
	}
}
