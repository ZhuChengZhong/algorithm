package com.zhu.leetcode;
/**
 * 单链表排序
 * @author Administrator
 * 思路：快速排序
 */
public class SortList {
	static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		      }
		  }
	public static ListNode sortList(ListNode head) {
		quickSort(head,null);
		return head;
    }
	private static void quickSort(ListNode head,ListNode tail){
		if(head==tail||head==null){
			return ;
		}
		int k =head.val;
		ListNode left=head;
		ListNode right=head.next;
		while(right!=tail){
			if(right.val<k){
				left=left.next;
				swap(left,right);
			}
			right=right.next;
		}
		swap(head, left);
		quickSort(head,left);
		quickSort(left.next, tail);
	}
	private static void swap(ListNode n1,ListNode n2){
		int temp=n1.val;
		n1.val=n2.val;
		n2.val=temp;
	}
	public static void main(String[] args) {
		ListNode node1=new ListNode(5);
		ListNode node2=new ListNode(3);
		ListNode node3=new ListNode(5);
		ListNode node4=new ListNode(2);
		ListNode node5=new ListNode(1);
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		ListNode ln=sortList(node1);
		while(ln!=null){
			System.out.println(ln.val);
			ln=ln.next;
		}
	}
}
