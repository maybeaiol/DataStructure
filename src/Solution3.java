import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Solution3 {
	private class Frep implements Comparable<Frep>{
		int e,frep;
		public Frep(int e,int frep) {
			this.e=e;
			this.frep=frep;
		}
		@Override
		public int compareTo(Frep another) {
			if(this.frep<another.frep)
				return -1;
			else if(this.frep>another.frep)
				return  1;
			else {
				return 0;
			}
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
		PriorityQueue<Frep> pQueue=new PriorityQueue<>();
		for(int key:map.keySet()) {
		  if(pQueue.size()<k)
			  pQueue.add(new Frep(key, map.get(key)));
		  else if(map.get(key)>pQueue.peek().frep) {
			  pQueue.remove();
		  	  pQueue.add(new Frep(key, map.get(key)));
		  	 }
		}
		List<Integer> linkedlist=new LinkedList<>();
		while(!pQueue.isEmpty())
			linkedlist.add(pQueue.remove().e);
		return linkedlist;
	 }
}
