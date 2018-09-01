package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;

public class LevelOrder {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	   public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
	        ArrayList<ArrayList<Integer>>res=new ArrayList<>();
	        if(root==null) return res;
	        LinkedList<TreeNode>queue=new LinkedList<>();
	        queue.offer(root);
	        while(!queue.isEmpty()){
	            int size=queue.size();
	            ArrayList<Integer>list=new ArrayList<>();
	            while(size-->0){
	                TreeNode node=queue.poll();
	                list.add(node.val);
	                if(node.left!=null){
	                    queue.offer(node.left);
	                }
	                if(node.right!=null){
	                    queue.offer(node.right);
	                }
	            }
	            res.add(list);
	        }
	        return res;
	    }
}
