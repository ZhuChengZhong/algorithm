package com.zhu.leetcode;
/**
 *  Say you have an array for which the i th element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again). 
 * @author Administrator
 *
 */
public class MaxProfit {
    public static int maxProfit(int[] prices) {
    	int hold1,hold2,release1=0,release2=0;
    	hold1=Integer.MIN_VALUE;
    	hold2=hold1;
       for(int i=0;i<prices.length;i++){
    	   int t=prices[i];
    	   release2=Math.max(release2,hold2+t);
    	   hold2=Math.max(hold2,release1-t);
    	   release1=Math.max(release1,hold1+t);
    	   hold1=Math.max(hold1,-t);
       }
       return release2;
    }
    public static void main(String[] args) {
		//int []prices={5,2,7,5,9};
		int []prices={1,2};
		System.out.println(maxProfit(prices));
	}
}
