package com.zhu.practice;

public class Merge {
	static class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
   public static ListNode merge(ListNode list1,ListNode list2) {
	ListNode head=new ListNode(0);
	ListNode p=head;
	while(list1!=null && list2!=null){
		if(list1.val<list2.val){
			p.next=new ListNode(list1.val);
			p=p.next;
			list1=list1.next;
		}else{
			p.next=new ListNode(list2.val);
			p=p.next;
			list2=list2.next;
		}
	}
	while(list1!=null){
		p.next=new ListNode(list1.val);
		p=p.next;
		list1=list1.next;
	}
	while(list2!=null){
		p.next=list2;
		p=p.next;
		list2=list2.next;
	}	
	return head.next;        
   }
   public static void main(String[] args) {
	   ListNode node1=new ListNode(1);
		ListNode node2=new ListNode(3);
		ListNode node3=new ListNode(5);
		//ListNode node4=new ListNode(9);
		//ListNode node5=new ListNode(11);
		
		 ListNode node11=new ListNode(2);
			ListNode node21=new ListNode(4);
			ListNode node31=new ListNode(6);
		node1.next=node2;
		node2.next=node3;
		
		
		node11.next=node21;
		node21.next=node31;
		ListNode head=merge(node1,node11);
		while(head!=null){
			System.out.println(head.val);
			head=head.next;
		}
   }
}
