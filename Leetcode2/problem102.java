package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。

例如:
给定二叉树: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

返回其层次遍历结果：

[
  [3],
  [9,20],
  [15,7]
]


 * @author zhu
 *
 */
public class problem102 {
	static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
    public static List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> res=new ArrayList<>();
    	if(root==null) {
    		return res;
    	}
        Queue<TreeNode>queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
        	List<Integer> list=new ArrayList<>();
        	int size=queue.size();
        	while(size>0) {
        		TreeNode node=queue.poll();
        		list.add(node.val);
        		if(node.left!=null) {
        			queue.add(node.left);
        		}
        		if(node.right!=null) {
        			queue.add(node.right);
        		}
        		size--;
        	}
        	res.add(list);
        }
        return res;
    }
    public static void main(String[] args) {
    	TreeNode head=new TreeNode(1);
    	TreeNode left=new TreeNode(2);
    	TreeNode right=new TreeNode(3);
    	head.left=left;
    	head.right=right;
    	System.out.println(levelOrder(head));
	}
}
