package leetcode;
/**
 * 给定一个二叉树

struct TreeLinkNode {
  TreeLinkNode *left;
  TreeLinkNode *right;
  TreeLinkNode *next;
}

填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。

初始状态下，所有 next 指针都被设置为 NULL。

说明:

    你只能使用额外常数空间。
    使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
    你可以假设它是一个完美二叉树（即所有叶子节点都在同一层，每个父节点都有两个子节点）。

示例:

给定完美二叉树，

     1
   /  \
  2    3
 / \  / \
4  5  6  7

调用你的函数后，该完美二叉树变为：

     1 -> NULL
   /  \
  2 -> 3 -> NULL
 / \  / \
4->5->6->7 -> NULL


 * @author zhu
 *
 */
public class problem116 {
	static class TreeLinkNode {
		      int val;
		      TreeLinkNode left, right, next;
		      TreeLinkNode(int x) { val = x; }
		  }
    public static void connect(TreeLinkNode root) {
    	if(root==null) {
    		return ;
    	}
    	TreeLinkNode empty=new TreeLinkNode(-1);
    	TreeLinkNode cur=empty;
    	TreeLinkNode p=root;
        while(p!=null) {
        	if(p.left!=null) {
        		cur.next=p.left;
        		cur=cur.next;
        	}
        	if(p.right!=null) {
        		cur.next=p.right;
        		cur=cur.next;
        	}
        	p=p.next;
        	if(p==null) {
        		p=empty.next;
        		empty.next=null;
        		cur=empty;
        	}
        }
    }
    public static void main(String[] args) {
    	TreeLinkNode node1=new TreeLinkNode(1);
    	TreeLinkNode node2=new TreeLinkNode(2);
    	TreeLinkNode node3=new TreeLinkNode(3);
    	TreeLinkNode node4=new TreeLinkNode(4);
    	TreeLinkNode node5=new TreeLinkNode(5);
    	node1.left=node2;
    	node1.right=node3;
    	node2.left=node4;
    	node2.right=node5;
    	connect(node1);
    	while(node1!=null) {
    		TreeLinkNode p=node1;
    		while(p!=null) {
    			System.out.print(p.val+"  ");
    			p=p.next;
    		}
    		System.out.println("\n");
    		node1=node1.left;
    	}
	}
}
