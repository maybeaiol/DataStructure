package Heap;

import java.util.Random;

public class demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=1000000;
		MaxHeap<Integer> maxHeap=new MaxHeap<>();
		Random random=new Random();
		for(int i=0;i<n;i++)
			maxHeap.add(random.nextInt(Integer.MAX_VALUE));
		System.out.println(maxHeap.getSize());
		int[] arr=new int[n];
		for(int i=0;i<=n-1;i++)
			arr[i]=maxHeap.extractMax();
		System.out.println(maxHeap.getSize());
		for(int i=0;i<n-1;i++)
			if(arr[i]<arr[i+1])
				System.out.println("erro");
		System.out.println("test  Maxheap completed");
	}

}
