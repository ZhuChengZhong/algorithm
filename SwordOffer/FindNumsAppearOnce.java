package com.algorithm.offer;
/**
 * һ�����������������������֮�⣬���������ֶ����������Ρ���д�����ҳ�������ֻ����һ�ε�����
 * @author Zhu
 *��ͬ�������������Ϊ0�������������Ľ������������ȵ������Ľ����Ȼ���ҵ�������У�������λΪ
 *1��λ��Ϊ�ָ�����������ɽ�һ������ָ����������飬�����ܱ�֤������ͬ�����ᱻ�ֵ�һ�����飬���Ҳ�ͬ��
 *���������ֻᱻ�ֵ���ͬ�����飬Ȼ�������������зֱ����Ľ��������������ͬ������
 */
public class FindNumsAppearOnce {
	//num1,num2�ֱ�Ϊ����Ϊ1�����顣��������
	//��num1[0],num2[0]����Ϊ���ؽ��
	public static void findNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int xorResult=0;
        for(int i=0;i<array.length;i++) {
        	xorResult^=array[i];
        }
        int separator=1;
        while(xorResult>0){
        	if((xorResult&1)!=0) {
        		break;
        	}
        	separator=separator<<1;
        	xorResult=xorResult>>1;
        }
        int xor1=0,xor2=0;
        for(int i=0;i<array.length;i++) {
        	if((array[i]&separator)>0) {
        		xor1^=array[i];
        	}else {
        		xor2^=array[i];
        	}
        }
        num1[0]=xor1;
        num2[0]=xor2;
    }
	public static void main(String[] args) {
		int[] array= {1,2,3,4,5,1,2,3};
		int[] num1=new int[2];
		int[] num2=new int[2];
		findNumsAppearOnce(array,num1,num2);
		System.out.println(num1[0]+":"+num2[0]);
	}
}
