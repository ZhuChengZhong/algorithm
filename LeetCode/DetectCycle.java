package com.zhu.leetcode;

import com.zhu.leetcode.SortList.ListNode;
/**
 * 

Given a linked list, return the node where the cycle begins. 
If there is no cycle, returnnull.

Follow up:
Can you solve it without using extra space? 
 * @author Administrator
 * ˼·�����ÿ���ָ�������
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
			//�޻��򷵻�null
			if((quick=quick.next)==null||(quick=quick.next)==null)
					return null;
			slow=slow.next;
			if(quick==slow)
				break;
		}
		//���ĳ���
		int countOfCycle=0;
		do{
			countOfCycle++;
			slow=slow.next;
		  }while(quick!=slow);
		//quick���� countOfCycle �� slow�ڳ����������ڵ��ٴ������Ľڵ���ǻ������
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
