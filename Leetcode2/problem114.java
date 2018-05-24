package leetcode;

import java.util.Stack;

/**
 * 给定一个二叉树，原地将它展开为链表。

例如，给定二叉树

    1
   / \
  2   5
 / \   \
3   4   6

将其展开为：

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6


 * @author zhu
 *
 */
public class problem114 {
	static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
    public static void flatten(TreeNode root) {
    	flatten1(root);
    }
    public static TreeNode flatten1(TreeNode root) {
    	if(root==null) {
    		return null;
    	}
    	TreeNode n1=flatten1(root.left);
    	TreeNode n2=flatten1(root.right);
    	if(n1==null) {
    		root.right=n2;
    	}else {
    		TreeNode p=n1;
    		while(p.right!=null) {
    			p=p.right;
    		}
    		p.right=n2;
    		root.right=n1;
    	}
    	root.left=null;
    	return root;
    }
    public static void main(String[] args) {
    	TreeNode node1=new TreeNode(1);
    	TreeNode node2=new TreeNode(2);
    	TreeNode node3=new TreeNode(3);
    	node1.left=node2;
    	node1.right=node3;
    	flatten(node1);
	}
}
