package leetcode;

import leetcode.problem19.ListNode;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

示例:

给定 1->2->3->4, 你应该返回 2->1->4->3.

说明:

    你的算法只能使用常数的额外空间。
    你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。


 * @author zhu
 *
 */
public class problem24 {
	static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
    public static ListNode swapPairs(ListNode head) {
    	if(head==null) {
    		return null;
    	}
    	ListNode pre=new ListNode(-1);
    	pre.next=head;
    	ListNode cur=head;
    	head=pre;
    	while(cur!=null&&cur.next!=null) {
    		pre.next=cur.next;
    		cur.next=pre.next.next;
    		pre.next.next=cur;
    		pre=cur;
    		cur=cur.next;
    	}
        return head.next;
    }
    public static void main(String[] args) {
    	ListNode node=new ListNode(1);
		ListNode node1=new ListNode(2);
		ListNode node2=new ListNode(3);
		ListNode node3=new ListNode(4);
		node.next=node1;
		node1.next=node2;
		node2.next=node3;
		ListNode result=swapPairs(node);
		while(result!=null) {
			System.out.println(result.val);
			result=result.next;
		}
	}
}
