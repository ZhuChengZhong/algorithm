package com.algorithm.offer;
/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * @author Zhu
 *思路：利用位运算解决 ，因为在二进制中0+0=0，0+1=1，1+0=1，1+1=10
 *可以看出在不进位的情况下二进制相加的结果等于 异或运算的结果，那什么情况下会进位呢？
 *只有在1+1的情况下才会进位，所以可以用   与  运算得出的结果 向左移一位（<<1相当于*2 )就是所有进位的值
 *结果=异或的结果+与运算的结果<<1 ，因为不能相加，所以还要重复以上操作，直到
 */
public class Add {
	public static int add(int num1,int num2) {
		int xor,and;
        do{
        	xor=num1^num2;
            and=num1&num2;
            num1=xor;
            num2=and<<1;
        }while(num2!=0);
        return num1;
    }
	public static void main(String[] args) {
		System.out.println(add(5,34));
	}
}
