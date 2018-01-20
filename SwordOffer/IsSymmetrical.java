package com.zhu.practice;
/**
 * ��ʵ��һ�������������ж�һ�Ŷ������ǲ��ǶԳƵġ�ע�⣬���һ��������ͬ�˶������ľ�����ͬ���ģ�������Ϊ�ԳƵġ�
 * @author Administrator
 * ͬʱ����߿�ʼ����������ʹ��ұ����������ͬʱ�����Ľڵ�Ƚ��Ƿ���ͬ��ȫ��ͬ���ǶԳƵ�
 */
public class IsSymmetrical {
	static class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	public static boolean isSymmetrical(TreeNode pRoot){
		if(pRoot==null){
			return true;
		}
        return isSymmetrical(pRoot.left, pRoot.right);
    }
	private static boolean isSymmetrical(TreeNode left,TreeNode right){ 
		if(left==null&&right==null){
			return true;
		}
		if(left==null||right==null){
			return false;
		}
		boolean b1=isSymmetrical(left.left,right.right);
		boolean b2=(left.val==right.val?true:false);
		boolean b3=isSymmetrical(left.right,right.left);
		return b1&&b2&&b3;
		
	}
	public static void main(String[] args) {
		TreeNode node1=new TreeNode(1);
		TreeNode node2=new TreeNode(2);
		TreeNode node3=new TreeNode(2);
		TreeNode node4=new TreeNode(3);
		TreeNode node5=new TreeNode(4);
		TreeNode node6=new TreeNode(4);
		TreeNode node7=new TreeNode(3);
		node1.left=node2;
		node1.right=node3;
		node2.left=node4;
		node2.right=node5;
		node3.left=node6;
		node3.right=node7;
		System.out.println(isSymmetrical(node2));
	}
}
