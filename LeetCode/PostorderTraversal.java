package com.zhu.leetcode;

import java.util.ArrayList;
/**
 *  Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree{1,#,2,3},

   1
    \
     2
    /
   3


return[3,2,1]. 
 * @author Administrator
 * ¶þ²æÊ÷ºóÐò±éÀú
 */
public class PostorderTraversal {
	static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	
	public static ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        postorder(root,list);
        return list;
    }
	private static void postorder(TreeNode root,ArrayList<Integer> lt){
		if(root==null)
				return ;
		postorder(root.left,lt);
		postorder(root.right,lt);
		lt.add(root.val);
	}
	public static void main(String[] args) {
		TreeNode n1=new TreeNode(1);
		TreeNode n2=new TreeNode(2);
		TreeNode n3=new TreeNode(3);
		n1.right=n2;
		n2.left=n3;
		System.out.println(postorderTraversal(n1));
		
	}
}
