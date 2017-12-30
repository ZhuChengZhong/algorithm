import java.util.ArrayList;
import java.util.Stack;

/*
 * 输入一个链表，从尾到头打印链表每个节点的值
 * 1.先翻转单链表在进行打印  
 * 2.从头遍历单链表并放入一个栈中，之后从栈中弹出元素即从尾到头打印
 * */

     class ListNode {
        int val;
       ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
public class PrintListFromTailToHead {
	public  static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		ArrayList<Integer>list=new ArrayList<Integer>();
		if(listNode==null){
			return list;
		}
		ListNode preNode=listNode;
		ListNode midNode=listNode.next;
		preNode.next=null;
		if(midNode==null){
			list.add(preNode.val);
			return list;
		}
		ListNode nextNode=midNode.next;
		while(nextNode!=null){
			midNode.next=preNode;
			preNode=midNode;
			midNode=nextNode;
			nextNode=nextNode.next;
		}
		midNode.next=preNode;
		while(midNode!=null){
			list.add(midNode.val);
			midNode=midNode.next;
		}
        return list;
    }
	public static void main(String[] args) {
		ListNode node=new ListNode(1);
		ListNode node1=new ListNode(2);
		ListNode node2=new ListNode(3);
		ListNode node3=new ListNode(4);
		node.next=node1;
		node1.next=node2;
		node2.next=node3;
		ArrayList<Integer>list=printListFromTailToHead(node);
		System.out.println(list);
	}
}
