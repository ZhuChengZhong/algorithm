package com.zhu.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
/**
 *  Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]


The minimum path sum from top to bottom is11(i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle. 
 * @author Administrator
 *
 */
public class MinimumTotal {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
    	int row=triangle.size();
    	if(row==0)
    		return 0;
    	int col=triangle.get(row-1).size();
    	int [] dp=new int[col];
    	dp[0]=triangle.get(0).get(0);
    	for(int i=1;i<row;i++){
    		ArrayList<Integer>list=triangle.get(i);
    		dp[list.size()-1]=dp[list.size()-2]+list.get(list.size()-1);
    		for(int j=list.size()-2;j>=1;j--){
    			int t=list.get(j);
    			dp[j]=Math.min(dp[j],dp[j-1])+list.get(j);
    		}
    		dp[0]=dp[0]+list.get(0);
    	}
    	int min=dp[0];
    	for(int i=1;i<col;i++){
    		if(min>dp[i])
    			min=dp[i];
    	}
    	return min;
    }
    public static void main(String[] args) {
    	ArrayList<ArrayList<Integer>> triangle=new ArrayList<>();
    	//triangle.add(new ArrayList<Integer>(Arrays.asList(2)));
    	//triangle.add(new ArrayList<Integer>(Arrays.asList(3,4)));
    	//triangle.add(new ArrayList<Integer>(Arrays.asList(6,5,7)));
    	//triangle.add(new ArrayList<Integer>(Arrays.asList(4,1,8,3)));
		int min=new MinimumTotal().minimumTotal(triangle);
		System.out.println(min);
	}
}
