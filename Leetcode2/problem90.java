package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: [1,2,2]
输出:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]


 * @author zhu
 *
 */
public class problem90 {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> result=new ArrayList<>();
		List<Integer> list=new ArrayList<>();
		Arrays.sort(nums);
		subsetsWithDup(result, list, 0, nums);
		return result;
	}

	public static void subsetsWithDup(List<List<Integer>> result, List<Integer> list,int index,int[] nums) {
		result.add(new ArrayList<>(list));
		if(index==nums.length) {
			return ;
		}
		for(int i=index;i<nums.length;i++) {
			if(i>index&&nums[i]==nums[i-1]) {
				continue ;
			}
			list.add(nums[i]);
			subsetsWithDup(result, list, i+1,nums);
			list.remove(list.size()-1);
		}
	}
	public static void main(String[] args) {
		int[] nums= {1,2,2};
		System.out.println(subsetsWithDup(nums));
	}
}
