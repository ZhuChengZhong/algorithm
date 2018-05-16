package leetcode;
/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。

示例 1:

输入: 1->1->2
输出: 1->2

示例 2:

输入: 1->1->2->3->3
输出: 1->2->3


 * @author zhu
 *
 */
public class problem83 {
	 static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
    public static ListNode deleteDuplicates(ListNode head) {
        if(head==null) {
        	return null;
        }
        ListNode pre=head;
        ListNode p=head.next;
        while(p!=null) {
        	if(p.val!=pre.val) {
        		pre.next=p;
        		pre=p;
        	}
        	p=p.next;
        }
        pre.next=null;
        return head;
    }
    public static void main(String[] args) {
		ListNode node1=new ListNode(1);
		ListNode node2=new ListNode(1);
		ListNode node3=new ListNode(2);
		ListNode node4=new ListNode(3);
		ListNode node5=new ListNode(3);
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		ListNode node=deleteDuplicates(node1);
		while(node!=null) {
			System.out.println(node.val);
			node=node.next;
		}
	}
}
