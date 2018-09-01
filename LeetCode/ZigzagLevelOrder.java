package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;

public class ZigzagLevelOrder {
	static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>>res=new ArrayList<>();
        if(root==null) return res;
        LinkedList<TreeNode>queue=new LinkedList<>();
        queue.offer(root);
        boolean left=true;
        while(!queue.isEmpty()){
            int size=queue.size();
            ArrayList<Integer>list=new ArrayList<>();
            if(left){
                while(size-->0){
                    TreeNode node=queue.pollFirst();
                    list.add(node.val);
                    if(node.left!=null){
                        queue.offerLast(node.left);
                    }
                    if(node.right!=null){
                        queue.offerLast(node.right);
                    }
                }
                left=false;
            }else{
                while(size-->0){
                    TreeNode node=queue.pollLast();
                    list.add(node.val);
                    if(node.right!=null){
                        queue.offerFirst(node.right);
                    }
                    if(node.left!=null){
                        queue.offerFirst(node.left);
                    }
                }
                left=true;
            }
            res.add(list);
        }
        return res;
    }
}
