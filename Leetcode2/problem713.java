package leetcode;
/**
 * 给定一个正整数数组 nums。

找出该数组内乘积小于 k 的连续的子数组的个数。

示例 1:

输入: nums = [10,5,2,6], k = 100
输出: 8
解释: 8个乘积小于100的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
需要注意的是 [10,5,2] 并不是乘积小于100的子数组。

说明:

    0 < nums.length <= 50000
    0 < nums[i] < 1000
    0 <= k < 10^6


 * @author zhu
 *
 */
public class problem713 {
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
    	if(k==0||k==1) {
    		return 0;
    	}
        int left=0;
        int res=0,sum=1;
        for(int i=0;i<nums.length;i++) {
        	sum*=nums[i];
        	while(sum>=k) {
    			sum/=nums[left++];
    		}
        	res+=i-left+1;
        }
        return res;
    }
    public static void main(String[] args) {
		int[]nums= {10,5,2,6};
		System.out.println(numSubarrayProductLessThanK(nums, 3));
	}
}
