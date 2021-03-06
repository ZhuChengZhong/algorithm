package leetcode;
/**
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。

具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。

示例 1:

输入: "abc"
输出: 3
解释: 三个回文子串: "a", "b", "c".

示例 2:

输入: "aaa"
输出: 6
说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".

 * @author zhu
 *
 */
public class problem647 {
    public static int countSubstrings(String s) {
    	if(s==null||s.length()==0) {
    		return 0;
    	}
    	int len=s.length();
    	boolean[][]dp=new boolean[len][len];
    	for(int k=0;k<len;k++) {
    		for(int i=0;i<len-k;i++) {
    			int j=i+k;
    			if(s.charAt(i)==s.charAt(j)&&(i+1>j-1||dp[i+1][j-1])) {
    				dp[i][j]=true;
    			}
    		}
    	}
    	int res=0;
    	for(int i=0;i<len;i++) {
    		for(int j=i;j<len;j++) {
    			if(dp[i][j]) {
    				res++;
    			}
    		}
    	}
    	return res;
    }
    public static void main(String[] args) {
		System.out.println(countSubstrings("aaaa"));
	}
}
