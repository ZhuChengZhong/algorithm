package leetcode;
/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

示例：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4


 * @author zhu
 *
 */
public class problem21 {
	private static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) {
        	return l2;
        }
        if(l2==null) {
        	return l1;
        }
        ListNode result=new ListNode(-1);
        ListNode cur=result;
        while(l1!=null&&l2!=null) {
        	if(l1.val<l2.val) {
        		cur.next=l1;
        		l1=l1.next;
        	}else {
        		cur.next=l2;
        		l2=l2.next;
        	}
        	cur=cur.next;
        }
        if(l1!=null) {
        	cur.next=l1;
        }
        if(l2!=null) {
        	cur.next=l2;
        }
        return result.next;
    }
    public static void main(String[] args) {
    	ListNode node1=new ListNode(1);
    	ListNode node2=new ListNode(2);
    	ListNode node3=new ListNode(3);
    	node1.next=node2;
    	node2.next=node3;
    	ListNode node11=new ListNode(1);
    	ListNode node22=new ListNode(2);
    	ListNode node33=new ListNode(3);
    	node11.next=node22;
    	node22.next=node33;
    	ListNode result=mergeTwoLists(node1,node11);
    	while(result!=null) {
    		System.out.println(result.val);
    		result=result.next;
    	}
	}
}
