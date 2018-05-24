package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.problem102.TreeNode;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。

例如：
给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

返回锯齿形层次遍历如下：

[
  [3],
  [20,9],
  [15,7]
]


 * @author zhu
 *
 */
public class problem103 {
	static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	List<List<Integer>> res=new ArrayList<>();
    	if(root==null) {
    		return res;
    	}
        Queue<TreeNode>queue=new LinkedList<>();
        queue.add(root);
        boolean reverse=false;
        while(!queue.isEmpty()) {
        	List<Integer> list=new ArrayList<>();
        	int size=queue.size();
        	while(size>0) {
        		TreeNode node=queue.poll();
        		if(reverse) {
        			list.add(0, node.val);
        		}else {
        			list.add(node.val);
        		}
        		if(node.left!=null) {
        			queue.add(node.left);
        		}
        		if(node.right!=null) {
        			queue.add(node.right);
        		}
        		size--;
        	}
        	reverse=!reverse;
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
    	System.out.println(zigzagLevelOrder(head));
	}
}
