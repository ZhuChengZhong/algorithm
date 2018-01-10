package com.algorithm.offer;
/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 
 * 平衡二叉树就是左右子数的深度相差不能大于1
 */
import com.algorithm.offer.TreeDepth.TreeNode;

public class IsBalanced {
	static class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;
	    }
	}
	class Depth{
		int count;
	}
	public boolean isBalanced(TreeNode root) {
		return isBalanced(root, new Depth());
	}
	public boolean isBalanced(TreeNode root,Depth depth) {
		if(root==null) {
			depth.count=0;
			return true;
		}
		Depth left=new Depth();
		Depth right=new Depth();
		if(isBalanced(root.left,left)&&isBalanced(root.right,right)) {
			int diff=left.count-right.count;
			if(diff>=-1&&diff<=1) {
				depth.count=max(left.count,right.count)+1;
				return true;
			}
		}
		return false;
    }
	
	private int max(int x,int y) {
		return x>y?x:y;
	}
	public static void main(String[] args) {
		IsBalanced t=new IsBalanced();
		TreeNode root=new TreeNode(1);
		TreeNode left1=new TreeNode(2);
		TreeNode right1=new TreeNode(3);
		TreeNode left2=new TreeNode(4);
		root.left=left1;
		root.right=right1;
		right1.left=left2;
		boolean depth=t.isBalanced(root);
		System.out.println(depth);
	}
}
