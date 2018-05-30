package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个未排序的整数数组，找出最长连续序列的长度。

要求算法的时间复杂度为 O(n)。

示例:

输入: [100, 4, 200, 1, 3, 2]
输出: 4
解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。


 * @author zhu
 *
 */
public class problem128 {
    public static int longestConsecutive(int[] nums) {
        Set<Integer>set=new HashSet<>();
        for(int i=0;i<nums.length;i++) {
        	set.add(nums[i]);
        }
        int max=0;
        for(int i=0;i<nums.length;i++) {
        	if(set.contains(nums[i])) {
        		set.remove(nums[i]);
        		int sum=1;
        		int k=nums[i]+1;
        		while(true) {
        			if(set.contains(k)) {
        				sum++;
        				set.remove(k);
        				k++;
        			}else {
        				break;
        			}
        		}
        		k=nums[i]-1;
        		while(true) {
        			if(set.contains(k)) {
        				sum++;
        				set.remove(k);
        				k--;
        			}else {
        				break;
        			}
        		}
        		if(sum>max) {
        			max=sum;
        		}
        	}
        }
        return max;
    }
	public static void main(String[] args) {
		int[]arr= {100,4,200,1,3,2,4};
		System.out.println(longestConsecutive(arr));
	}
}
