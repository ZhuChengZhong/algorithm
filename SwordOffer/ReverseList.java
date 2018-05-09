//package com.zhu.practice;
// class ListNode{
//    int val;
//    ListNode next = null;
//
//    ListNode(int val) {
//        this.val = val;
//    }
//}
//public class ReverseList {
//	
//	public static ListNode reverseList(ListNode head) {
//		if(head==null){
//			return null;
//		}
//		ListNode pre=head;
//		ListNode mid=pre.next;
//		if(mid==null){
//			return head;
//		}
//		ListNode tail=mid.next;
//		while(tail!=null){
//			mid.next=pre;
//			pre=mid;
//			mid=tail;
//			tail=tail.next;
//		}
//		mid.next=pre;
//		head.next=null;
//		return mid;
//    }
//	public static void main(String[] args) {
//		ListNode node1=new ListNode(1);
//		ListNode node2=new ListNode(2);
//		ListNode node3=new ListNode(3);
//		ListNode node4=new ListNode(4);
//		ListNode node5=new ListNode(5);
//		node1.next=node2;
//		node2.next=node3;
//		node3.next=node4;
//		node4.next=node5;
//		ListNode head=reverseList(null);
//		while(head!=null){
//			System.out.println(head.val);
//			head=head.next;
//		}
//	}
//}
