package com.zhu.practice;
/*
 * һֻ����һ�ο�������1��̨�ף�
 * Ҳ��������2���������������һ��n����̨���ܹ��ж���������
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
