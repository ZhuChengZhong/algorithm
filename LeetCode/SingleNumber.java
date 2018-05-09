package com.zhu.leetcode;
/**
 *  Given an array of integers, every element appears three
 *   times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity.
 Could you implement it without using extra memory? 
 * @author Administrator
 *
 */
public class SingleNumber {
	  public static int singleNumber(int[] A) {
		  int once=0;
		  int twice=0;
		  int three=0;
		  for(int i=0;i<A.length;i++){
			  int t=A[i];
			  twice|=once&t;
			  once^=t;
			  three=once&twice;
			  once^=three;
			  twice^=three;
		  }
		  return once;
	  }
	  public static void main(String[] args) {
		int[] array={1,2,3,3,2,5,1,2,3,1};
		System.out.println(singleNumber(array));
	}
}
