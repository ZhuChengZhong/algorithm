package com.zhu.leetcode;
/**
 *  A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list. 
深拷贝一个单链表，链表节点中有指向下一个节点的next指针和一个随机指针 random
 * @author Administrator
 *   
 */
public class CopyRandomList {
	static class RandomListNode {
		      int label;
		      RandomListNode next, random;
		      RandomListNode(int x) { this.label = x; }
		  };
	public static RandomListNode copyRandomList(RandomListNode head) {
		if(head==null)
			return null;
		RandomListNode p=head;
		while(p!=null){
			RandomListNode node=new RandomListNode(p.label);
			node.next=p.next;
			p.next=node;
			p=node.next;
		}
		p=head;
		while(p!=null){
			if(p.random!=null)
				p.next.random=p.random.next;
			p=p.next.next;
		}
		p=head;
		RandomListNode p1=p.next;
		RandomListNode copyHead=p1;
		while(p!=null){
			p.next=p1.next;
			p=p.next;
			if(p!=null){
				p1.next=p.next;
				p1=p1.next;
			}
		}
		return copyHead;        
	}
	public static void main(String[] args) {
		RandomListNode n1=new RandomListNode(1);
		RandomListNode n2=new RandomListNode(2);
		RandomListNode n3=new RandomListNode(3);
		RandomListNode n4=new RandomListNode(4);
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n1.random=n1;
		n2.random=n2;
		RandomListNode r=copyRandomList(n1);
		
	}
}
