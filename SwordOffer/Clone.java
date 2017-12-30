/**
 * ����һ����������ÿ���ڵ����нڵ�ֵ���Լ�����ָ�룬
 * һ��ָ����һ���ڵ㣬��һ������ָ��ָ������һ���ڵ㣩
 * �����ؽ��Ϊ���ƺ��������head��
 * ��ע�⣬���������벻Ҫ���ز����еĽڵ����ã�������������ֱ�ӷ��ؿգ�
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
			        //�������
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
