package leetcode;
/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。

说明:
1 ≤ m ≤ n ≤ 链表长度。

示例:

输入: 1->2->3->4->5->NULL, m = 2, n = 4
输出: 1->4->3->2->5->NULL


 * @author zhu
 *
 */
public class problem92 {
	static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		 }
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null||m<=0||n<=0||m>n) {
        	return null;
        }
        ListNode empty=new ListNode(-1);
        empty.next=head;
        ListNode pre=empty;
        ListNode cur=head;
        ListNode next=cur.next;
        ListNode preBegin=null;
        int index=0;
        while(cur!=null&&index<n) {
        	if(index>=m) {
        		cur.next=pre;
        	}else {
        		preBegin=pre;
        	}
        	pre=cur;
        	cur=next;
        	if(next!=null) {
        		next=next.next;
        	}
        	index++;
        }
        preBegin.next.next=cur;
        preBegin.next=pre;
        return empty.next;
    }
    public static void main(String[] args) {
    	ListNode node1=new ListNode(1);
    	ListNode node2=new ListNode(2);
    	ListNode node3=new ListNode(3);
    	ListNode node4=new ListNode(4);
    	ListNode node5=new ListNode(5);
    	node1.next=node2;
    	node2.next=node3;
    	node3.next=node4;
    	node4.next=node5;
    	ListNode head=reverseBetween(node1, 1, 1);
    	while(head!=null) {
    		System.out.println(head.val);
    		head=head.next;
    	}
	}
}
