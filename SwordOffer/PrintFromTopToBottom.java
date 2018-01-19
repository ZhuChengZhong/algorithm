package com.zhu.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/**
 * �������´�ӡ����������ÿ���ڵ㣬ͬ��ڵ�������Ҵ�ӡ
 * @author Administrator
 * ˼·��ʹ��һ�����м���
 */
public class PrintFromTopToBottom {
	static class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	public static ArrayList<Integer> printFromTopToBottom(TreeNode root) {
		ArrayList<TreeNode>queue=new ArrayList<TreeNode>();
		ArrayList<Integer>resultList=new ArrayList<Integer>();
		if(root==null){
			return resultList;
		}
		queue.add(root);
		while(!queue.isEmpty()){
			TreeNode treeNode=queue.remove(0);
			resultList.add(treeNode.val);
			if(treeNode.left!=null){
				queue.add(treeNode.left);
			}
			if(treeNode.right!=null){
				queue.add(treeNode.right);
			}
		}
        return resultList;
    }
	public static void main(String[] args) {
		TreeNode treeNode=new TreeNode(1);
		TreeNode left=new TreeNode(2);
		TreeNode right=new TreeNode(3);
		treeNode.left=left;
		treeNode.right=right;
		System.out.println(printFromTopToBottom(treeNode));
	}
}
