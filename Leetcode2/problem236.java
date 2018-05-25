package leetcode;

import leetcode.problem235.TreeNode;

/**
 * 给定一棵二叉树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义： “对于有根树T的两个结点u、v，最近公共祖先表示一个结点x，满足x是u、v的祖先且x的深度尽可能大。”（一个节点也可以是它自己的祖先）

例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]

        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4

示例 1:

输入: root, p = 5, q = 1
输出: 3
解释: 节点 5 和节点 1 的最近公共祖先是节点 3。

示例 2:

输入: root, p = 5, q = 4
输出: 5
解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为指定节点自身。


 * @author zhu
 *
 */
public class problem236 {
	static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||root==p||root==q) {
        	return root;
        }
        TreeNode res1=lowestCommonAncestor(root.left, p, q);
        TreeNode res2=lowestCommonAncestor(root.right, p, q);
        if(res1!=null&&res2!=null) {
        	return root;
        }
        return res1!=null?res1:res2;
    }
    public static void main(String[] args) {
    	TreeNode node1=new TreeNode(1);
    	TreeNode node2=new TreeNode(2);
    	TreeNode node3=new TreeNode(3);
    	TreeNode node4=new TreeNode(4);
    	TreeNode node5=new TreeNode(5);
    	node1.left=node2;
    	node1.right=node3;
    	node2.left=node4;
    	node2.right=node5;
    	TreeNode node=lowestCommonAncestor(node1,node3,node4);
    	System.out.println(node.val);
	}
}
