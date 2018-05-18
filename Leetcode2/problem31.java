package leetcode;

import java.util.Arrays;

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

必须原地修改，只允许使用额外常数空间。

以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

 * @author zhu
 *
 */
public class problem31 {
    public static void nextPermutation(int[] nums) {
    	int left=0,right=nums.length-1;
    	int index=0;
        for(int i=nums.length-1;i>=1;i--) {
        	if(nums[i]>nums[i-1]) {
        		index=i-1;
        		left=i;
        		break;
        	}
        }
        for(int i=right;i>=left;i--) {
        	if(nums[index]<nums[i]) {
        		int temp=nums[index];
        		nums[index]=nums[i];
        		nums[i]=temp;
        		break;
        	}
        }
        while(left<right) {
        	int temp=nums[left];
    		nums[left]=nums[right];
    		nums[right]=temp;
    		++left;
    		--right;
        }
    }
    public static void main(String[] args) {
		int []nums= {1,2,3};
		//int []nums= {3,2,1};
		//int []nums= {5,1,1};
		nextPermutation(nums);
		System.out.println(Arrays.toString(nums));
	}
}
