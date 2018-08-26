package leetcode;

public class RotateRight {
    public ListNode rotateRight(ListNode head, int n) {
        if(head==null||n<=0){
            return head;
        }
        int len=0;
        ListNode p=head;
        ListNode tail=null;
        while(p!=null){
            len++;
            tail=p;
            p=p.next;
        }
        n=n%len;
        if(n==0){
            return head;
        }
        n=len-n;
        ListNode newHead=head;
        ListNode pre=null;
        while(n>0){
            pre=newHead;
            newHead=newHead.next;
            n--;
        }
        pre.next=null;
        tail.next=head;
        return newHead;
    }
}
