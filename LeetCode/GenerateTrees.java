package leetcode;

import java.util.ArrayList;

public class GenerateTrees {
	static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; left = null; right = null; }
		  }
    public ArrayList<TreeNode> generateTrees(int n) {
        return generateTrees(1,n);
    }
    private ArrayList<TreeNode> generateTrees(int left,int right){
        ArrayList<TreeNode>res=new ArrayList<>();
        if(left>right){
            res.add(null);
            return res;
        }
        for(int i=left;i<=right;i++){
             ArrayList<TreeNode>l=generateTrees(left,i-1);
             ArrayList<TreeNode>r=generateTrees(i+1,right);
            for(int j=0;j<l.size();j++){
                for(int k=0;k<r.size();k++){
                    TreeNode root=new TreeNode(i);
                    root.left=l.get(j);
                    root.right=r.get(k);
                    res.add(root);
                }
            }
        }
        return res;
    }
}
