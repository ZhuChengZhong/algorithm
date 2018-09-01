package leetcode;

import java.util.LinkedList;

public class BuildTree2 {
	static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null||inorder.length==0) return null;
    LinkedList<Integer>queue=new LinkedList<>();
    for(int i=postorder.length-1;i>=0;i--){
        queue.offerLast(postorder[i]);
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
    root.right=build(queue,in,i+1,right);
    root.left=build(queue,in,left,i-1);
    return root;
}
}
