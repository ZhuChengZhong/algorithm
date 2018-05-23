package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import leetcode.problem92.ListNode;
import leetcode.problem94.TreeNode;

/**
 * 给定一个二叉树，返回它的 前序 遍历。

 示例:

输入: [1,null,2,3]  
   1
    \
     2
    /
   3 

输出: [1,2,3]

进阶: 递归算法很简单，你可以通过迭代算法完成吗？

 * @author zhu
 *
 */
public class problem144 {
	static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
    public static List<Integer> preorderTraversal(TreeNode root) {
    	List<Integer>list=new ArrayList<>();
		if(root!=null) {
			preorderTraversal(list,root);
		}
		return list;
    }
    
    public static void preorderTraversal(List<Integer>list,TreeNode root) {
        Stack<TreeNode>stack=new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()) {
        	TreeNode node=stack.pop();
        	list.add(node.val);
        	if(node.right!=null) {
        		stack.add(node.right);
        	}
        	if(node.left!=null) {
        		stack.add(node.left);
        	}
        }
    }
    public static void main(String[] args) {
		TreeNode node=new TreeNode(1);
		TreeNode nodel=new TreeNode(2);
		TreeNode noder=new TreeNode(3);
		node.left=nodel;
		node.right=noder;
		System.out.println(preorderTraversal(node));
	}
}
