package leetcode;
/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的子数组。如果不存在符合条件的子数组，返回 0。

示例: 

输入: s = 7, nums = [2,3,1,2,4,3]
输出: 2
解释: 子数组 [4,3] 是该条件下的长度最小的子数组。

进阶:

如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。

 * @author zhu
 *
 */
public class problem209 {
    public static int minSubArrayLen(int s, int[] nums) {
    	int res=Integer.MAX_VALUE;
    	int sum=0;
    	int start=0;
        for(int i=0;i<nums.length;i++) {
        	sum+=nums[i];
    		while(sum>=s) {
    			res=Math.min(i-start+1,res);
    			sum-=nums[start++];
    		}
        }
        return res==Integer.MAX_VALUE?0:res;
    }
    public static void main(String[] args) {
    	int[]nums= {2,3,1,2,4,3};
		System.out.println(minSubArrayLen(7, nums));
	}
}
