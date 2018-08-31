package leetcode;

import java.util.ArrayList;
import java.util.Stack;


public class InorderTraversal {
	static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer>res=new ArrayList<>();
        inorder(res,root);
        return res;
    }
    private void inorder(ArrayList<Integer>res,TreeNode root){
        Stack<TreeNode>stack=new Stack<>();
        while(!stack.isEmpty()||root!=null){
            if(root!=null){
                stack.push(root);
                root=root.left;
            }else{
                TreeNode node=stack.pop();
                res.add(node.val);
                root=node.right;
            }
        }
    }
}
