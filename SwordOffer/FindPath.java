import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
/**
 * ����һ�Ŷ�������һ����������ӡ���������н��ֵ�ĺ�Ϊ��������������·����
 * ·������Ϊ�����ĸ���㿪ʼ����һֱ��Ҷ����������Ľ���γ�һ��·��
 * @author Zhu
 * ˼·��ʹ��������������㷨
 */

public class FindPath {
	static class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	public static ArrayList<ArrayList<Integer>> findPath(TreeNode root,int target) {
		ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
	   if(root==null||target<0){
		   return result;
		  // throw new RuntimeException("����������Ϸ�");
	   }
	   ArrayList<Integer>list=new ArrayList<Integer>();
	   list.add(root.val);
	   find(result,list,root,target,root.val);
       return result; 
    }
	private static void find(ArrayList<ArrayList<Integer>> result,ArrayList<Integer> list,TreeNode root,int target,int sum){
		if(isLeaf(root)&&target==sum){
			ArrayList<Integer> list1=new ArrayList<Integer>(list);
			result.add(list1);
		}
		if(sum>target){
			return;
		}
		if(root.left!=null){
			list.add(root.left.val);
			find(result,list,root.left,target,sum+root.left.val);
			list.remove(list.size()-1);
		}
		if(root.right!=null){
			list.add(root.right.val);
			find(result,list,root.right,target,sum+root.right.val);
			list.remove(list.size()-1);
		}
	}
	private static boolean isLeaf(TreeNode node){
		if(node!=null && node.left==null && node.right==null){
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		TreeNode node=new TreeNode(1);
		TreeNode node1=new TreeNode(2);
		TreeNode node2=new TreeNode(1);
		TreeNode node3=new TreeNode(1);
		node.left=node1;
		node.right=node2;
		node2.left=node3;
		System.out.println(findPath(node,3));
	}
}
