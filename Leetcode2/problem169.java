package leetcode;
/**
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在众数。

示例 1:

输入: [3,2,3]
输出: 3

示例 2:

输入: [2,2,1,1,1,2,2]
输出: 2


 * @author zhu
 *
 */
public class problem169 {
    public static int majorityElement(int[] nums) {
    	int res=0,count=0;
        for(int i=0;i<nums.length;i++) {
        	if(count==0) {
        		res=nums[i];
        		count=1;
        	}else if(res==nums[i]){
        		count++;
        	}else {
        		count--;
        	}
        }
        return res;
    }
    public static void main(String[] args) {
    	//int[]nums= {2,2,1,1,1,2,2};
    	int[]nums= {3,3,4};
		System.out.println(majorityElement(nums));
	}
}
