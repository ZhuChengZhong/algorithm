package leetcode;
/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。

示例 1:

输入: 1->2->3->3->4->4->5
输出: 1->2->5

示例 2:

输入: 1->1->1->2->3
输出: 2->3


 * @author zhu
 *
 */
public class problem82 {
	static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		 }
    public static ListNode deleteDuplicates(ListNode head) {
        if(head==null) {
        	return null;
        }
        ListNode p=new ListNode(-head.val);
        p.next=head;
        ListNode pre=p;
        ListNode cur=head;
        while(cur!=null) {
        	if(cur.next==null||cur.val!=cur.next.val) {
        		pre=cur;
        		cur=cur.next;
        		continue;
        	}
        	while(cur.next!=null&&cur.val==cur.next.val) {
        		cur=cur.next;
        	}
        	cur=cur.next;
        	pre.next=cur;
        }
        return p.next;
    }
    public static void main(String[] args) {
    	ListNode node1=new ListNode(1);
    	ListNode node2=new ListNode(1);
    	ListNode node3=new ListNode(1);
    	ListNode node4=new ListNode(1);
    	node1.next=node2;
    	node2.next=node3;
    	node3.next=node4;
    	ListNode head=deleteDuplicates(node1);
    	while(head!=null) {
    		System.out.println(head.val);
    		head=head.next;
    	}
	}
}
