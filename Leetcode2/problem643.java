package leetcode;
/**
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。

示例 1:

输入: [1,12,-5,-6,50,3], k = 4
输出: 12.75
解释: 最大平均数 (12-5-6+50)/4 = 51/4 = 12.75

 

注意:

    1 <= k <= n <= 30,000。
    所给数据范围 [-10,000，10,000]。


 * @author zhu
 *
 */
public class problem643 {
    public static double findMaxAverage(int[] nums, int k) {
    	int i=0;
    	int max=Integer.MIN_VALUE;
    	int sum=0;
        for(i=0;i<k;i++) {
        	sum+=nums[i];
        }
        max=sum;
        for(i=k;i<nums.length;i++) {
        	sum+=nums[i];
        	sum-=nums[i-k];
        	if(sum>max) {
        		max=sum;
        	}
        }
        return max*1.0/k;
    }
    public static void main(String[] args) {
    	int []nums= {1,12,-5,-6,50,3};
		System.out.println(findMaxAverage(nums, 4));
	}
}
