package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。

示例:

输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]


 * @author zhu
 *
 */
public class problem46 {
    public static List<List<Integer>> permute(int[] nums) {
    	List<List<Integer>> result=new ArrayList<>();
    	permute(result,nums,0);
    	return result;
    }
    public static void permute(List<List<Integer>> result,int[] nums,int n) {
    	if(n==nums.length-1) {
    		List<Integer>list=new ArrayList<>();
    		for(int i=0;i<nums.length;i++) {
    			list.add(nums[i]);
    		}
    		result.add(list);
    	}
    	for(int i=n;i<nums.length;i++) {
    		swap(nums,n,i);
    		permute(result,nums,n+1);
    		swap(nums, n,i);
    	}
    }
    private static void swap(int []nums,int i,int j) {
    	int temp=nums[i];
    	nums[i]=nums[j];
    	nums[j]=temp;
    }
    public static void main(String[] args) {
    	int []nums= {1,2,3};
    	System.out.println(permute(nums));
	}
}
