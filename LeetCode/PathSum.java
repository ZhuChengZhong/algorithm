package com.zhu.leetcode;

import java.util.ArrayList;
/**
 *  Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
For example:
Given the below binary tree andsum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1

return

[
   [5,4,11,2],
   [5,8,4,5]
]

 */
import com.zhu.leetcode.HasPathSum.TreeNode;

public class PathSum {
	  static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
    	ArrayList<Integer>list=new ArrayList<Integer>(); 
    	ArrayList<ArrayList<Integer>> result =new ArrayList<ArrayList<Integer>>();
    	has(root, sum, list, result);
    	return result;
    }

    public void has(TreeNode root, int sum,ArrayList<Integer>list,ArrayList<ArrayList<Integer>> result) {
    	if (isLeaf(root) && sum==root.val) {
    		list.add(root.val);
    		result.add(new ArrayList<Integer>(list));
    		list.remove(list.size()-1);
    	}
    	if (root==null) {
    		return;
    	}
    	list.add(root.val);
        has(root.left, sum-root.val,list,result);
        has(root.right, sum-root.val,list,result);
        list.remove(list.size()-1);
    }
    public boolean isLeaf(TreeNode node){
    	if(node==null)
    		return false;
    	if(node.left==null&&node.right==null)
    		return true;
    	return false;
    }
    public static void main(String[] args) {
		TreeNode node=new TreeNode(1);
		TreeNode node1=new TreeNode(2);
		TreeNode node2=new TreeNode(3);
		node.right=node1;
		node.left=node2;
		System.out.println(new PathSum().pathSum(node, 3));
	}
}
