package leetcode;

import java.util.Stack;

public class RecoverTree {
	static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
    public void recoverTree(TreeNode root) {
        Stack<TreeNode>stack=new Stack<>();
        TreeNode first=null,second=null,pre=null,cur=root;
        while(cur!=null||!stack.isEmpty()){
            if(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }else{
                cur=stack.pop();
                if(pre!=null&&cur.val<pre.val){
                    if(first==null){
                        first=pre;
                        second=cur;
                    }else{
                        second=cur;
                    }
                }
                pre=cur;
                cur=cur.right;
            }
        }
        if(first!=null){
            int temp=first.val;
            first.val=second.val;
            second.val=temp;
        }
    }
}
