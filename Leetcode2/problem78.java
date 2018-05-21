package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: nums = [1,2,3]
输出:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]


 * @author zhu
 *
 */
public class problem78 {
    public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result=new ArrayList<>();
		List<Integer> list=new ArrayList<>();
		subsets(result, list, 0, nums);
		return result;
	}

	public static void subsets(List<List<Integer>> result, List<Integer> list,int index,int[] nums) {
		result.add(new ArrayList<>(list));
		if(index==nums.length) {
			return ;
		}
		for(int i=index;i<nums.length;i++) {
			list.add(nums[i]);
			subsets(result, list, i+1,nums);
			list.remove(list.size()-1);
		}
	}
	public static void main(String[] args) {
		int [] nums= {1,2,3};
		System.out.println(subsets(nums));
	}
}
