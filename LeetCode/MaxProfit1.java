package com.zhu.leetcode;
/**
 *  Say you have an array for which the i th element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit. 
 * @author Administrator
 *
 */
public class MaxProfit1 {
    public int maxProfit(int[] prices) {
    	int hold=Integer.MIN_VALUE,release=0;
    	for(int i=0;i<prices.length;i++){
    		int t=prices[i];
    		release=Math.max(release, hold+t);
    		hold=Math.max(hold,-t);
    	}
        return release;
    }
    public static void main(String[] args) {
		int [] prices={2,1};
		int max=new MaxProfit1().maxProfit(prices);
		System.out.println(max);
	}
}
