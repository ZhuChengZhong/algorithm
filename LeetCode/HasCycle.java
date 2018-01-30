package com.zhu.leetcode;

import com.zhu.leetcode.DetectCycle.ListNode;
/**
 *  Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space? 
 * @author Administrator
 *
 */
public class HasCycle {
	static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	  }
	 public static  boolean hasCycle(ListNode head) {
		 if(head==null)
				return false;
			ListNode quick=head;
			ListNode slow=head;
			while(true){
				//无环则返回null
				if((quick=quick.next)==null||(quick=quick.next)==null)
						return false;
				slow=slow.next;
				if(quick==slow)
					return true;
			}
			
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
			//node5.next=node3;
			System.out.println(hasCycle(node1));
	}
}
