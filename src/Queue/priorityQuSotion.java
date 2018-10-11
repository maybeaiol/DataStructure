package Queue;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class priorityQuSotion {
	private class Frep {
		int e,frep;
		public Frep(int e,int frep) {
			this.e=e;
			this.frep=frep;
		}
//		@Override
//		public int compareTo(Frep another) {
//			if(this.frep<another.frep)
//				return -1;
//			else if(this.frep>another.frep)
//				return  1;
//			else {
//				return 0;
//			}
//		}
	}
	//比较器
	private class FrepComparator implements Comparator<Frep>{
		@Override
		public int compare(Frep o1, Frep o2) {
			return o1.frep-o2.frep;
		}
	}
	public List<Integer> topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new TreeMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i]))
				map.put(nums[i], 1);
			else {
				int key = map.get(nums[i]);
				map.put(nums[i], key + 1);
			}
		}
//		PriorityQueue<Integer> pQueue=new PriorityQueue<>(new Comparator<Integer>() {//匿名类
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				return map.get(o1)-map.get(o2);
//			}
//		});//新建比较器对象
		PriorityQueue<Integer> pQueue=new PriorityQueue<>(
				(a,b)-> map.get(a)-map.get(b) 
		);
		for(int key:map.keySet()) {
		  if(pQueue.size()<k)
			  pQueue.add(key);
		  else if(map.get(key)>map.get(pQueue.peek())) {
			  pQueue.remove();
		  	  pQueue.add(key);
		  	 }
		}
		List<Integer> linkedlist=new LinkedList<>();
		while(!pQueue.isEmpty())
			linkedlist.add(pQueue.remove());
		return linkedlist;
	 }

}
