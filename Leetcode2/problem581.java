package leetcode;
/**
 * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。

你找到的子数组应是最短的，请输出它的长度。

示例 1:

输入: [2, 6, 4, 8, 10, 9, 15]
输出: 5
解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。

说明 :

    输入的数组长度范围在 [1, 10,000]。
    输入的数组可能包含重复元素 ，所以升序的意思是<=。


 * @author zhu
 *
 */
public class problem581 {
    public static int findUnsortedSubarray(int[] nums) {
    	int len=nums.length;
        int left=1,right=0,max=nums[0],min=nums[len-1];
        for(int i=0;i<len;i++) {
        	if(nums[i]>max) {
        		max=nums[i];
        	}
        	if(nums[len-1-i]<min) {
        		min=nums[len-1-i];
        	}
        	if(nums[i]<max) {
        		right=i;
        	}
        	if(nums[len-1-i]>min) {
        		left=len-i-1;
        	}
        }
        return right-left+1;
    }
    public static void main(String[] args) {
    	//int[]nums= {2,6,4,8,10,9,15};
    	int[]nums= {1,2,3,4};
		System.out.println(findUnsortedSubarray(nums));
	}
}
