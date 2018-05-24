package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。

说明: 叶子节点是指没有子节点的节点。

示例:
给定如下二叉树，以及目标和 sum = 22，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1

返回:

[
   [5,4,11,2],
   [5,8,4,5]
]


 * @author zhu
 *
 */
public class problem113 {
	static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
    	List<List<Integer>>result=new ArrayList<>();
    	List<Integer> list=new ArrayList<>();
    	pathSum(result, list, root, sum);
    	return result;
    }
    public static void pathSum(List<List<Integer>>result,List<Integer>list,TreeNode root, int sum) {
    	if(root==null) {
    		return ;
    	}
    	sum-=root.val;
    	list.add(root.val);
    	if(sum==0&&isLeaf(root)) {
    		result.add(new ArrayList<>(list));
    	}
    	pathSum(result, list, root.left, sum);
    	pathSum(result, list, root.right, sum);
    	list.remove(list.size()-1);
    }
    private static boolean isLeaf(TreeNode node) {
    	if(node.left==null&&node.right==null) {
    		return true;
    	}
    	return false;
    }
}
