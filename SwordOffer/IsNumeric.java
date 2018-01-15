package com.algorithm.offer;
/**
 * ��ʵ��һ�����������ж��ַ����Ƿ��ʾ��ֵ������������С������
 * ���磬�ַ���"+100","5e2","-123","3.1416"��"-1E-16"����ʾ��ֵ��
 *  ����"12e","1a3.14","1.2.3","+-5"��"12e+4.3"�����ǡ�
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
				//��������Ų��ڵ�һ���ַ��ͷ���false
				if(i==0) {
					continue;
				}
				return false;
			}else if(c=='e'||c=='E') {
				if(e) {
					if(i+1<str.length&&(str[i+1]=='-'||str[i+1]=='+')) {
						++i;
					}
					//���e��û�������򷵻�false
					if(i+1>=str.length) {
						return false;
					}
					//e�����ٳ���С����
					point=false;
					e=false;
				//һ�����ֲ��ܳ���2��e
				}else {
					return false;
				}
				
			}else if(c=='.') {
				if(point) {
					point=false;
					//һ������ֻ�ܳ���һ����
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
