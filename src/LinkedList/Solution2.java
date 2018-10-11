package LinkedList;

import LinkedList.Solution.ListNode;

 public class Solution2 {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	public ListNode removeElements(ListNode head, int val) {
		while(head!=null&&head.val==val) {
			head=head.next;
		}
		if(head==null) {
			return null;
		}
		ListNode pre=head;
		while(pre.next!=null) {
			if(pre.next.val==val) {

				pre.next=pre.next.next;
			}
			else {
				pre=pre.next;
			}
		}
		return head;
		
		
	}
}
