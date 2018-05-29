package leetcode;

import leetcode.problem142.ListNode;

/**
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

示例 1:

给定链表 1->2->3->4, 重新排列为 1->4->2->3.

示例 2:

给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.


 * @author zhu
 *
 */
public class problem143 {
	static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
    public static void reorderList(ListNode head) {
    	if(head==null) {
    		return ;
    	}
    	ListNode fast=head;
    	ListNode slow=head;
    	while(fast!=null&&fast.next!=null) {
    		fast=fast.next.next;
    		slow=slow.next;
    	}
    	ListNode h=slow.next;
    	slow.next=null;
    	h=reverse(h);
    	ListNode res=new ListNode(-1);
    	ListNode p=head;
    	while(h!=null) {
    		res.next=p;
    		p=p.next;
    		res=res.next;
    		res.next=h;
    		h=h.next;
    		res=res.next;
    	}
    	res.next=p;
    }
    private static ListNode reverse(ListNode h) {
    	if(h==null||h.next==null) {
    		return h;
    	}
    	ListNode pre=null;
    	ListNode cur=h;
    	ListNode next=cur.next;
    	while(cur!=null) {
    		cur.next=pre;
    		pre=cur;
    		cur=next;
    		if(next!=null) {
    			next=next.next;
    		}
    	}
    	return pre;
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
    	reorderList(node1);
    	while(node1!=null) {
    		System.out.println(node1.val);
    		node1=node1.next;
    	}
    	
	}
}
