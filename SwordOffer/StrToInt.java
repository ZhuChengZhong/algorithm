package com.algorithm.offer;
/**
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
 *  数值为0或者字符串不是一个合法的数值则返回0
 * @author Zhu
 *
 */
public class StrToInt {
	public static int strToInt(String str) {
        if(str==null||"".equals(str)) {
        	return 0;
        }
        //true正  false负
        boolean sign=true;
        int i=0;
        if(str.charAt(0)=='-') {
			sign=false;
			++i;
		}else if(str.charAt(0)=='+') {
			++i;
		}
        int result=0;
        for(;i<str.length();i++) {
        	char c=str.charAt(i);
        	if(c>='0'&&c<='9') {
        		result=result*10+str.charAt(i)-'0';
        	}else {
        		return 0;
        	}
        	
        }
        return sign?result:-result;
    }
	public static void main(String[] args) {
		int number=strToInt("-1a33");
		System.out.println(number);
	}
}
