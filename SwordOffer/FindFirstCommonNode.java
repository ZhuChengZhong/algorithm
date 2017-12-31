/**
 * �������������ҳ����ǵĵ�һ���������
 *
 *˼·���ҳ������ڵ��������뵽����򵥵ķ������ǰѵ�һ������Ľڵ㰤����ڶ���������бȽϣ����
 *�����ýڵ���ǹ����ڵ㣬���㷨��ʱ�临�Ӷ�Ϊ��O��n*n��
 *
 *���򵥵ķ�������Ϊ���������й����ӽڵ㣬���Դӹ����ڵ㿪ʼ������������ͬ�ģ��������ҳ���������ĳ���
 *Ȼ���ó��������ȱ�����ʣ�µĳ�����̵�������Ⱥ���һ��������������ڵ������Ϊ�����ڵ�
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
