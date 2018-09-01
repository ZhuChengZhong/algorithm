package leetcode;

import java.util.LinkedList;

public class BuildTree {
	static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null||preorder.length==0) return null;
        LinkedList<Integer>queue=new LinkedList<>();
        for(int i=0;i<preorder.length;i++){
            queue.offerLast(preorder[i]);
        }
        return build(queue,inorder,0,inorder.length-1);
    }
    private TreeNode build(LinkedList<Integer>queue,int[]in,int left,int right){
        if(left>right) return null;
        int val=queue.poll();
        TreeNode root=new TreeNode(val);
        int i=left;
        for(;i<=right;i++){
            if(in[i]==val){
                break;
            }
        }
        root.left=build(queue,in,left,i-1);
        root.right=build(queue,in,i+1,right);
        return root;
    }
}
