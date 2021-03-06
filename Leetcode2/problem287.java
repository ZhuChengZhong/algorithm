package leetcode;
/**
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。

示例 1:

输入: [1,3,4,2,2]
输出: 2

示例 2:

输入: [3,1,3,4,2]
输出: 3

说明：

    不能更改原数组（假设数组是只读的）。
    只能使用额外的 O(1) 的空间。
    时间复杂度小于 O(n2) 。
    数组中只有一个重复的数字，但它可能不止重复出现一次。


 * @author zhu
 *
 */
public class problem287 {
    public static int findDuplicate(int[] nums) {
        int left=1,right=nums.length-1;
        while(left<right) {
        	int mid=(left+right)>>1;
        	int count=findcount(nums, mid);
        	if(count>mid) {
        		right=mid;
        	}else {
        		left=mid+1;
        	}
        }
        return left;
    }
    private static int findcount(int[]nums,int n) {
    	int res=0;
    	for(int i=0;i<nums.length;i++) {
    		if(nums[i]<=n) {
    			res++;
    		}
    	}
    	return res;
    }
    public static void main(String[] args) {
    	int[]nums= {1,3,4,2,2};
		System.out.println(findDuplicate(nums));
	}
}
