package leetcode;
/**
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。

示例 1:

输入: [3,0,1]
输出: 2

示例 2:

输入: [9,6,4,2,3,5,7,0,1]
输出: 8

说明:
你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?

 * @author zhu
 *
 */
public class problem268 {
    public static int missingNumber(int[] nums) {
        int res=(nums.length+1)*nums.length/2;
        for(int i=0;i<nums.length;i++) {
        	res-=nums[i];
        }
        return res;
    }
    public static void main(String[] args) {
    	int[]nums= {0,2,3};
		System.out.println(missingNumber(nums));
	}
}
