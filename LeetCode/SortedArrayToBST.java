package com.zhu.leetcode;
/**
 * 

Given an array where elements are sorted in ascending order, convert it to a height balanced BST
 * @author Administrator
 *
 */
public class SortedArrayToBST {
	  public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
    public TreeNode sortedArrayToBST(int[] num) {
    	if (num==null) {
    		return null;
    	}
        return sortedArrayToBST(num,0,num.length-1);
    }
    public TreeNode sortedArrayToBST(int[] num,int start,int end) {
    	if (start>end) {
    		return null;
    	}
        int mid=(start+end+1)/2;
        TreeNode left = sortedArrayToBST(num,start,mid-1);
        TreeNode right = sortedArrayToBST(num, mid+1, end);
        TreeNode root = new TreeNode(num[mid]);
        root.left = left;
        root.right = right;
        return root;
    }
}
