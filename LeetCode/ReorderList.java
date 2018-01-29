package com.zhu.leetcode;

import com.zhu.leetcode.SortList.ListNode;
/**
 *  Given a singly linked list L: L 0→L 1→…→L n-1→L n,
reorder it to: L 0→L n →L 1→L n-1→L 2→L n-2→…

You must do this in-place without altering the nodes' values.

For example,
Given{1,2,3,4}, reorder it to{1,4,2,3}. 
 * @author Administrator
 *
 */
public class ReorderList {
	static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	  }
	//递归解决 当数据较大时会抛出栈溢出异常
/*	private static ListNode h=null;
	public static void reorderList(ListNode head) {
       h=head;
       reorder(head); 
    }
	private static void reorder(ListNode node){
		 if(node==null)
			 	return ;
		 reorder(node.next);
		 if(h==null){
			 return ;
		 }
		 if(node==h||node==h.next){
			 node.next=null;
		 }else{
			 node.next=h.next;
			 h.next=node;
		 }
		 h=node.next;
	}*/
	public static void reorderList(ListNode head) {
		if(head==null||head.next==null||head.next.next==null)
			return ;
		ListNode fast=head;
		ListNode slow=head;
		//1.利用快慢指针找到中间值
		while(fast!=null){
			fast=fast.next;
			if(fast==null)
				break;
			fast=fast.next;
			slow=slow.next;
		}
		//断开链表
		ListNode n=slow;
		slow=slow.next;
		n.next=null;
		//2.翻转后半部分链表
		ListNode n1=slow;
		ListNode n2=slow.next;
		slow.next=null;
		while(n2!=null){
			slow=n2;
			n2=n2.next;
			slow.next=n1;
			n1=slow;
		}
		//3   交叉合并2个链表
		merge(head,slow);
	}
	private static void merge(ListNode n1,ListNode n2){
		ListNode h;
		h=n1;
		while(n2!=null){
			ListNode node=n2;
			n2=n2.next;
			node.next=h.next;
			h.next=node;
			h=node.next;
		}
	}
	public static void main(String[] args) {
		ListNode n1=new ListNode(1);
		ListNode n2=new ListNode(2);
		ListNode n3=new ListNode(3);
		ListNode n4=new ListNode(4);
	//	ListNode n5=new ListNode(5);
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		//n4.next=n5;
		reorderList(n2);
		while(n1!=null){
			System.out.println(n1.val);
			n1=n1.next;
		}
	}
}
