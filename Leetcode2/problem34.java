package leetcode;

import java.util.Arrays;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

你的算法时间复杂度必须是 O(log n) 级别。

如果数组中不存在目标值，返回 [-1, -1]。

示例 1:

输入: nums = [5,7,7,8,8,10], target = 8
输出: [3,4]

示例 2:

输入: nums = [5,7,7,8,8,10], target = 6
输出: [-1,-1]


 * @author zhu
 *
 */
public class problem34 {
    public static int[] searchRange(int[] nums, int target) {
    	if(nums==null||nums.length==0) {
    		return new int[] {-1,-1};
    	}
    	int low=lowerBound(nums, target);
    	int high=highBound(nums, target);
        return new int[]{low,high};
    }
    public static int lowerBound(int []nums,int target) {
    	int left=0,right=nums.length-1;
    	while(left<right) {
    		int mid=(left+right)/2;
    		if(nums[mid]<target) {
    			left=mid+1;
    		}else {
    			right=mid;
    		}
    	}
    	return nums[left]==target?left:-1;
    }
    public static int highBound(int []nums,int target) {
    	int left=0,right=nums.length-1;
    	while(left<right) {
    		int mid=(left+right+1)/2;
    		if(nums[mid]>target) {
    			right=mid-1;
    		}else {
    			left=mid;
    		}
    	}
    	return nums[left]==target?left:-1;
    }
    public static void main(String[] args) {
		int []nums= {1,2,3,4,4,4,5,6};
		System.out.println(Arrays.toString(searchRange(nums,4)));
	}
}
