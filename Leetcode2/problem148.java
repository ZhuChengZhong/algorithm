package leetcode;

import leetcode.problem147.ListNode;

/**
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。

示例 1:

输入: 4->2->1->3
输出: 1->2->3->4

示例 2:

输入: -1->5->3->4->0
输出: -1->0->3->4->5


 * @author zhu
 *
 */
public class problem148 {
	static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
    public static ListNode sortList(ListNode head) {
    	if(head==null||head.next==null) {
    		return head;
    	}
    	ListNode fast=head;
    	ListNode slow=new ListNode(-1);
    	slow.next=head;
    	while(fast!=null&&fast.next!=null) {
    		fast=fast.next.next;
    		slow=slow.next;
    	}
    	ListNode h=slow.next;
    	slow.next=null;
    	ListNode p1=sortList(head);
    	ListNode p2=sortList(h);
    	return merge(p1,p2);
    }
    private static ListNode merge(ListNode h1,ListNode h2) {
    	ListNode res=new ListNode(-1);
    	ListNode p=res;
    	while(h1!=null&&h2!=null) {
    		if(h1.val<h2.val) {
    			p.next=h1;
    			p=p.next;
    			h1=h1.next;
    		}else {
    			p.next=h2;
    			p=p.next;
    			h2=h2.next;
    		}
    	}
    	if(h1!=null) {
    		p.next=h1;
    	}
    	if(h2!=null) {
    		p.next=h2;
    	}
    	return res.next;
    }
    public static void main(String[] args) {
    	ListNode node1=new ListNode(2);
    	ListNode node2=new ListNode(1);
    	ListNode node3=new ListNode(5);
    	ListNode node4=new ListNode(4);
    	ListNode node5=new ListNode(3);
    	node1.next=node2;
    	node2.next=node3;
    	node3.next=node4;
    	node4.next=node5;
    	ListNode n=sortList(node1);
    	while(n!=null) {
    		System.out.println(n.val);
    		n=n.next;
    	}
	}
}
