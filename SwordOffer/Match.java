package com.algorithm.offer;

public class Match {
	 public static boolean match(char[] str, char[] pattern) {
		 if(str==null||pattern==null) {
			 return false;
		 }
		 return match(str,0,pattern,0);
	 }
	 public static boolean match(char[] str, int strIndex, char[] pattern, int patternIndex) {
	     //有效性检验：str到尾，pattern到尾，匹配成功
	     if (strIndex == str.length && patternIndex == pattern.length) {
	         return true;
	     }
	     //pattern先到尾，匹配失败
	     if (strIndex != str.length && patternIndex == pattern.length) {
	         return false;
	     }
	     //模式第2个是*，且字符串第1个跟模式第1个匹配,分3种匹配模式；如不匹配，模式后移2位
	     if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
	         if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)) {
	             return match(str, strIndex, pattern, patternIndex + 2)//模式后移2，视为x*匹配0个字符
	                     || match(str, strIndex + 1, pattern, patternIndex + 2)//视为模式匹配1个字符
	                     || match(str, strIndex + 1, pattern, patternIndex);//*匹配1个，再匹配str中的下一个
	         } else {
	             return match(str, strIndex, pattern, patternIndex + 2);
	         }
	     }
	     //模式第2个不是*，且字符串第1个跟模式第1个匹配，则都后移1位，否则直接返回false
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
