package com.algorithm.offer;
/*
 * ţ���������һ����Ա��Fish��ÿ���糿���ǻ�����һ��Ӣ����־��
 * дЩ�����ڱ����ϡ�ͬ��Cat��Fishд�������ĸ���Ȥ����һ������Fish����������
 * ��ȴ������������˼�����磬��student. a am I������������ʶ����
 * ��һ�ԭ���Ѿ��ӵ��ʵ�˳��ת�ˣ���ȷ�ľ���Ӧ���ǡ�I am a student.����
 * Cat��һһ�ķ�ת��Щ����˳��ɲ����У����ܰ�����ô��
 * 
 * ˼·���Ƚ��������ӷ�ת���ٽ�ÿ�����ʷ�ת���ǽ��
 * */

public class ReverseSentence {
	public static String reverseSentence(String str) {
		char[] chars=new char[str.length()];
        str.getChars(0, str.length(),chars,0);
        int start=0,end=str.length()-1;
        reverse(chars,start,end);
        int begin=0;
        for(int i=0;i<=str.length();i++) {
        	if(i==str.length()||chars[i]==' ') {
        		reverse(chars,begin,i-1);
        		begin=i+1;
        	}
        	
        }
        return new String(chars);
    }
	private static void reverse(char[] chars,int start,int end) {	 
        while(start<end) {
        	char temp=chars[start];
        	chars[start]=chars[end];
        	chars[end]=temp;
        	start++;
        	end--;
        }
	}
	public static void main(String[] args) {
		String result=reverseSentence("I am a student.");
		System.out.println(result);
	}
}
