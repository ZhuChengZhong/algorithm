package com.algorithm.offer;
/**
 * ��һ���ַ���ת����һ��������Ҫ����ʹ���ַ���ת�������Ŀ⺯����
 *  ��ֵΪ0�����ַ�������һ���Ϸ�����ֵ�򷵻�0
 * @author Zhu
 *
 */
public class StrToInt {
	public static int strToInt(String str) {
        if(str==null||"".equals(str)) {
        	return 0;
        }
        //true��  false��
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
