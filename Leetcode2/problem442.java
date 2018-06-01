package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。

找到所有出现两次的元素。

你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？

示例：

输入:
[4,3,2,7,8,2,3,1]

输出:
[2,3]


 * @author zhu
 *
 */
public class problem442 {
    public static List<Integer> findDuplicates(int[] nums) {
        for(int i=0;i<nums.length;i++) {
        	int val=nums[i];
        	while(val-1!=i&&nums[val-1]!=val) {
        		int index=val-1;
        		int temp=nums[index];
        		nums[index]=val;
        		val=temp;
        	}
        	nums[i]=val;
        }
        List<Integer>res=new ArrayList<>();
        for(int i=0;i<nums.length;i++) {
        	if(nums[i]!=i+1) {
        		res.add(nums[i]);
        	}
        }
        return res;
    }
    public static void main(String[] args) {
		//int[]nums= {4,3,2,7,8,2,3,1};
		int[]nums= {2,1};
		List<Integer>res=findDuplicates(nums);
		System.out.println(res);
	}
}
