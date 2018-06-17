package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 你有 k 个升序排列的整数数组。找到一个最小区间，使得 k 个列表中的每个列表至少有一个数包含在其中。

我们定义如果 b-a < d-c 或者在 b-a == d-c 时 a < c，则区间 [a,b] 比 [c,d] 小。

示例 1:

输入:[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
输出: [20,24]
解释: 
列表 1：[4, 10, 15, 24, 26]，24 在区间 [20,24] 中。
列表 2：[0, 9, 12, 20]，20 在区间 [20,24] 中。
列表 3：[5, 18, 22, 30]，22 在区间 [20,24] 中。

注意:

    给定的列表可能包含重复元素，所以在这里升序表示 >= 。
    1 <= k <= 3500
    -105 <= 元素的值 <= 105
    对于使用Java的用户，请注意传入类型已修改为List<List<Integer>>。重置代码模板后可以看到这项改动。


 * @author zhu
 *
 */
public class problem632 {
	static class Heap{
		int[]arr;
		int capcity;
		int size;
		public Heap(int capcity) {
			this.capcity=capcity;
			arr=new int[capcity];
		}
		public void insert(int val) {
			if(size==capcity) {
				throw new RuntimeException("out of index "+size);
			}
			arr[size]=val;
			int s=size;
			while(s>0) {
				int parent=(s-1)>>1;
				if(arr[s]<arr[parent]) {
					int temp=arr[parent];
					arr[parent]=arr[s];
					arr[s]=temp;
				}
				s=parent;
			}
			size++;
		}
		public int min() {
			return arr[0];
		}
		public int pop() {
			if(size<=0) {
				throw new RuntimeException("heap is empty");
			}
			int res=arr[0];
			arr[0]=arr[--size];
			int cur=0;
			while(cur*2+1<size) {
				int left=cur*2+1;
				int right=cur*2+2;
				int minIndex=left;
				if(right<size) {
					minIndex=arr[left]<arr[right]?left:right;
				}
				if(arr[cur]>arr[minIndex]) {
					int temp=arr[cur];
					arr[cur]=arr[minIndex];
					arr[minIndex]=temp;
				}
				cur=minIndex;
			}
			return res;
		}
	}
    public static int[] smallestRange(List<List<Integer>> nums) {
        int minRange=Integer.MAX_VALUE;
        int[]res=new int[2];
        int size=nums.size();
        Heap h=new Heap(size);
        int[]index=new int[size];
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.size();i++) {
        	List<Integer>list=nums.get(i);
        	h.insert(list.get(0));
        	max=Math.max(max, list.get(0));
        }
        res[0]=h.min();
        res[1]=max;
        minRange=res[1]-res[0];
        while(true) {
        	int min=h.pop();
        	for(int i=0;i<nums.size();i++) {
        		List<Integer>list=nums.get(i);
        		if(list.get(index[i])==min) {
        			if(index[i]+1==list.size()) {
        				return res;
        			}
        			h.insert(list.get(++index[i]));
        			max=Math.max(max, list.get(index[i]));
        			int range=max-h.min();
        			if(range<minRange) {
        				minRange=range;
        				res[0]=h.min();
        				res[1]=max;
        			}
        			break;
        		}
            }
        }
    }
    public static void main(String[] args) {
		/*List<Integer>list=Arrays.asList(4,10,15,24,26);
		List<Integer>list1=Arrays.asList(0,9,12,20);
		List<Integer>list2=Arrays.asList(5,18,22,30);*/
    	List<Integer>list=Arrays.asList(1,2,3);
		List<Integer>list1=Arrays.asList(1,2,3);
		List<Integer>list2=Arrays.asList(1,2,3);
		List<List<Integer>>l=new ArrayList<>();
		l.add(list);
		l.add(list1);
		l.add(list2);
		System.out.println(Arrays.toString(smallestRange(l)));
	}
}
