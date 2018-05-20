package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。

示例 1:

输入: [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].

示例 2:

输入: [[1,4],[4,5]]
输出: [[1,5]]
解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。


 * @author zhu
 *
 */
public class problem56 {
	static class Interval {
		      int start;
		      int end;
		      Interval() { start = 0; end = 0; }
		      Interval(int s, int e) { start = s; end = e; }
			@Override
			public String toString() {
				return "Interval [start=" + start + ", end=" + end + "]";
			}
		      
		  }
    public static List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				if(o1.start<o2.start) {
					return -1;
				}
				if(o1.start>o2.start) {
					return 1;
				}
				return 0;
			}
		});
        List<Interval> result=new ArrayList<>();
        int index=0;
        while(index<intervals.size()) {
        	Interval interval=intervals.get(index);
        	int start=interval.start;
        	int end=interval.end;
        	index++;
        	while(index<intervals.size()) {
        		if(intervals.get(index).start<=end) {
        			end=Math.max(intervals.get(index).end, end);
        			index++;
        		}else {
        			break;
        		}
        	}
        	result.add(new Interval(start, end));
        }
        return result;
    }
    public static void main(String[] args) {
		List<Interval>list=new ArrayList<>();
		list.add(new Interval(1,3));
		list.add(new Interval(2,6));
		list.add(new Interval(8,10));
		list.add(new Interval(15,18));
		System.out.println(merge(list));
	}
}
