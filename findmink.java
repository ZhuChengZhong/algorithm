package com.zhu.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class findmink {
	/**
	 * 快速排序
	 * @param array
	 */
	public static void quicksort(int[] array) {
		if(array==null) {
			return ;
		}
		int pos=partten(array, 0, array.length-1);
		
	}
	public static void quicksort(int[] array,int start,int end) {
		if(start>=end) {
			return ;
		}
		int pos=partten(array, start, end);
		quicksort(array, start, pos-1);
		quicksort(array,pos+1,end);
	}
	public static int partten(int[] array,int start,int end){
		int left=start-1,right;
		int pos=randomInRange(start, end);
		int target=array[pos];
		swap(array, pos, end);
		for(right=start;right<=end;right++) {
			if(array[right]<target) {
				swap(array, ++left, right);
			}
		}
		swap(array, ++left, end);
		return left;
	}
	private static int randomInRange(int start,int end) {
		Random r=new Random();
		return r.nextInt(end+1-start)+start;
	}
	private static void swap(int [] array,int s1,int s2) {
		if(array==null) {
			return ;
		}
		int temp=array[s1];
		array[s1]=array[s2];
		array[s2]=temp;
	}
	/**
	 * 寻找前k小数
	 * @param array
	 * @param k
	 * @return
	 */
	public static List<Integer> findk(int []array,int k){
		if(array==null||k<=0||k>array.length) {
			return new ArrayList<>();
		}
		findk(array, 0, array.length-1, k);
		ArrayList<Integer>res=new ArrayList<>();
		for(int i=0;i<k;i++) {
			res.add(array[i]);
		}
		return res;
	}
	private static void findk(int[] array,int start,int end,int k) {
		int pos=partten(array, start, end);
		if(pos==k) {
			return ;
		}else if(pos<k) {
			findk(array, pos+1, end,k);
		}else {
			findk(array,start,pos-1,k);
		}
	}
	public static void main(String[] args) {
		int [] array= {5,4,2,1,7,8,4,6,3};
		/*Arrays.sort(array);
		String s=Arrays.toString(array);
		System.out.println(s);*/
		//int pos=partten(array, 0, array.length-1);
		//quicksort(array, 0, array.length-1);
		//System.out.println(Arrays.toString(array));
		System.out.println(findk(array, 2));
		
	}
}
