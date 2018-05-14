package leetcode;
/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

你可以假设数组中无重复元素。

示例 1:

输入: [1,3,5,6], 5
输出: 2

示例 2:

输入: [1,3,5,6], 2
输出: 1

示例 3:

输入: [1,3,5,6], 7
输出: 4

示例 4:

输入: [1,3,5,6], 0
输出: 0


 * @author zhu
 *
 */
public class problem35 {
    public static int searchInsert(int[] nums, int target) {
        if(nums==null) {
        	return -1;
        }
        if(target>nums[nums.length-1]) {
        	return nums.length;
        }
        int left=0,right=nums.length-1;
        while(left<right) {
        	int mid=(left+right)/2;
        	if(nums[mid]==target) {
        		return mid;
        	}
        	if(nums[mid]>target) {
        		right=mid;
        	}else {
        		left=mid+1;
        	}
        }
        return left;
    }
	public static void main(String[] args) {
		int []nums= {1,3,5,6};
		System.out.println(searchInsert(nums, 7));
	}
}
