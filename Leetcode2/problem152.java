package leetcode;
/**
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。

示例 1:

输入: [2,3,-2,4]
输出: 6
解释: 子数组 [2,3] 有最大乘积 6。

示例 2:

输入: [-2,0,-1]
输出: 0
解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。


 * @author zhu
 *
 */
public class problem152 {
    public static int maxProduct(int[] nums) {
        int[] dp=new int[nums.length+1];
        dp[0]=nums[0];
        int max=dp[0];
        int min=dp[0];
        for(int i=1;i<nums.length;i++) {
        	dp[i]=Math.max(max*nums[i],min*nums[i]);
        	dp[i]=Math.max(dp[i],nums[i]);
        	min=Math.min(max*nums[i], min*nums[i]);
        	min=Math.min(min,nums[i]);
        	max=dp[i];
        }
        int res=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++) {
        	if(dp[i]>res) {
        		res=dp[i];
        	}
        }
        return res;
    }
    public static void main(String[] args) {
    	int[] nums= {-2,0,-1};
		System.out.println(maxProduct(nums));
	}
}
