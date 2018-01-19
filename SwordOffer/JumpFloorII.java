package com.zhu.practice;
/*
 * 一只青蛙一次可以跳上1级台阶，
 * 也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法
 * */
public class JumpFloorII {
	public static int jumpFloorII(int target) {
		if(target<0){
			return -1;
		}
		int[] dp=new int[target+3];
		dp[0]=0;
		dp[1]=1;
		dp[2]=2;
		for(int i=3;i<=target;i++){
			dp[i]=dp[i-1]*2;
		}
        return dp[target];
    }
	public static void main(String[] args) {
		for(int i=0;i<=10;i++){
			System.out.println(jumpFloorII(i));
		}
	}
}
