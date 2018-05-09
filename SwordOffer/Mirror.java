package com.zhu.practice;
/*
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * */
public class Mirror {
	static class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }
	}
	public static void mirror(TreeNode root) {
		if(root==null)
			return;
		TreeNode temp=root.left;
		root.left=root.right;
		root.right=temp;
		mirror(root.left);
		mirror(root.right);
    }
	public static void main(String[] args) {
		TreeNode root=new TreeNode(1);
		TreeNode left=new TreeNode(2);
		TreeNode right=new TreeNode(3);
		TreeNode leftLeft=new TreeNode(4);
		TreeNode leftRight=new TreeNode(5);
		root.left=left;
		root.right=right;
		left.left=leftLeft;
		left.right=leftRight;
		mirror(root);
	}
}
