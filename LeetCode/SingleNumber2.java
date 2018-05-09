package com.zhu.leetcode;

public class SingleNumber2 {
    public static int singleNumber(int[] A) {
        int num=0;
        for(int i=0;i<A.length;i++){
        	int t=A[i];
        	num^=t;
        }
        return num;
    }
    public static void main(String[] args) {
		int [] array={1,2,3,4,5,5,4,7,3,2,1};
		System.out.println(singleNumber(array));
	}
}
