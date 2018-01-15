package com.algorithm.offer;

public class Match {
	 public static boolean match(char[] str, char[] pattern) {
		 if(str==null||pattern==null) {
			 return false;
		 }
		 return match(str,0,pattern,0);
	 }
	 public static boolean match(char[] str, int strIndex, char[] pattern, int patternIndex) {
	     //��Ч�Լ��飺str��β��pattern��β��ƥ��ɹ�
	     if (strIndex == str.length && patternIndex == pattern.length) {
	         return true;
	     }
	     //pattern�ȵ�β��ƥ��ʧ��
	     if (strIndex != str.length && patternIndex == pattern.length) {
	         return false;
	     }
	     //ģʽ��2����*�����ַ�����1����ģʽ��1��ƥ��,��3��ƥ��ģʽ���粻ƥ�䣬ģʽ����2λ
	     if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
	         if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)) {
	             return match(str, strIndex, pattern, patternIndex + 2)//ģʽ����2����Ϊx*ƥ��0���ַ�
	                     || match(str, strIndex + 1, pattern, patternIndex + 2)//��Ϊģʽƥ��1���ַ�
	                     || match(str, strIndex + 1, pattern, patternIndex);//*ƥ��1������ƥ��str�е���һ��
	         } else {
	             return match(str, strIndex, pattern, patternIndex + 2);
	         }
	     }
	     //ģʽ��2������*�����ַ�����1����ģʽ��1��ƥ�䣬�򶼺���1λ������ֱ�ӷ���false
	     if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)) {
	         return match(str, strIndex + 1, pattern, patternIndex + 1);
	     }
	     return false;
	  }
	 public static void main(String[] args) {
		char[] a= {'a','a','a'};
		char[] pattern= {'a','b','*','a','*','c','*','a'};
		System.out.println(match(a,pattern));
	}

	
}
