/*
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}
 * 和中序遍历序列{4,7,2,1,5,3,8,6}，
 * 则重建二叉树并返回
 * */
/*思路：在二叉树的前序遍历中，第一个数值总是根节点的值，而在中序遍历中，根节点的值在序列的中间部分，
 * 所以，我们可以通过前序遍历中的第一个根节点在中序遍历中找到这个节点，该节点的左右两边分别是根节点
 * 的左子树和右子树，在通过递归循环以上步骤求出左子树和右子树即可。
 * */
class TreeNode {
	int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
    	val = x; 
    }
  }
public class ReConstructBinaryTree {
	private  int index=-1;
	
	 public  TreeNode reConstructBinaryTree(int [] pre,int [] in) {
		 if(pre==null||in==null){
			 return null;
		 }
		TreeNode root=build(pre,in,0,in.length-1);
        return root;
     }
	 public  TreeNode build(int [] pre,int [] in,int left,int right){
		 if(left>right){
			 return null;
		 }
		 ++index;
		 TreeNode treeNode=new TreeNode(pre[index]);
		 int i;
		 for(i=left;i<=right;i++){
			 if(pre[index]==in[i]){
				 break;
			 }
		 }
		 TreeNode leftNode=build(pre,in,left,i-1);
		 TreeNode rightNode=build(pre,in,i+1,right);
		 treeNode.left=leftNode;
		 treeNode.right=rightNode;
		 return treeNode;
	 }
	 public static void main(String[] args) {
		 ReConstructBinaryTree re=new ReConstructBinaryTree();
		/*int pre[]={1,2,4,7,3,5,6,8};
		int in[]={4,7,2,1,5,3,8,6};*/
		int pre[]={1,2,4,3,5,6};
		int in[]={4,2,1,5,3,6};
		TreeNode root=re.reConstructBinaryTree(pre,in);
	}
}
