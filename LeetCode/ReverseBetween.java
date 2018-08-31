package leetcode;

public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null||m<=0||n<=0||m>=n) return head;
        ListNode empty=new ListNode(0);
        empty.next=head;
        ListNode pre=empty,cur=head;
        for(int i=1;i<m;i++){
            pre=cur;
            cur=cur.next;
        }
        ListNode next;
        ListNode temp;
        for(int i=m;i<n;i++){
            next=cur.next;
            cur.next=next.next;
            next.next=pre.next;
            pre.next=next;
        }
        return empty.next;
    }
}
