package leetcode;
/**
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。

要求返回这个链表的深度拷贝。 

 * @author zhu
 *
 */
public class problem138 {
	static class RandomListNode {
		      int label;
		      RandomListNode next, random;
		      RandomListNode(int x) { this.label = x; }
		  };
    public static RandomListNode copyRandomList(RandomListNode head) {
    	if(head==null) {
    		return null;
    	}
    	RandomListNode p=head;
    	while(p!=null) {
    		RandomListNode clone=new RandomListNode(p.label);
    		clone.next=p.next;
    		p.next=clone;
    		p=clone.next;
    	}
    	p=head;
    	while(p!=null) {
    		if(p.random!=null) {
    			p.next.random=p.random.next;
    		}
    		p=p.next.next;
    	}
    	p=head;
    	RandomListNode res=head.next;
    	RandomListNode p1=res;
    	while(p!=null) {
    		p.next=p.next.next;
    		p=p.next;
    		if(p==null) {
    			break;
    		}
    		p1.next=p1.next.next;
    		p1=p1.next;
    	}
    	return res;
    }
    public static void main(String[] args) {
    	RandomListNode n1=new RandomListNode(1);
    	RandomListNode n2=new RandomListNode(2);
    	RandomListNode n3=new RandomListNode(3);
    	n1.next=n2;
    	n2.next=n3;
    	RandomListNode res=copyRandomList(n1);
    	while(res!=null) {
    		System.out.println(res.label);
    		res=res.next;
    	}
	}
}
