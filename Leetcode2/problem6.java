package leetcode;
/**
 * 将字符串 "PAYPALISHIRING" 以Z字形排列成给定的行数：

P   A   H   N
A P L S I I G
Y   I   R

之后从左往右，逐行读取字符："PAHNAPLSIIGYIR"

实现一个将字符串进行指定行数变换的函数:

string convert(string s, int numRows);

示例 1:

输入: s = "PAYPALISHIRING", numRows = 3
输出: "PAHNAPLSIIGYIR"

示例 2:

输入: s = "PAYPALISHIRING", numRows = 4
输出: "PINALSIGYAHRPI"
解释:

P     I    N
A   L S  I G
Y A   H R
P     I


 * @author zhu
 *
 */
public class problem6 {
    public static String convert(String s, int numRows) {
    	if(numRows==1) {
    		return s;
    	}
    	StringBuilder sb=new StringBuilder();
    	int n=numRows*2-2;
    	for(int i=1;i<=numRows;i++) {
    		int t=2*numRows-2*i;
    		t=n-t;
    		for(int j=i;j<=s.length();j+=t) {
    			sb.append(s.charAt(j-1));
    			if(n!=t) {
    				t=n-t;
    			}
    		}
    	}
        return sb.toString();
    }
    public static void main(String[] args) {
		System.out.println(convert("PAYPALISHIRING", 2));
	}
}
