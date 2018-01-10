package com.algorithm.offer;
/**
 * �����������һ����λָ�����ѭ�����ƣ�ROL���������и��򵥵�����
 * �������ַ���ģ�����ָ���������������һ���������ַ�����S��
 * �������ѭ������Kλ���������������磬�ַ�����S=��abcXYZdef��,
 * Ҫ�����ѭ������3λ��Ľ��������XYZdefabc�����ǲ��Ǻܼ򵥣�OK���㶨����
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
