package com.zhu.leetcode;
/**
 *  Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
For example:
Given the below binary tree andsum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1

return true, as there exist a root-to-leaf path5->4->11->2which sum is 22. 
 * @author Administrator
 *
 */
public class HasPathSum {
	  static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	  public boolean hasPathSum(TreeNode root, int sum) {
		  if(root==null)
			  return false;
		  return has(root, sum);
	  }
    public boolean has(TreeNode root, int sum) {
    	if (isLeaf(root) && sum==root.val) {
    		return true;
    	}
    	if (root==null) {
    		return false;
    	}
        return has(root.left, sum-root.val)||has(root.right, sum-root.val);
    }
    public boolean isLeaf(TreeNode node){
    	if(node==null)
    		return false;
    	if(node.left==null&&node.right==null)
    		return true;
    	return false;
    }
    public static void main(String[] args) {
		TreeNode node=new TreeNode(-1);
		TreeNode node1=new TreeNode(-3);
		node.right=node1;
		System.out.println(new HasPathSum().hasPathSum(node, -4));
	}
}
