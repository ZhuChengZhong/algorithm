/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，
 * 一个指向下一个节点，另一个特殊指针指向任意一个节点）
 * ，返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * @author Zhu
 * 
 */
public class Clone {
	static class RandomListNode {
	    int label;
	    RandomListNode next = null;
	    RandomListNode random = null;

	    RandomListNode(int label){
	        this.label = label;
	    }
	}
	public static RandomListNode clone(RandomListNode pHead)
    {
		if(pHead==null){
			return null;
		}
		RandomListNode p=pHead;
		while(p!=null){
			RandomListNode node=new RandomListNode(p.label);
			node.next=p.next;
			p.next=node;
			p=node.next;
		}
		p=pHead;
		while(p!=null){
			if(p.random!=null){
				p.next.random=p.random.next;
			}
			p=p.next.next;
		}

			 RandomListNode head = pHead.next;
			 RandomListNode cur = head;
			 p = pHead;
			        //拆分链表
			        while(p!=null){
			            p.next = p.next.next;
			            if(cur.next!=null)
			                cur.next = cur.next.next;
			            cur = cur.next;
			            p = p.next;
			        }
			        return head;        
    }
	public static void main(String[] args) {
		RandomListNode head=new RandomListNode(1);
		RandomListNode node1=new RandomListNode(2);
		RandomListNode node2=new RandomListNode(3);
		head.next=node1;
		//head.random=node1;
		node1.random=head;
		//node1.next=node2;
		//head.random=node2;
		
		RandomListNode result=clone(head);
	}
}
