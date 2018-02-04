package com.zhu.leetcode;
/**
 * 

Given a binary tree containing digits from0-9only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path1->2->3which represents the number123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3


The root-to-leaf path1->2represents the number12.
The root-to-leaf path1->3represents the number13.

Return the sum = 12 + 13 =25. 
 * @author Administrator
 *
 */
public class SumNumbers {
	 static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	 public int sumNumbers(TreeNode root){
		 return sumNumbers(root,"");
	 }
    public int sumNumbers(TreeNode root,String sum) {
        if(root==null)
        	return 0;
        sum+=root.val;
        if(isLeaf(root)){
        	return Integer.parseInt(sum);
        }
        return sumNumbers(root.left,sum)+sumNumbers(root.right,sum);
    } 	
    private boolean isLeaf(TreeNode node){
    	if(node!=null&&node.left==null&&node.right==null)
    		return true;
    	return false;
    }
    public static void main(String[] args) {
		TreeNode root=new TreeNode(1);
		TreeNode node1=new TreeNode(2);
		TreeNode node2=new TreeNode(3);
		root.left=node1;
		root.right=node2;
		int result=new SumNumbers().sumNumbers(root);
		System.out.println(result);
	}
}
