package LinkedList;

public class Solution {
	public static  class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
		public ListNode(int[] arr) {
			if(arr==null||arr.length==0) {
				//
			}
			this.val=arr[0];
			ListNode cur=this;
			for(int i=1;i<arr.length;i++) {
				cur.next=new ListNode(arr[i]);
				cur=cur.next;
			}
		}
		
		@Override
		public String toString() {
			StringBuilder sBuilder=new StringBuilder();
			ListNode cur=this;
			while(cur!=null) {
				sBuilder.append(cur.val);
				cur=cur.next;
			}
			return sBuilder.toString();
		}
	}

	public ListNode removeElements(ListNode head, int val) {
		ListNode dummyNode =new ListNode(-1);
		dummyNode.next=head;
		ListNode pre=dummyNode;
		while (pre.next!=null) {
			if(pre.next.val==val) {
				pre.next=pre.next.next;
			}
			else {
				pre=pre.next;
			}
		}
		return dummyNode.next;

	}
	public static void main(String[] args) {
		int[] nums= {0,1,2,3,4,5,6};
		ListNode head=new ListNode(nums);
		System.out.println(head);
	   ListNode res=new Solution().removeElements(head, 6);
	   System.out.println(res);
	}

}
