package leetcode;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.

与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).


 * @author zhu
 *
 */
public class problem16 {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min=Integer.MAX_VALUE;
        int res=0;
        for(int i=0;i<nums.length;i++) {
        	if(i>0&&nums[i]==nums[i-1]) {
        		continue;
        	}
        	int left=i+1,right=nums.length-1;
        	while(left<right) {
        		if(right<nums.length-1&&nums[right]==nums[right+1]) {
        			right--;
        			continue;
        		}
        		int sum=nums[i]+nums[left]+nums[right];
        		if(sum==target) {
        			return sum;
        		}
        		if (sum<target) {
					left++;
				}else {
					right--;
				}
        		if(Math.abs(target-sum)<min) {
        			min=Math.abs(target-sum);
        			res=sum;
        		}
        	}
        }
        return res;
    }
    public static void main(String[] args) {
    	int []nums= {-1,2,1,-4};
		System.out.println(threeSumClosest(nums,1));
	}
}
