package leetcode;

public class DeleteDuplicates {
	   public ListNode deleteDuplicates(ListNode head) {
	        if(head==null||head.next==null){
	            return head;
	        }
	        ListNode p=head;
	        ListNode cur=head.next;
	        while(cur!=null){
	            if(cur.val!=p.val){
	                p.next=cur;
	                p=p.next;
	            }
	            cur=cur.next;
	        }
	        p.next=null;
	        return head;
	    }
}
