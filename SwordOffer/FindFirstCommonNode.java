/**
 * 输入两个链表，找出它们的第一个公共结点
 *
 *思路：找出公共节点首先能想到的最简单的方法就是把第一条链表的节点挨个与第二条链表进行比较，如果
 *相等则该节点就是公共节点，此算法的时间复杂度为：O（n*n）
 *
 *更简单的方法：因为两条链表有公共子节点，所以从公共节点开始两个链表是相同的，可以先找出两条链表的长度
 *然后让长的链表先遍历，剩下的长度与短的链表相等后再一起向后遍历，如果节点相等则为公共节点
 */
public class FindFirstCommonNode {
	static class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
	 public static ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		 ListNode publicNode=null;
		 int lenOfList1=0,lenOfList2=0;
		 ListNode p=pHead1;
		 while(p!=null){
			 ++lenOfList1;
			 p=p.next;
		 }
		 p=pHead2;
		 while(p!=null){
			 ++lenOfList2;
			 p=p.next;
		 }
		 while(lenOfList1>lenOfList2){
			 pHead1=pHead1.next;
			 lenOfList1--;
		 }
		 while(lenOfList2>lenOfList1){
			 pHead2=pHead2.next;
			 lenOfList2--;
		 }
		 while(pHead1!=null&&pHead2!=null){
			 if(pHead1==pHead2){
				 publicNode=pHead1;
				 break;
			 }
		 }
		 return publicNode;
	 }
	 public static void main(String[] args) {
		 ListNode head1=new ListNode(1);
		 ListNode head2=new ListNode(2);
		 ListNode node=new ListNode(3);
		head1.next=node;
		head2.next=head1;
		ListNode n=findFirstCommonNode(head1,head2);
		System.out.println(n.val);
	}
}
