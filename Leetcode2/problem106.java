package leetcode;

import leetcode.problem103.TreeNode;

/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。

例如，给出

中序遍历 inorder = [9,3,15,20,7]
后序遍历 postorder = [9,15,7,20,3]

返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7


 * @author zhu
 *
 */
public class problem106 {
	static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
    	return buildTree(postorder,0,postorder.length-1,inorder,0,inorder.length-1);
    }
    public static TreeNode buildTree(int[] postorder,int l1,int r1, int[] inorder,int l2,int r2) {
    	if(l1>r1||l2>r2) {
    		return null;
    	}
        int val=postorder[r1];
        TreeNode head=new TreeNode(val);
        int index=l2;
        for(int i=l2;i<=r2;i++) {
        	if(inorder[i]==val) {
        		index=i;
        		break;
        	}
        }
        int leftCount=index-l2;
        head.left=buildTree(postorder, l1,l1+leftCount-1, inorder, l2, index-1);
        head.right=buildTree(postorder, l1+leftCount, r1-1, inorder, index+1,r2);
        return head;
    }
    public static void main(String[] args) {
		int[]preorder= {3,9,20,15,7};
		int[]inorder= {9,3,15,20,7};
		TreeNode head=buildTree(preorder, inorder);
		
	}
}
