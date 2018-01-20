package com.zhu.practice;
/**
 * ����һ�������������е�һ����㣬
 * ���ҳ��������˳�����һ����㲢�ҷ��ء�
 * ע�⣬���еĽ�㲻�����������ӽ�㣬ͬʱ����ָ�򸸽���ָ�롣
 * @author Administrator
 *
 */
public class GetNext {
	static class TreeLinkNode {
	    int val;
	    TreeLinkNode left = null;
	    TreeLinkNode right = null;
	    TreeLinkNode next = null;

	    TreeLinkNode(int val) {
	        this.val = val;
	    }
	}
	public TreeLinkNode getNext(TreeLinkNode pNode){
		if(pNode==null){
			return null;
		}
		TreeLinkNode node=mid(pNode.right);
		if(node==null){
			TreeLinkNode head=head(pNode);
			if(head!=null){
				return head;
			}else{
				return null;
			}
		}
		return node;
    }
	//�ҵ���һ�����ڵ㲢�Ҹýڵ��ڸø��ڵ����������
	private TreeLinkNode head(TreeLinkNode node){
		TreeLinkNode root=node.next;
		if(root==null){
			return null;
		}
		if(root.left==node){
			return root;
		}
		return head(root);
	}
	//�ҵ���������е�һ���ڵ�
	private TreeLinkNode mid(TreeLinkNode root){
		if(root==null)
			return null;
		TreeLinkNode node=mid(root.left);
		if(node!=null){
			return node;
		}
		return root;
	}
	private static void midPrint(TreeLinkNode node){
		if(node==null){
			return ;
		}
		midPrint(node.left);
		System.out.println(node.val);
		midPrint(node.right);
	}
	public static void main(String[] args) {
		TreeLinkNode node1=new TreeLinkNode(1);
		TreeLinkNode node2=new TreeLinkNode(2);
		TreeLinkNode node3=new TreeLinkNode(3);
		TreeLinkNode node4=new TreeLinkNode(4);
		TreeLinkNode node5=new TreeLinkNode(5);
		node1.left=node2;
		node1.right=node3;
		node2.right=node4;
		node2.next=node1;
		node3.next=node1;
		node4.next=node2;
		node4.left=node5;
		node5.next=node4;
		GetNext g=new GetNext();
		TreeLinkNode n=g.getNext(node5);
		if(n==null){
			System.out.println(-1);
		}else{
			System.out.println(n.val);
		}
		midPrint(node1);
	}
}
