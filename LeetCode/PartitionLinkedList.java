package leetcode;

public class PartitionLinkedList {
    public ListNode partition(ListNode head, int x) {
        if(head==null) return head;
        ListNode left=new ListNode(0);
        ListNode right=new ListNode(0);
        ListNode p1=left;
        ListNode p2=right;
        ListNode p=head;
        while(p!=null){
            if(p.val<x){
                p1.next=p;
                p1=p1.next;
            }else{
                p2.next=p;
                p2=p2.next;
            }
            p=p.next;
        }
        p1.next=right.next;
        p2.next=null;
        return left.next;
    }
}
