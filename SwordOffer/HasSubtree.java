package com.zhu.practice;
/*
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * */
public class HasSubtree {
	static class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	public static boolean hasSubtree(TreeNode root1,TreeNode root2) {
		if(root1==null||root2==null)
        return false;
		if(judge(root1,root2)){
			return true;
		}else{
			if(judge(root1.left,root2)||judge(root1.right,root2)){
				return true;
			}
		}
		return false;
    }
	public static boolean judge(TreeNode root1,TreeNode root2){
	
		if(root2==null) return true;
		if(root1==null) return false;
		if(root1.val!=root2.val){
			return false;
		}
		boolean sameLeft=judge(root1.left,root2.left);
		boolean sameRight=judge(root1.right,root2.right);
		if(sameLeft==false || sameRight==false){
			return false;
		}
		
		return true;
	}
	public static void main(String[] args) {
		TreeNode root=new TreeNode(1);
		TreeNode left=new TreeNode(2);
		TreeNode right=new TreeNode(3);
		TreeNode anotherTree=new TreeNode(1);
		TreeNode anotherLeft=new TreeNode(2);
		TreeNode anotherRight=new TreeNode(3);
		root.left=left;
		root.right=right;
		anotherTree.left=anotherLeft;
		//anotherTree.right=anotherRight;
		boolean result=hasSubtree(anotherTree,root);
		System.out.println(result);
	}
}
