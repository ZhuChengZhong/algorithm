package com.zhu.practice;
/**
 * ���������������У���һ�����б�ʾջ��ѹ��˳��
 * ���жϵڶ��������Ƿ�Ϊ��ջ�ĵ���˳��
 * ����ѹ��ջ���������־�����ȡ���������1,2,3,4,5��ĳջ��ѹ��˳��
 * ������4��5,3,2,1�Ǹ�ѹջ���ж�Ӧ��һ���������У�
 * ��4,3,5,1,2�Ͳ������Ǹ�ѹջ���еĵ������С���ע�⣺���������еĳ�������ȵģ�
 * @author Administrator
 * ˼·��ģ��һ�½�ջ��ջ�Ĺ��̣����popA�ܱ��������һ������return true
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
