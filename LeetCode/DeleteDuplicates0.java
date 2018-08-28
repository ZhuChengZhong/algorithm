package leetcode;

public class DeleteDuplicates0 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode empty=new ListNode(-1);
        ListNode p=empty;
        ListNode cur=head;
        while(cur!=null){
            ListNode temp=cur;
            cur=cur.next;
            while(cur!=null&&cur.val==temp.val){
                cur=cur.next;
            }
            if(temp.next==cur){
                p.next=temp;
                p=p.next;
            }
        }
        p.next=null;
        return empty.next;
    }
}
