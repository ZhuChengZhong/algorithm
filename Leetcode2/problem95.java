package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。

示例:

输入: 3
输出:
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
解释:
以上的输出对应以下 5 种不同结构的二叉搜索树：

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3


 * @author zhu
 *
 */
public class problem95 {
	static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
    public static List<TreeNode> generateTrees(int n) {
    	if(n==0) {
    		return new ArrayList<>();
    	}
        return generateTrees(1,n);
    }
    public static List<TreeNode> generateTrees(int l,int r) {
    	List<TreeNode> res=new ArrayList<>();
        if(l>r) {
        	res.add(null);
        	return res;
        }
        for(int i=l;i<=r;i++) {
        	TreeNode head=new TreeNode(i);
        	List<TreeNode>lefts=generateTrees(l, i-1);
        	List<TreeNode>rights=generateTrees(i+1,r);
        	for(TreeNode left:lefts) {
        		for(TreeNode right:rights) {
        			head.left=left;
        			head.right=right;
        			res.add(clone(head));
        		}
        	}
        }
        return res;
    }
    public static TreeNode clone(TreeNode head) {
    	if(head==null) {
    		return null;
    	}
    	TreeNode cloneHead=new TreeNode(head.val);
    	cloneHead.left=clone(head.left);
    	cloneHead.right=clone(head.right);
    	return cloneHead;
    }
    public static void main(String[] args) {
    	System.out.println(generateTrees(3));
	}
}
