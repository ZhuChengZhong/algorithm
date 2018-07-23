package leetcode;
/**
 *  Given a linked list, remove the n th node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.

Note:
Given n will always be valid.
Try to do this in one pass. 
 * @author Administrator
 *
 */
public class RemoveNthFromEnd {
	static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		      }
		  }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null||n<1){
            return head;
        }
        ListNode p=head;
        while(p!=null){
            n--;
            p=p.next;
        }
        if(n>0){
            return null;
        }
        if(n==0){
            return head.next;
        }
        p=head;
        while(n!=-1){
            p=p.next;
            n++;
        }
        p.next=p.next.next;
        return head;
    }
}
