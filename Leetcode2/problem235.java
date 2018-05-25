package leetcode;

import java.util.Stack;

/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为： “对于有根树T的两个结点u、v，最近公共祖先表示一个结点x，满足x是u、v的祖先且x的深度尽可能大。”（一个节点也可以是它自己的祖先）

例如，给定二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]

        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5

示例 1:

输入: root, p = 2, q = 8
输出: 6 
解释: 节点 2 和节点 8 的最近公共祖先是 6。

示例 2:

输入: root, p = 2, q = 4
输出: 2
解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为指定节点自身。


 * @author zhu
 *
 */
public class problem235 {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(p.val>q.val) {
			return lowest(root, q, p);
		}
		return lowest(root, p, q);
	}
    public static TreeNode lowest(TreeNode root, TreeNode p, TreeNode q) {
    	if(root==null) {
    		return null;
    	}
        if(root.val>=p.val&&root.val<=q.val) {
        	return root;
        }
        if(root.val>p.val&&root.val>q.val) {
        	return lowest(root.left, p, q);
        }
        return lowest(root.right, p, q);
    }
}
