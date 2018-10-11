package Arraylist;

import Stack.stack;

public class findsame {
  public static int getSame(int[] nums) {
	  if(nums==null||nums.length<=0)
		  return -1;
	  for(int i:nums) {
		  if(i<1||i>nums.length-1)
			  return -1;
	  }
	  int start=1;
	  int end=nums.length-1;
	  int mid;int count;
	  while(start<=end) {
		  mid=(end-start)/2+start;
		  count=totalsum(nums,start,mid);
		  //System.out.println(count);
		  if(start==end)
			  if(count>1)
				  return end;
		  if(count>mid-start+1) {
			  end=mid;
		  }
		  else {
			  start=mid+1;
		  } 
	  }
	  return -1;
  }
  private  static int  totalsum(int[] num,int start,int end) {
	  int count=0;
	  for(int i:num) {
		  if(i>=start&&i<=end)
			  count++;
	  }
	  return count;
  }
  public static void main(String[] args) {
	  int nums[]= {6,3,1,0,2,5,3};
	  int same[]=new int[3];
	  duplicate(nums, nums.length, same);
	  int sum[]={1,2,3,4,5,6,2};
	  int result= getSame(sum);
	  System.out.println(same[0]);
	  System.out.println(result);
	  
	  
	
}
  public  static boolean duplicate(int numbers[],int length,int [] duplication) {
	  if(numbers==null||length==0)
		  return false;
	  for(int i=0;i<length;i++) {
		  while(i!=numbers[i]) {
			  int j=numbers[i];
			  if(numbers[i]==numbers[j]) { duplication[0]=j;   return true;}
			  swap(numbers, numbers[i], numbers[j]);
		  }
	  }
	  return false;
  }
  private static void swap(int[] num,int a,int b) {
	 int temp=num[a];
	 num[a]=num[b];
	 num[b]=temp;
  }
}
