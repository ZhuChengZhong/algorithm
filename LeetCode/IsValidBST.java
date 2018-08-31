package leetcode;

import java.util.Stack;

public class IsValidBST {
	static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
    public static boolean isValidBST(TreeNode root) {
        Stack<TreeNode>stack=new Stack<>();
        TreeNode cur=root;
        TreeNode pre=null;
        while(!stack.isEmpty()||cur!=null){
            if(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }else{
                cur=stack.pop();
                System.out.println(cur.val);
                if(pre!=null&&cur.val<=pre.val){
                    return false;
                }
                pre=cur;
                cur=cur.right;
            }
        }
        return true;
    }
    public static void main(String[] args) {
    	TreeNode node=new TreeNode(1);
    	TreeNode node1=new TreeNode(1);
    	node.left=node1;
    	System.out.println(isValidBST(node));
	}
}
