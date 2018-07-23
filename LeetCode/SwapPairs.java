package leetcode;
/**
 * 

Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given1->2->3->4, you should return the list as2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed. 
 * @author Administrator
 *
 */
public class SwapPairs {
	public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		      }
		  }
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode empty=new ListNode(-1);
        empty.next=head;
        swap(empty);
        return empty.next;
    }
    private static void swap(ListNode head){
        if(head.next==null||head.next.next==null){
            return ;
        }
        ListNode next=head.next;
        head.next=next.next;
        next.next=head.next.next;
        head.next.next=next;
        swap(next);
    }
}
