package leetcode;
/**
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：

'A' -> 1
'B' -> 2
...
'Z' -> 26

给定一个只包含数字的非空字符串，请计算解码方法的总数。

示例 1:

输入: "12"
输出: 2
解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。

示例 2:

输入: "226"
输出: 3
解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。


 * @author zhu
 *
 */
public class problem91 {
	private static int count=0;
    public static int numDecodings(String s) {
    	if(s==null||s.length()==0||s.charAt(0)=='0') {
    		return 0;
    	}
    	count=0;
    	numDecodings(s,0);
    	return count;
    }
    public static void numDecodings(String s,int index) {
    	if(index==s.length()) {
    		count++;
    		return ;
    	}
    	int sum=0;
        for(int i=index;i<s.length();i++) {
        	sum=sum*10+s.charAt(i)-'0';
        	if(sum>26) {
        		break;
        	}
        	if(sum==0) {
        		return ;
        	}
        	numDecodings(s,i+1);
        }
    }
    public static void main(String[] args) {
		System.out.println(numDecodings("101"));
		System.out.println(numDecodings("12"));
		System.out.println(numDecodings("226"));
		System.out.println(numDecodings("01"));
	}
}
