package leetcode;
/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：

给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.

说明：

给定的 n 保证是有效的。

进阶：

你能尝试使用一趟扫描实现吗？

 * @author zhu
 *
 */
public class problem19 {
	 static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first=head;
        ListNode pre=new ListNode(-1);
        pre.next=head;
        for(int i=0;i<n;i++) {
        	if(first==null) {
        		return null;
        	}
        	first=first.next;
        }
        while(first!=null) {
        	first=first.next;
        	pre=pre.next;
        }
        if(head==pre.next) {
        	return head.next;
        }
        pre.next=pre.next.next;
        return head;
    }
    public static void main(String[] args) {
		ListNode node=new ListNode(1);
		ListNode node1=new ListNode(2);
		//node.next=node1;
		ListNode result=removeNthFromEnd(node,1);
		while(result!=null) {
			System.out.println(result.val);
			result=result.next;
		}
	}
}
