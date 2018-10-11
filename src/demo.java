import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import javax.xml.soap.Node;

public class demo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Linkedlist<Integer> linkedlist=new Linkedlist<>();
		linkedlist.insert(0, 0);
		linkedlist.insert(1, 1);
		linkedlist.insert(2, 2);
		linkedlist.insert(3, 3);
		System.out.println(linkedlist);
//		System.out.println(linkedlist.getSize());
//		linkedlist.delElement(1);
//		System.out.println(linkedlist);
//		System.out.println(linkedlist.getSize());
//		linkedlist.delete(0);
//		System.out.println(linkedlist);
//		System.out.println(linkedlist.getSize());
		linkedlist.reverseList();
		System.out.println(linkedlist);
		
		int[]  a= intersection(new int[]{1,2,3,4},new int[]{2,3,4,5,6});
		for(int w:a) {
			System.out.println(w);
		}

	}
	 public  static  int[] intersection(int[] nums1, int[] nums2) {
		 Set<Integer> set=new TreeSet<>();
		ArrayList< Integer> arrayList=new ArrayList<>();
		 for(int i=0;i<nums1.length;i++) {
			 set.add(nums1[i]);
		 }
		 for(int i=0;i<nums2.length;i++) {
			 if(set.contains(nums2[i])) {
				 arrayList.add(nums2[i]);
				 set.remove(nums2[i]);
			 }
		 }
		 int[] a=new int[arrayList.size()];
		 
		 Iterator<Integer> iterator=arrayList.iterator();
		 int i=0;
		 while(iterator.hasNext()) {
			 a[i]=iterator.next();
			 i++;
		 }
		 return a;
	        
	 }
	
}
