package com.zhu.practice;

import java.util.ArrayList;
/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 *
 */
public class Print2 {
	static class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }
	}
	public static ArrayList<ArrayList<Integer> > print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer> > res=new ArrayList<ArrayList<Integer>>();
		if(pRoot==null){
			return res;
		}
		int index=0;
		ArrayList<TreeNode> l=new ArrayList<TreeNode>();
		l.add(pRoot);
		ArrayList<ArrayList<TreeNode> > result=new ArrayList<ArrayList<TreeNode>>();
		
		result.add(l);
		while(true){
			ArrayList<TreeNode>list1=result.get(index);
			ArrayList<TreeNode> list2=new ArrayList<TreeNode>();
				for(int i=0;i<list1.size();i++){
					TreeNode node=list1.get(i);
					if(node.left!=null){
						list2.add(node.left);
					}
					if(node.right!=null){
						list2.add(node.right);
					}
				}
			index++;
			if(list2.size()==0){
				break;
			}
			result.add(list2);
		}
		
		for(int i=0;i<result.size();i++){
			ArrayList<Integer> list=new ArrayList<Integer>();
			for(int j=0;j<result.get(i).size();j++){
				list.add(result.get(i).get(j).val);
			}
			res.add(list);
		}
		return res;
    }
	public static void main(String[] args) {
		TreeNode node1=new TreeNode(1);
		TreeNode node2=new TreeNode(2);
		TreeNode node3=new TreeNode(3);
		TreeNode node4=new TreeNode(4);
		TreeNode node5=new TreeNode(5);
		node1.left=node2;
		node1.right=node3;
		node2.right=node4;
		node3.left=node5;
		System.out.println(print(node1));
	}
}
