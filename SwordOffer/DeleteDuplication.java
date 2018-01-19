package com.zhu.practice;
/**
 * ��һ������������У������ظ��Ľ�㣬��ɾ�����������ظ��Ľ�㣬�ظ��Ľ�㲻������
 * ��������ͷָ�롣 ���磬����1->2->3->3->4->4->5 �����Ϊ 1->2->5
 * @author Administrator
 *
 */
public class DeleteDuplication {
	static class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
	public static ListNode deleteDuplication(ListNode pHead){
		if(pHead==null){
			return null;
		}
		ListNode result=null;
		ListNode p1=null;
		ListNode first=pHead;
		ListNode second=pHead.next;
		while(second!=null){
			while(second!=null&& first.val==second.val){
				second=second.next;
			}
			if(first.next==second){
				if(p1==null){
					result=first;
					p1=first;
				}else{
					p1.next=first;
					p1=p1.next;
				}
				
			}
			if(second!=null){
				first=second;
				second=second.next;
			}
		}
		if(first.next==second){
			if(p1==null){
				result=first;
				p1=first;
			}else{
				p1.next=first;
				p1=p1.next;
			}
			
		}
		if(p1!=null)
		p1.next=null;
		return result;
    }
	
	public static void main(String[] args) {
		ListNode head=new ListNode(1);
		ListNode node2=new ListNode(1);
		ListNode node3=new ListNode(1);
		ListNode node4=new ListNode(1);
		ListNode node5=new ListNode(1);
		head.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		ListNode result=deleteDuplication(head);
		while(result!=null){
			System.out.println(result.val);
			result=result.next;
		}
	}
}
