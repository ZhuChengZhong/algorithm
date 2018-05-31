package leetcode;

import java.util.Arrays;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

示例 1:

输入: [1,2,3,4,5,6,7] 和 k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右旋转 1 步: [7,1,2,3,4,5,6]
向右旋转 2 步: [6,7,1,2,3,4,5]
向右旋转 3 步: [5,6,7,1,2,3,4]

示例 2:

输入: [-1,-100,3,99] 和 k = 2
输出: [3,99,-1,-100]
解释: 
向右旋转 1 步: [99,-1,-100,3]
向右旋转 2 步: [3,99,-1,-100]

说明:

    尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
    要求使用空间复杂度为 O(1) 的原地算法。


 * @author zhu
 *
 */
public class problem189 {
    public static void rotate(int[] nums, int k) {
    	int len=nums.length;
    	int left=0,right=len-1;
    	k=k%len;
    	reverse(nums, left, right);
    	reverse(nums, 0, k-1);
    	reverse(nums, k, right);
    }
    private static void reverse(int[]nums,int left,int right) {
    	while(left<right) {
    		swap(nums, left, right);
    		left++;
    		right--;
    	}
    }
    private static void swap(int []nums,int i,int j) {
    	int temp=nums[i];
    	nums[i]=nums[j];
    	nums[j]=temp;
    }
    public static void main(String[] args) {
    	int[]nums= {1,2,3,4,5,6,7};
    	rotate(nums, 1);
		System.out.println(Arrays.toString(nums));
	}
}
