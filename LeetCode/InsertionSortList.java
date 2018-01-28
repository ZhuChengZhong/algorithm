package com.zhu.leetcode;

import com.zhu.node.ListNode;

public class InsertionSortList {
	public static ListNode insertionSortList(ListNode head) {
		if(head==null){
			return null;
		}
		ListNode h=head.next;
		ListNode result=head;
		result.next=null;
        while(h!=null){
        	ListNode left=result;
        	ListNode lleft=left;
        	while(left!=null){
        		if(left.val>h.val){
        			ListNode node=h;
        			h=h.next;
        			node.next=left;
        			if(left==result){
        				result=node;
        			}else{
            			lleft.next=node;
        			}
        			break;
        		}
        		lleft=left;
        		left=left.next;
        	}
    	
    		if(left==null){
    			ListNode node=h;
    			h=h.next;
    			lleft.next=node;
    			node.next=null;
    		}
        }
        return result;
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
		ListNode h=insertionSortList(node1);
		while(h!=null){
			System.out.println(h.val);
			h=h.next;
		}
	}
}
