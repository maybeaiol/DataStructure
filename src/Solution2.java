import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Solution2 {
	 public    int[] intersection(int[] nums1, int[] nums2) {
		TreeMap<Integer, Integer> treeMap=new TreeMap<>();
		for(int num:nums1) {
			if(!treeMap.containsKey(num))
				treeMap.put(num, 1);
			else
				treeMap.put(num, treeMap.get(num)+1);
		}
		ArrayList<Integer> list=new ArrayList<>();
		for(int num:nums2) {
			if(treeMap.containsKey(num)) {
				list.add(num);
				treeMap.put(num, treeMap.get(num)-1);
			}
			if(treeMap.get(num).equals(0))
				treeMap.remove(num);
		}
       int[] a=new int[list.size()];
		 
		 Iterator<Integer> iterator=list.iterator();
		 int i=0;
		 while(iterator.hasNext()) {
			 a[i]=iterator.next();
			 i++;
		 }
		 return a;
	       
	 }

}
