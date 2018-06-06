package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给出一个由无重复的正整数组成的集合, 找出其中最大的整除子集, 子集中任意一对 (Si, Sj) 都要满足: Si % Sj = 0 或 Sj % Si = 0。

如果有多个目标子集，返回其中任何一个均可。

示例 1:

集合: [1,2,3]

结果: [1,2] (当然, [1,3] 也正确)

 示例 2:

集合: [1,2,4,8]

结果: [1,2,4,8]

 * @author zhu
 *
 */
public class problem368 {
    public static List<Integer> largestDivisibleSubset(int[] nums) {
    	 LinkedList<Integer>list=new LinkedList<>();
    	if(nums==null||nums.length==0) {
    		return list;
    	}
    	Arrays.sort(nums);
        int len=nums.length;
        int[]dp=new int[len];
        int[]pre=new int[len];
        dp[0]=1;
        pre[0]=-1;
        int max=0,index=0;
        for(int i=1;i<len;i++) {
        	dp[i]=1;
        	pre[i]=-1;
        	for(int j=0;j<i;j++) {
        		if(nums[i]%nums[j]==0) {
            		if(dp[j]+1>dp[i]) {
            			dp[i]=dp[j]+1;
            			pre[i]=j;
            		}
            	}
        	}
        	if(dp[i]>max) {
        		max=dp[i];
        		index=i;
        	}
        }
        while(pre[index]!=-1) {
        	list.addFirst(nums[index]);
        	index=pre[index];
        }
        list.addFirst(nums[index]);
        return list;
    }
    public static void main(String[] args) {
    	//int[]nums= {1,16,2,3,4,8};
    	int[]nums= {1,2,3};
		System.out.println(largestDivisibleSubset(nums));
	}
}
