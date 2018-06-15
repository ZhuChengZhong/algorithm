package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个32位正整数 n，你需要找到最小的32位整数，其与 n 中存在的位数完全相同，并且其值大于n。如果不存在这样的32位整数，则返回-1。

示例 1:

输入: 12
输出: 21

示例 2:

输入: 21
输出: -1


 * @author zhu
 *
 */
public class problem556 {
    public static int nextGreaterElement(int n) {
        List<Integer>list=new ArrayList<Integer>();
        int max=-1;
        int temp=n;
        int index=-1;
        while(temp>0) {
        	int m=temp%10;
        	temp/=10;
        	list.add(m);
        }
        for(int i=0;i<list.size();i++) {
        	if(list.get(i)>=max) {
        		max=list.get(i);
        	}else {
        		index=i;
        		break;
        	}
        }
        if(index!=-1) {
        	for(int i=0;i<list.size();i++) {
        		if(list.get(i)>list.get(index)) {
        			int t=list.get(i);
        			list.set(i, list.get(index));
        			list.set(index, t);
        			reverse(list, 0, index-1);
        			break;
        		}
        	}
        	long res=0;
        	for(int i=list.size()-1;i>=0;i--) {
        		res=res*10+list.get(i);
        	}
        	if(res>Integer.MAX_VALUE) {
        		return -1;
        	}
        	return (int)res;
        }
        return -1;
    }
    private static void reverse(List<Integer>list,int start,int end) {
    	while(start<end) {
    		int temp=list.get(start);
    		list.set(start, list.get(end));
    		list.set(end, temp);
    		start++;
    		end--;
    	}
    }
    public static void main(String[] args) {
		System.out.println(nextGreaterElement(1999999999));
	}
}
