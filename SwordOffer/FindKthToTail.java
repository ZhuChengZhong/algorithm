/*package com.zhu.practice;

 class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class FindKthToTail {
	 public static ListNode findKthToTail(ListNode head,int k){
		 if(head==null||k<=0){
			 return null;
		 }
		 ListNode first=head;
		 ListNode second=head;
		 for(int i=1;i<=k;i++){
			 if(first==null){
				 return null;
			 }
			 first=first.next;	 
		 }
		 while(first!=null){
			 first=first.next;
			 second=second.next;
		 }
		 return second;
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
		ListNode result=findKthToTail(node1,5);
		System.out.println(result.val);
	}
}
*/