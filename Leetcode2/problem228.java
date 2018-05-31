package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个无重复元素的有序整数数组，返回数组区间范围的汇总。

示例 1:

输入: [0,1,2,4,5,7]
输出: ["0->2","4->5","7"]
解释: 0,1,2 可组成一个连续的区间; 4,5 可组成一个连续的区间。

示例 2:

输入: [0,2,3,4,6,8,9]
输出: ["0","2->4","6","8->9"]
解释: 2,3,4 可组成一个连续的区间; 8,9 可组成一个连续的区间。


 * @author zhu
 *
 */
public class problem228 {
    public static List<String> summaryRanges(int[] nums) {
    	List<String> res=new ArrayList<>();
        int start=0;
        while(start<nums.length) {
        	int end=start;
        	while(end+1<nums.length&&nums[end+1]==nums[end]+1) {
        		end++;
        	}
        	if(start==end) {
        		res.add(nums[start]+"");
        	}else {
        		res.add(nums[start]+"->"+nums[end]);
        	}
        	start=end+1;
        }
        return res;
    }
    public static void main(String[] args) {
		int[]nums= {0,1,2,4,5,7,9};
		System.out.println(summaryRanges(nums));
	}
}
