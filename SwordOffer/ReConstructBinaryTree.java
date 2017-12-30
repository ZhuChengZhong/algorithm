/*
 * ����ĳ��������ǰ���������������Ľ�������ؽ����ö�������
 * ���������ǰ���������������Ľ���ж������ظ������֡�
 * ��������ǰ���������{1,2,4,7,3,5,6,8}
 * �������������{4,7,2,1,5,3,8,6}��
 * ���ؽ�������������
 * */
/*˼·���ڶ�������ǰ������У���һ����ֵ���Ǹ��ڵ��ֵ��������������У����ڵ��ֵ�����е��м䲿�֣�
 * ���ԣ����ǿ���ͨ��ǰ������еĵ�һ�����ڵ�������������ҵ�����ڵ㣬�ýڵ���������߷ֱ��Ǹ��ڵ�
 * ��������������������ͨ���ݹ�ѭ�����ϲ�����������������������ɡ�
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
