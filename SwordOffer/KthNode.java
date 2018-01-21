package com.zhu.practice;

import com.zhu.practice.Print.TreeNode;
/**
 * 给定一颗二叉搜索树，请找出其中的第k大的结点。
 * 例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
 * @author Administrator
 * 利用中序遍历，遍历到的第k个即为要求的值
 */
public class KthNode {
	static class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	private static int kk;
	 static TreeNode kthNode(TreeNode pRoot, int k) {
	       kk=k;
	       return findK(pRoot);
	 }
	  //中序遍历
	  private static TreeNode findK(TreeNode node){
		  if(node==null){
			  return null;
		  }
		  TreeNode n1=findK(node.left);
		  if(n1!=null){
			  return n1;
		  }
		  --kk;
		  if(kk==0){
			  return node;
		  }
		  TreeNode n2=findK(node.right);
		  return n2;
	  }
	  public static void main(String[] args) {
		  TreeNode node1=new TreeNode(4);
			TreeNode node2=new TreeNode(1);
			TreeNode node3=new TreeNode(6);
			TreeNode node4=new TreeNode(2);
			TreeNode node5=new TreeNode(5);
			node1.left=node2;
			node1.right=node3;
			node2.right=node4;
			node3.left=node5;
			TreeNode result=kthNode(node1,5);
			System.out.println(result.val);
	}
}
