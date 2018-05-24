package leetcode;

import leetcode.problem106.TreeNode;

/**
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。

本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

示例:

给定的有序链表： [-10, -3, 0, 5, 9],

一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：

      0
     / \
   -3   9
   /   /
 -10  5


 * @author zhu
 *
 */
public class problem109 {
	static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
    public static TreeNode sortedListToBST(ListNode head) {
    	if(head==null) {
    		return null;
    	}
    	ListNode fast=head;
    	ListNode empty=new ListNode(-1);
    	empty.next=head;
    	ListNode slow=empty;
    	while(fast!=null&&fast.next!=null) {
    		fast=fast.next.next;
    		slow=slow.next;
    	}
    	TreeNode root=new TreeNode(slow.next.val);
    	root.right=sortedListToBST(slow.next.next);
    	slow.next=null;
    	root.left=sortedListToBST(empty.next);
    	return root;
    }
}
