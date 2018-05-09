package com.zhu.practice;
/*
 * 一只青蛙一次可以跳上1级台阶，
 * 也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法
 * */
public class JumpFloor {
	public static int jumpFloor(int target) {
		int result=0;
		int count1=1,count2=2;
		if(target==0||target==1){
			return target;
		}
		if(target==2){
			return count2;
		}
		for(int i=3;i<=target;i++){
			result=count1+count2;
			count1=count2;
			count2=result;
		}
		return result;
    }
	public static void main(String[] args) {
		for(int i=0;i<=10;i++){
			System.out.println(jumpFloor(i));
		}
	}
}
