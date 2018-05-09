package com.zhu.practice;

import com.zhu.practice.Print.TreeNode;
/**
 * ��ʵ�������������ֱ��������л��ͷ����л�������
 * @author Administrator
 * ˼·��ͨ��ǰ�������ÿ���ڵ��ֵ�������ַ����У�null�ڵ㱣��Ϊ ' . ' ������ÿ���ڵ��ֵ֮����    |  ����
 * �ؽ���������ʱ��Ҳ��ǰ����������м���
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
