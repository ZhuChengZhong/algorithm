package com.zhu.leetcode;

import com.zhu.leetcode.SortList.ListNode;
/**
 * 

Given a linked list, return the node where the cycle begins. 
If there is no cycle, returnnull.

Follow up:
Can you solve it without using extra space? 
 * @author Administrator
 * 思路：利用快慢指针来解决
 */
public class DetectCycle {
	static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	  }
	public static ListNode detectCycle(ListNode head) {
		if(head==null)
			return null;
		ListNode quick=head;
		ListNode slow=head;
		while(true){
			//无环则返回null
			if((quick=quick.next)==null||(quick=quick.next)==null)
					return null;
			slow=slow.next;
			if(quick==slow)
				break;
		}
		//环的长度
		int countOfCycle=0;
		do{
			countOfCycle++;
			slow=slow.next;
		  }while(quick!=slow);
		//quick先走 countOfCycle 步 slow在出发，当两节点再次相遇的节点就是环的入口
		quick=head;
		slow=head;
		for(int i=0;i<countOfCycle;i++){
			quick=quick.next;
		}
		while(slow!=quick){
			slow=slow.next;
			quick=quick.next;
		}
		return slow;
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
		node5.next=node3;
		ListNode node= detectCycle(node1);
		System.out.println(node.val);
	}
}
