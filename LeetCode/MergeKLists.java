package leetcode;

import java.util.ArrayList;
/**
 * 

Merge k sorted linked lists and return it as
 one sorted list. Analyze and describe its complexity. 
 * @author Administrator
 *
 */
public class MergeKLists {
	static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		      }
		  }
    private static ListNode mergeTowList(ListNode node1,ListNode node2){
        if(node1==null){
            return node2;
        }
        if(node2==null){
            return node1;
        }
        ListNode empty=new ListNode(0);
        ListNode p=empty;
        while(node1!=null&&node2!=null){
            if(node1.val<node2.val){
                p.next=node1;
                node1=node1.next;
            }else{
                p.next=node2;
                node2=node2.next;
            }
            p=p.next;
        }
        if(node1!=null){
            p.next=node1;
        }
        if(node2!=null){
            p.next=node2;
        }
        return empty.next;
    }
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if(lists==null||lists.size()==0){
            return null;
        }
        ListNode res=lists.get(0);
        for(int i=1;i<lists.size();i++){
            res=mergeTowList(res,lists.get(i));
        }
        return res;
    }
}
