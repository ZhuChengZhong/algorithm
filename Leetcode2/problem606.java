package leetcode;
/**
 * 你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。

空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。

示例 1:

输入: 二叉树: [1,2,3,4]
       1
     /   \
    2     3
   /    
  4     

输出: "1(2(4))(3)"

解释: 原本将是“1(2(4)())(3())”，
在你省略所有不必要的空括号对之后，
它将是“1(2(4))(3)”。

示例 2:

输入: 二叉树: [1,2,3,null,4]
       1
     /   \
    2     3
     \  
      4 

输出: "1(2()(4))(3)"

解释: 和第一个示例相似，
除了我们不能省略第一个对括号来中断输入和输出之间的一对一映射关系。


 * @author zhu
 *
 */
public class problem606 {
	static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
    public static String tree2str(TreeNode t) {
        StringBuilder sb=new StringBuilder();
        tree2str(t, sb);
        return sb.toString();
    }
    public static void tree2str(TreeNode t,StringBuilder sb) {
        if(t==null) {
        	return ;
        }
        sb.append(t.val);
        if(t.left!=null||t.right!=null) {
        	sb.append("(");
        	 tree2str(t.left,sb);
        	 sb.append(")");
        }
        if(t.right!=null) {
        	sb.append("(");
        	tree2str(t.right,sb);
        	sb.append(")");
        }
    }
    public static void main(String[] args) {
    	TreeNode node1=new TreeNode(1);
    	TreeNode node2=new TreeNode(2);
    	TreeNode node3=new TreeNode(3);
    	TreeNode node4=new TreeNode(4);
    	node1.left=node2;
    	node1.right=node3;
    	node2.left=node4;
		System.out.println(tree2str(node1));
	}
}
