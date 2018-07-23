package leetcode;
/**
 * 

Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list:1->2->3->4->5

For k = 2, you should return:2->1->4->3->5

For k = 3, you should return:3->2->1->4->5 
 * @author Administrator
 *
 */
public class ReverseKGroup {
	public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		      }
		  }
	   private static ListNode reverse(ListNode head){
	        ListNode pre=null;
	        ListNode cur=head;
	        ListNode next=null;
	        while(cur!=null){
	            next=cur.next;
	            cur.next=pre;
	            pre=cur;
	            cur=next;
	        }
	        return pre;
	    }
	    public ListNode reverseKGroup(ListNode head, int k) {
	        if(head==null||k<=1){
	            return head;
	        }
	        int i=k;
	        ListNode p=head;
	        while(p!=null&&i>1){
	            p=p.next;
	            i--;
	        }
	        if(p!=null){
	            ListNode nextHead=p.next;
	            p.next=null;
	            ListNode newHead=reverse(head);
	            head.next=reverseKGroup(nextHead,k);
	            return newHead;
	        }
	        return head;
	    }
}
