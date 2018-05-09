package com.algorithm.offer;

import java.util.ArrayList;
/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的
 * @author Zhu
 * 思路：由于是排序数组，可将首尾两数相加，如果得到的数小于sum，就将左边小的数向右移，否则右边大的数向左移
 */
public class FindNumbersWithSum {
	public static ArrayList<Integer> findNumbersWithSum(int [] array,int sum) {
		ArrayList<Integer> result=new ArrayList<Integer>();
		int start=0,end=array.length-1;
		while(start<end) {
			int total=array[start]+array[end];
			if(total==sum) {
				result.add(array[start]);
				result.add(array[end]);
				break;
			}else if(total<sum) {
				start++;
			}else {
				end--;
			}
		}
        return result;
    }
	public static void main(String[] args) {
		int [] array= {1,2,4,5,7,10};
		System.out.println(findNumbersWithSum(array, 7));
	}
}
