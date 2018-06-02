package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。

示例 1 :

输入:nums = [1,1,1], k = 2
输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。

说明 :

    数组的长度为 [1, 20,000]。
    数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。


 * @author zhu
 *
 */
public class problem560 {
    public static int subarraySum(int[] nums, int k) {
    	if(nums==null||nums.length==0) {
    		return 0;
    	}
    	Map<Integer,Integer>map=new HashMap<>();
    	int sum=0,res=0;
    	map.put(0, 1);
    	for(int i=0;i<nums.length;i++) {
    		sum+=nums[i];
    		int key=sum-k;
    		if(map.containsKey(key)) {
    			res+=map.get(key);
    		}
    		if(map.containsKey(sum)) {
    			map.put(sum, map.get(sum)+1);
    		}else {
    			map.put(sum, 1);
    		}
    	}
    	return res;
    }
    public static void main(String[] args) {
		int[]nums= {-1,-1,0,1,1};
		System.out.println(subarraySum(nums, -1));
	}
}
