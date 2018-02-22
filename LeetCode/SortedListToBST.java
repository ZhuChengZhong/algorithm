package com.zhu.leetcode;
/**
 * 

Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST. 
 * @author Administrator
 *
 */
public class SortedListToBST {
	  static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; next = null; }
		  }
	  static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	  public TreeNode sortedListToBST(ListNode head) {
		  if(head==null)
			  return null;
		  return sortedListToBST(head,null);
	  }
    public TreeNode sortedListToBST(ListNode head,ListNode end) {
    	if(head==end)
    		return null;
    	ListNode fast=head,slow=head;
    	while(fast!=end&&fast.next!=end){
    		slow=slow.next;
    		fast=fast.next.next;
    	}
    	TreeNode root=new TreeNode(slow.val);
    	TreeNode left=sortedListToBST(head,slow);
    	TreeNode right=sortedListToBST(slow.next,end);
    	root.left=left;
    	root.right=right;
    	return root;
    }
}
