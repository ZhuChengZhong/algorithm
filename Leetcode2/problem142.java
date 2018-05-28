package leetcode;
/**
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。

说明：不允许修改给定的链表。

进阶：
你是否可以不用额外空间解决此题？

 * @author zhu
 *
 */
public class problem142 {
	static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		      }
		  }
    public static ListNode detectCycle(ListNode head) {
        if(head==null) {
        	return null;
        }
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null) {
        	fast=fast.next.next;
        	slow=slow.next;
        	if(fast==slow) {
        		break;
        	}
        }
        if(fast==null||fast.next==null) {
        	return null;
        }
        slow=head;
        while(slow!=fast) {
        	slow=slow.next;
        	fast=fast.next;
        }
        return slow;
    }
    public static void main(String[] args) {
    	ListNode node1=new ListNode(1);
    	ListNode node2=new ListNode(2);
    	ListNode node3=new ListNode(3);
    	ListNode node4=new ListNode(4);
    	node1.next=node2;
    	node2.next=node3;
    	node3.next=node4;
    	node4.next=node3;
    	ListNode n=detectCycle(node1);
    	System.out.println(n.val);
	}
}
