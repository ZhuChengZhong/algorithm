package com.algorithm.offer;
/**
 * ����һ������A[0,1,...,n-1],�빹��һ������B[0,1,...,n-1],
 * ����B�е�Ԫ��B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]������ʹ�ó�����
 * @author Zhu
 *
 */
public class Multiply {
	public static int[] multiply(int[] A) {
		int len=A.length;
		int [] B=new int[len];
		if(len>0)
			B[0]=1;
		for(int i=1;i<len;i++) {
			B[i]=B[i-1]*A[i-1];
		}
		int number=1;
		for(int i=len-1;i>=1;i--) {
			number*=A[i];
			B[i-1]*=number;
		}
		return B;
    }
	public static void main(String[] args) {
		int []a= {1,2,3,4,5};
		int []b=multiply(a);
		for(int i=0;i<b.length;i++) {
			System.out.print(b[i]+" ");
		}
		System.out.println();
	}
}
