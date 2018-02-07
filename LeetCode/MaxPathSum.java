package com.zhu.leetcode;
/**
 * 

Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

For example:
Given the below binary tree,

       1
      / \
     2   3


Return6.


 * @author Administrator
 *
 */
public class MaxPathSum {
	 static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	 private int max=-0x7fffffff;
	 public int maxPathSum(TreeNode root){
		 maxPath(root);
		 return max;
	 }
	 public int maxPath(TreeNode root) {
		 if(root==null)
			 return 0;
	      int leftMax=maxPath(root.left);
	      int rightMax=maxPath(root.right);
	      int m=root.val;
	      if(leftMax>0)
	    	  m+=leftMax;
	      if(rightMax>0)
	    	  m+=rightMax;
	      if(max<m)
	    	  max=m;
	      return getMax(leftMax+root.val,rightMax+root.val,root.val);
	 }
	 private static int getMax(int x,int y,int z){
		 int result=x>y?x:y;
		 result=result>z?result:z;
		 return result;
	 }
	 public static void main(String[] args) {
		 TreeNode node1=new TreeNode(-1);
		 TreeNode node2=new TreeNode(2);
		 TreeNode node3=new TreeNode(3);
		 //node1.left=node2;
		 //node1.right=node3;
		 System.out.println(new MaxPathSum().maxPathSum(node1));
	}
}
