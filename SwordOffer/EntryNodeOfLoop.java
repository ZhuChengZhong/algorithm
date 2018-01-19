package com.zhu.practice;
/**
 * 一个链表中包含环，请找出该链表的环的入口结点。
 * @author Administrator
 *
 */
public class EntryNodeOfLoop {
	 static class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	 }
	 public ListNode EntryNodeOfLoop(ListNode pHead){
			   ///
	  
	         if(pHead==null|| pHead.next==null|| pHead.next.next==null) return null;
	  
	         ListNode fast=pHead.next.next;
	  
	         ListNode slow=pHead.next;
	  
	         /////先判断有没有环
	  
	         while(fast!=slow){
	  
	             if(fast.next!=null&& fast.next.next!=null){
	  
	                 fast=fast.next.next;
	  
	                 slow=slow.next;
	  
	             }else{
	  
	                 //没有环,返回
	  
	                 return null;
	  
	             }
	  
	         }
	  
	         //循环出来的话就是有环，且此时fast==slow.
	  
	         fast=pHead;
	  
	         while(fast!=slow){
	  
	             fast=fast.next;
	  
	             slow=slow.next;
	  
	         }
	  
	         return slow;
	         
	 }
	 
}
