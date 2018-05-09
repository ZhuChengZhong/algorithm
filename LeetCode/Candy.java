package com.zhu.leetcode;
/**
 * 

There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

    Each child must have at least one candy.
    Children with a higher rating get more candies than their neighbors. 

What is the minimum candies you must give? 
 */
import java.util.Arrays;

public class Candy {
	 public static int candy(int[] ratings) {
		    if(ratings==null || ratings.length==0) {
	             return 0;
	         }
	          
	         int[] count = new int[ratings.length];
	         //每个孩子初始都有一个糖果
	         Arrays.fill(count,1);
	         int sum = 0;
	         for(int i=1;i<ratings.length;i++) {
	             if(ratings[i]>ratings[i-1]) {
	                 count[i] = count[i-1]+1;
	             }
	         }
	          
	         for(int i=ratings.length-1;i>0;i--) {
	             sum+=count[i];
	             if(ratings[i]<ratings[i-1] && count[i]>=count[i-1]) {
	                 count[i-1] = count[i]+1;
	             }
	         }
	         sum+=count[0];
	          
	         return sum;
	 }
	 
	 public static void main(String[] args) {
		 int [] array={1,6,2,3,5,3};
		System.out.println(candy(array));
	}
}
