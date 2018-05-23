package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的中序 遍历。

示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,3,2]

进阶: 递归算法很简单，你可以通过迭代算法完成吗？

 * @author zhu
 *
 */
public class problem94 {
	static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer>list=new ArrayList<>();
		if(root!=null) {
			inorderTraversal(list,root);
		}
		return list;
	}
	public static void inorderTraversal(List<Integer>list,TreeNode root) {
		TreeNode cur=root;
		Stack<TreeNode>stack=new Stack<>();
		while(!stack.isEmpty()||cur!=null) {
			if(cur!=null) {
				stack.push(cur);
				cur=cur.left;
			}else {
				cur=stack.pop();
				list.add(cur.val);
				cur=cur.right;
			}
		}
	}
	public static void main(String[] args) {
		TreeNode node=new TreeNode(1);
		TreeNode nodel=new TreeNode(2);
		TreeNode noder=new TreeNode(3);
		node.left=nodel;
		node.right=noder;
		System.out.println(inorderTraversal(node));
	}
}
