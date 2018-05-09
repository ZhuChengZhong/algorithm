package com.zhu.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
/**
 *  Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree{3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7


return its bottom-up level order traversal as:

[
  [15,7]
  [9,20],
  [3],
]

 * @author Administrator
 *
 */
public class LevelOrderBottom {
	  static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	if(root==null) {
    		return result;
    	}
    	LinkedList<TreeNode>queue=new LinkedList<TreeNode>();
    	queue.add(root);
    	while(!queue.isEmpty()) {
    		int size=queue.size();
    		ArrayList<Integer> list=new ArrayList<Integer>();
    		while(size-->0){
    			TreeNode node=queue.poll();
    			list.add(node.val);
    			if(node.left!=null) {
    				queue.add(node.left);
    			}
    			if(node.right!=null) {
    				queue.add(node.right);
    			}
    		}
    		result.add(list);
    	}
    	ArrayList<ArrayList<Integer>> rs = new ArrayList<ArrayList<Integer>>();
    	while(!result.isEmpty()) {
    		rs.add(result.remove(result.size()-1));
    	}
    	return rs;
    }
    public static void main(String[] args) {
    	TreeNode node=new TreeNode(1);
    	TreeNode node1=new TreeNode(2);
    	TreeNode node2=new TreeNode(3);
    	TreeNode node3=new TreeNode(4);
    	TreeNode node4=new TreeNode(5);
    	node.left=node1;
    	node.right=node2;
    	node1.left=node3;
    	node1.right=node4;
    	System.out.println(new LevelOrderBottom().levelOrderBottom(node));
	}
}
