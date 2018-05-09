package com.algorithm.offer;
/**
 * ����һ�ö����������������ȡ�
 * �Ӹ���㵽Ҷ������ξ����Ľ�㣨������Ҷ��㣩�γ�����һ��·�����·���ĳ���Ϊ�������
 * @author Zhu
 *	����������������㷨
 */
public class TreeDepth {
	static class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;
	    }
	}
	public int treeDepth(TreeNode root) {
        return treeDepth(root,0);
    }
	private int treeDepth(TreeNode root,int depth){
		if(root==null) {
			return depth;
		}
		return max(treeDepth(root.left, depth+1),treeDepth(root.right,depth+1));
	}
	private int max(int x,int y) {
		return x>y?x:y;
	}
	public static void main(String[] args) {
		TreeDepth t=new TreeDepth();
		TreeNode root=new TreeNode(1);
		TreeNode left1=new TreeNode(2);
		TreeNode right1=new TreeNode(3);
		TreeNode left2=new TreeNode(4);
		root.left=left1;
		root.right=right1;
		right1.left=left2;
		int depth=t.treeDepth(root);
		System.out.println(depth);
	}
}
