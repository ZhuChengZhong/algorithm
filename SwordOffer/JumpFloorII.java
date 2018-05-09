package com.zhu.practice;
/*
 * һֻ����һ�ο�������1��̨�ף�
 * Ҳ��������2��������Ҳ��������n����
 * �����������һ��n����̨���ܹ��ж���������
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
