package com.zhu.practice;

import com.zhu.practice.Print.TreeNode;
/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 * @author Administrator
 * 思路：通过前序遍历将每个节点的值保存在字符串中，null节点保存为 ' . ' ，并且每个节点的值之间用    |  隔开
 * 重建二叉树的时候也用前序遍历来进行即可
  */
public class SerializeBinaryTree {
	static  class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	private static String result;
	private static int index;
	  static String serialize(TreeNode root) {
		  result="";
		  treetoString(root);
		  return result;
	  }
	  private static void treetoString(TreeNode root){
		  if(root==null){
			  result+=".|";
			  return ;
		  }
		  result+=root.val+"|";
		  treetoString(root.left);
		  treetoString(root.right);
	  }
	  private static TreeNode stringToTree(){
		 char c=result.charAt(index++);
		 if(c=='.')
		 {
			 ++index;
			 return null;
		 }
		 int num=0;
		do{
			num=num*10+c-'0';
			c=result.charAt(index++);
		}while(c!='|');
		TreeNode node=new TreeNode(num);
		TreeNode left=stringToTree();
		TreeNode right=stringToTree();
		node.left=left;
		node.right=right;
		return node;
	  }
	  static TreeNode deserialize(String str) {
		  result=str;
		  index=0;
	      return stringToTree();
	  }
	  public static void main(String[] args) {
		  TreeNode node1=new TreeNode(11);
			TreeNode node2=new TreeNode(22);
			TreeNode node3=new TreeNode(33);
			TreeNode node4=new TreeNode(44);
			TreeNode node5=new TreeNode(55);
			node1.left=node2;
			node1.right=node3;
			node2.right=node4;
			node3.left=node5;
			String s=serialize(node1);
			System.out.println(s);
			TreeNode root=deserialize(s);
	}
}
