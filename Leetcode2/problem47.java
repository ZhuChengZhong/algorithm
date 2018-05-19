package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。

示例:

输入: [1,1,2]
输出:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]


 * @author zhu
 *
 */
public class problem47 {
    public static List<List<Integer>> permuteUnique(int[] nums) {
     	List<List<Integer>> result=new ArrayList<>();
     	Arrays.sort(nums);
     	permuteUnique(result,nums,0);
    	return result;
    }
    public static void permuteUnique(List<List<Integer>> result,int[] nums,int n) {
    	if(n==nums.length-1) {
    		List<Integer>list=new ArrayList<>();
    		for(int i=0;i<nums.length;i++) {
    			list.add(nums[i]);
    		}
    		result.add(list);
    	}
    	HashSet<Integer>set=new HashSet<>();
    	for(int i=n;i<nums.length;i++) {
    		if(set.contains(nums[i])) {
    			continue;
    		}
    		set.add(nums[i]);
    		swap(nums,n,i);
    		permuteUnique(result,nums,n+1);
    		swap(nums, n,i);
    	}
    }
    private static void swap(int []nums,int i,int j) {
    	int temp=nums[i];
    	nums[i]=nums[j];
    	nums[j]=temp;
    }
    public static void main(String[] args) {
    	int []nums= {1,1,2,2};
    	System.out.println(permuteUnique(nums));
	}
}
