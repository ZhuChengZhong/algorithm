package com.algorithm.offer;
/**
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度
 * @author Zhu
 *	利用深度优先搜索算法
 */
public class TreeDepth {
	static class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;
	    }
	}
	public int treeDepth(TreeNode root) {
        return treeDepth(root,0);
    }
	private int treeDepth(TreeNode root,int depth){
		if(root==null) {
			return depth;
		}
		return max(treeDepth(root.left, depth+1),treeDepth(root.right,depth+1));
	}
	private int max(int x,int y) {
		return x>y?x:y;
	}
	public static void main(String[] args) {
		TreeDepth t=new TreeDepth();
		TreeNode root=new TreeNode(1);
		TreeNode left1=new TreeNode(2);
		TreeNode right1=new TreeNode(3);
		TreeNode left2=new TreeNode(4);
		root.left=left1;
		root.right=right1;
		right1.left=left2;
		int depth=t.treeDepth(root);
		System.out.println(depth);
	}
}
