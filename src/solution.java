import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class solution {
	private class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	 public ListNode reverseList(ListNode head) {
	        ArrayList<Integer> arrayList=new ArrayList<>();
	        int[] array=new int[arrayList.size()];
	        ListNode cur=head;
	        while(cur!=null) {
	        	arrayList.add(cur.val);
	        	cur=cur.next;
	        }
	        for(int i=0;i<arrayList.size();i++) {
	        	array[i]=arrayList.get(arrayList.size()-i-1);
	        }
	        cur=head;int i=0;
	        while(cur!=null) {
	        	cur.val=array[i];
	        	cur=cur.next;
	        	i++;
	        }
	        
	        return head;
	 }
	 public int uniqueMorseRepresentations(String[] words) {
		 String [] codes= {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
		 Set<String> strset=new  TreeSet<>();//基于红黑树实现的
		 for(String word:words) {
			 StringBuilder ref=new StringBuilder();
			 for(int i=0;i<word.length();i++) {
				 ref.append(codes[word.charAt(i)-'a']);
			 }
			 strset.add(ref.toString());
		 }

	      return strset.size();
	}

}
