package com.zhu.practice;
/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，
 * 请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序
 * ，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 * @author Administrator
 * 思路：模拟一下进栈出栈的过程，如果popA能遍历到最后一个数则return true
 */
public class IsPopOrder {
	public static boolean isPopOrder(int [] pushA,int [] popA) {
		if(pushA==null||popA==null||pushA.length!=popA.length)
			return false;
		int index=-1,indexB=0;
		int[] stack=new int[pushA.length];
		for(int i=0;i<pushA.length;i++){
			stack[++index]=pushA[i];
			while(index>-1&&stack[index]==popA[indexB]){
				indexB++;
				index--;
			}
		}
	    return indexB==popA.length;
    }
	public static void main(String[] args) {
		int[] array1={1,2,3,4,5};
		int[] array2={4,5,3,2,1};
		int []array3={4,3,5,1,2};
		int[] array4={1};
		int[] array5={1};
		System.out.println(isPopOrder(array1,array2));
		System.out.println(isPopOrder(array1,array3));
		System.out.println(isPopOrder(array4,array5));
	}
}
