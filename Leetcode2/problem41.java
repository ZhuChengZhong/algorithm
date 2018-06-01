package leetcode;
/**
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。

示例 1:

输入: [1,2,0]
输出: 3

示例 2:

输入: [3,4,-1,1]
输出: 2

示例 3:

输入: [7,8,9,11,12]
输出: 1

说明:

你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。

 * @author zhu
 *
 */
public class problem41 {
    public static int firstMissingPositive(int[] nums) {
        for(int i=0;i<nums.length;i++) {
        	int val=nums[i];
        	while(val>0&&val<=nums.length&&val-1!=i&&nums[val-1]!=val) {
        		int index=val-1;
        		int temp=nums[index];
        		nums[index]=val;
        		val=temp;
        	}
        	nums[i]=val;
        }
        for(int i=0;i<nums.length;i++) {
        	if(nums[i]!=i+1) {
        		return i+1;
        	}
        }
        return nums.length+1;
    }
    public static void main(String[] args) {
    	//int[]nums= {1,3,0};
    	//int[]nums= {7,8,9,11,12};
    	//int[]nums= {3,4,-1,1};
    	int[]nums= {1};
		System.out.println(firstMissingPositive(nums));
	}
}
