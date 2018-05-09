package com.zhu.leetcode;

import java.util.LinkedList;
/**
 *  Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

    You may only use constant extra space. 


For example,
Given the following binary tree,

         1
       /  \
      2    3
     / \    \
    4   5    7


After calling your function, the tree should look like:

         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL

 * @author Administrator
 *
 */
public class Connect {
	  static class TreeLinkNode {
		      int val;
		      TreeLinkNode left, right, next;
		      TreeLinkNode(int x) { val = x; }
		  }
    public void connect(TreeLinkNode root) {
    	if (root==null) {
    		return ;
    	}
    	LinkedList <TreeLinkNode> list=new LinkedList<TreeLinkNode>();
    	list.add(root);
    	while (!list.isEmpty()) {
    		int size=list.size();
    		TreeLinkNode pre=list.getFirst();
    		while (--size>=0) {
    			TreeLinkNode node=list.poll();
    			if (pre!=node) {
    				pre.next=node;
    				pre=node;
    			}
    			if (node.left!=null) {
    				list.addLast(node.left);
    			}
    			if (node.right!=null) {
    				list.addLast(node.right);
    			}
    		}
    		pre.next=null;
    	}
    }
    public static void main(String[] args) {
    	TreeLinkNode node1=new TreeLinkNode(1);
    	TreeLinkNode node2=new TreeLinkNode(2);
    	TreeLinkNode node3=new TreeLinkNode(3);
    	node1.left=node2;
    	node1.right=node3;
    	new Connect().connect(node1);
	}
}
