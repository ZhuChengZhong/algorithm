package com.zhu.leetcode;

import java.util.ArrayList;

import com.zhu.leetcode.PostorderTraversal.TreeNode;
/**
 * Ç°Ðò±éÀú
 * @author Administrator
 *
 */
public class PreorderTraversal {
	static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }

public static ArrayList<Integer> preorderTraversal(TreeNode root) {
  ArrayList<Integer> list=new ArrayList<Integer>();
  preorder(root,list);
  return list;
}
private static void preorder(TreeNode root,ArrayList<Integer> lt){
	if(root==null)
			return ;
	lt.add(root.val);
	preorder(root.left,lt);
	preorder(root.right,lt);
	
}

}
