package com.algorithm.offer;
/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
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
