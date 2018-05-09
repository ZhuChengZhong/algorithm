package com.algorithm.offer;
/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字
 * @author Zhu
 *相同的两个数异或结果为0，整个数组异或的结果是两个不相等的数异或的结果，然后找到异或结果中，二进制位为
 *1的位作为分隔数组的数，可将一个数组分隔成两个数组，并且能保证两个相同的数会被分到一个数组，并且不同的
 *那两个数字会被分到不同的数组，然后在两个数组中分别异或的结果就是那两个不同的数字
 */
public class FindNumsAppearOnce {
	//num1,num2分别为长度为1的数组。传出参数
	//将num1[0],num2[0]设置为返回结果
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
