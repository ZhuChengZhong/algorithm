package com.zhu.leetcode;
/**
 *  Say you have an array for which the i th element is the price of a given stock on day i.

Design an algorithm to find the maximum profit.
 You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again). 
 * @author Administrator
 *
 */
public class MaxProfit2 {
	 public int maxProfit(int[] prices) {
		 int pre,i=0,result=0;
	    while(i<prices.length){
	    	int min=prices[i++];
	    	while(i<prices.length){
	    		int t=prices[i];
	    		if(min<t){
	    			break;
	    		}
	    		++i;
	    		min=t;
	    	}
	    	if(i>=prices.length)
	    		break;
	    	int max=prices[i++];
	    	while(i<prices.length){
	    		int t=prices[i];
	    		if(max>t){
	    			break;
	    		}
	    		++i;
	    		max=t;
	    	}
	    	result+=max-min;
	    }
	    return result;
	 }
	 
	 public static void main(String[] args) {
		 int[] prices={1,2,3,6,6,3,4,5};
		int max=new MaxProfit2().maxProfit(prices);
		System.out.println(max);
	}
}
