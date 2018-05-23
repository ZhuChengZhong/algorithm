package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import leetcode.problem144.TreeNode;

/**
 * 给定一个二叉树，返回它的 后序 遍历。

示例:

输入: [1,null,2,3]  
   1
    \
     2
    /
   3 

输出: [3,2,1]

进阶: 递归算法很简单，你可以通过迭代算法完成吗？

 * @author zhu
 *
 */
public class problem145 {
	static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
    public static List<Integer> postorderTraversal(TreeNode root) {
    	List<Integer>list=new ArrayList<>();
		if(root!=null) {
			postorderTraversal(list,root);
		}
		return list;
    }
    public static void postorderTraversal(List<Integer> list,TreeNode root) {
        Stack<TreeNode>stack1=new Stack<>();
        Stack<TreeNode>stack2=new Stack<>();
        stack1.push(root);
        while(!stack1.isEmpty()) {
        	TreeNode node=stack1.pop();
        	if(node.left!=null) {
        		stack1.push(node.left);
        	}
        	if(node.right!=null) {
        		stack1.push(node.right);
        	}
        	stack2.push(node);
        }
        while (!stack2.isEmpty()) {
        	list.add(stack2.pop().val);
		}
    }
    public static void main(String[] args) {
		TreeNode node=new TreeNode(1);
		TreeNode nodel=new TreeNode(2);
		TreeNode noder=new TreeNode(3);
		node.left=nodel;
		node.right=noder;
		System.out.println(postorderTraversal(node));
	}
}
