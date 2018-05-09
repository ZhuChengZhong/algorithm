package com.zhu.practice;
/**
 * һ�������а����������ҳ�������Ļ�����ڽ�㡣
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
	  
	         /////���ж���û�л�
	  
	         while(fast!=slow){
	  
	             if(fast.next!=null&& fast.next.next!=null){
	  
	                 fast=fast.next.next;
	  
	                 slow=slow.next;
	  
	             }else{
	  
	                 //û�л�,����
	  
	                 return null;
	  
	             }
	  
	         }
	  
	         //ѭ�������Ļ������л����Ҵ�ʱfast==slow.
	  
	         fast=pHead;
	  
	         while(fast!=slow){
	  
	             fast=fast.next;
	  
	             slow=slow.next;
	  
	         }
	  
	         return slow;
	         
	 }
	 
}
