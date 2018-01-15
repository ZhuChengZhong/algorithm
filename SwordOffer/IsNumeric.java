package com.algorithm.offer;
/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 *  但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * @author Zhu
 *
 */
public class IsNumeric {
	public static boolean isNumeric(char[] str) {
		boolean point=true;
		boolean e=true;
		for(int i=0;i<str.length;i++) {
			char c=str[i];
			if(c=='+'||c=='-') {
				//如果正负号不在第一个字符就返回false
				if(i==0) {
					continue;
				}
				return false;
			}else if(c=='e'||c=='E') {
				if(e) {
					if(i+1<str.length&&(str[i+1]=='-'||str[i+1]=='+')) {
						++i;
					}
					//如果e后没有数字则返回false
					if(i+1>=str.length) {
						return false;
					}
					//e后不能再出现小数点
					point=false;
					e=false;
				//一个数字不能出现2个e
				}else {
					return false;
				}
				
			}else if(c=='.') {
				if(point) {
					point=false;
					//一个数字只能出现一个点
				}else {
					return false;
				}
			}else if(!(c>='0'&&c<='9')) {
				return false;
			}
		}
        return true;
    }

	public static void main(String[] args) {
		String [] data= {"+100","5e2","-123","3.1416","-1E-16","12e","1a3.14","1.2.3","+-5","12e+4.3"};
		for(int i=0;i<data.length;i++) {
			char[] str=new char[data[i].length()];
			data[i].getChars(0, data[i].length(), str, 0);
			boolean result=isNumeric(str);
			System.out.println(result);
		}
	}
}
