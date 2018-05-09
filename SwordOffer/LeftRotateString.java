package com.algorithm.offer;
/**
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，
 * 就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，
 * 请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,
 * 要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 * @author Zhu
 *
 */
public class LeftRotateString {
	public static String leftRotateString(String str,int n) {
		if(str==null||"".equals(str)) {
			return "";
		}
		int len=str.length();
		int k=n%len;
		String result=str.substring(k, len)+str.substring(0, k);
        return result;
    }
	public static void main(String[] args) {
		String result=leftRotateString("abcXYZdef",3);
		System.out.println(result);
	}
}
