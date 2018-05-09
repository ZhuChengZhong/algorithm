package com.zhu.leetcode;
/**
 * Given a binary tree, find its minimum depth.The minimum depth is the number of nodes
 *  along the shortest path from the root node down to the nearest leaf node.
 * @author Administrator
 *
 */
public class MinDepth {
	static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	public static int run(TreeNode root){
		if(root==null){
			return 0;
		}
		int result=minDepth(root, 1);
		return result;
	}
	private static int minDepth(TreeNode node,int depth){
		if(isLeaf(node)){
			return depth;
		}
		if(node.left!=null&&node.right==null)
			return minDepth(node.left, depth+1);
		if(node.right!=null&&node.left==null)
			return minDepth(node.right, depth+1);
		return min(minDepth(node.left, depth+1),minDepth(node.right, depth+1));
	}
	private static int min(int x,int y){
		return x<y?x:y;
	}
	private static boolean isLeaf(TreeNode node){
		if(node.left==null&&node.right==null){
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		TreeNode node=new TreeNode(1);
		TreeNode node1=new TreeNode(2);
		TreeNode node2=new TreeNode(3);
		TreeNode node3=new TreeNode(4);
		node.left=node1;
		node.right=node2;
		node1.right=node3;
		System.out.println(run(node));
	}
}
