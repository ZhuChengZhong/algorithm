/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * @author Zhu
 * 思路：因为输入的是一颗二叉搜索树，所以中序遍历就是排序的结果，可以利用中序遍历来将所有的节点重新转换为一个排序的双向链表
 */
public class Convert {
	static class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	private static TreeNode current;
	 public static TreeNode convert(TreeNode pRootOfTree) {
		 current=null;
		 TreeNode head=findHead(pRootOfTree);
		 if(pRootOfTree==null){
			 return head;
		 }
		 solve(pRootOfTree);
	     return head;
	 }
	 private static TreeNode findHead(TreeNode root){
		 if(root==null)
			 return null;
		 while(root.left!=null){
			 root=root.left;
		 }
		 return root;
	 }
	 private static void solve(TreeNode root){
		 if(root.left!=null)
		 solve(root.left);
		 if(current!=null){
			 root.left=current;
			 current.right=root;
			 current=root;
		 }else{
			 current=root;
		 }
		 if(root.right!=null)
		 solve(root.right);
	 }
	 
	 
	 public static void main(String[] args) {
		 TreeNode root=new TreeNode(5);
		 TreeNode node3=new TreeNode(3);
		 TreeNode node2=new TreeNode(2);
		 TreeNode node4=new TreeNode(4);
		 TreeNode node6=new TreeNode(6);
		 TreeNode node7=new TreeNode(7);
		 TreeNode node8=new TreeNode(8);
		 root.left=node3;
		 root.right=node7;
		 node3.left=node2;
		 node3.right=node4;
		 node7.left=node6;
		 node7.right=node8;
		
		 TreeNode result=convert(root);
		 while(result.right!=null){
			 System.out.println(result.val);
			 result=result.right;
		 }
		 System.out.println("--------------");
		 while(result!=null){
			 System.out.println(result.val);
			 result=result.left;
		 }
	}
}
