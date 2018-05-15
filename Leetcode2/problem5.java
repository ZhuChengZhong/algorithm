package leetcode;
/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba"也是一个有效答案。

示例 2：

输入: "cbbd"
输出: "bb"


 * @author zhu
 *
 */
public class problem5 {
    public static String longestPalindrome(String s) {
    	if(s==null||s.length()==0) {
    		return "";
    	}
    	int len=s.length();
    	boolean [][]dp=new boolean[len][len];
    	int max=1,l=0,r=0;
    	for(int w=0;w<len;w++) {
    		for(int i=0;i<len-w;i++) {
    			int j=i+w;
    			if(w==0) {
    				dp[i][i+w]=true;
    			}else {
    				if(s.charAt(i)==s.charAt(j)) {
    					if(i+1==j||dp[i+1][j-1]) {
    						dp[i][j]=true;
    						if(j-i+1>max) {
    							max=j-i+1;
    							l=i;
    							r=j;
    						}
    					}
    				}
    			}
    		}
    	}
        return s.substring(l, r+1);
    }
    
    public static String longestPalindrome2(String s) {
    	if(s==null||s.length()==0) {
    		return "";
    	}
    	StringBuilder sb=new StringBuilder();
    	sb.append("$");
    	for(int i=0;i<s.length();i++) {
    		sb.append("#");
    		sb.append(s.charAt(i));
    	}
    	sb.append("#");
    	sb.append("!");
    	String ss=sb.toString();
    	int []p=new int[ss.length()+1];
    	int id=0;
    	int mx=0;
    	int max=0;
    	for(int i=1;i<ss.length()-1;i++) {
    		if(i<mx) {
    			p[i]=Math.min(p[2*id-i],mx-i);
    		}
    		while(ss.charAt(i-p[i]-1)==ss.charAt(i+p[i]+1)) {
    			p[i]++;
    		}
    		if(mx<i+p[i]) {
    			id=i;
    			mx=i+p[i];
    		}
    		if(p[i]>p[max]) {
    			max=i;
    		}
    	}
    	StringBuilder res=new StringBuilder();
    	for(int i=max-p[max];i<=max+p[max];i++) {
    		if(ss.charAt(i)!='#') {
    			res.append(ss.charAt(i));
    		}
    	}
    	return res.toString();
    }
    public static void main(String[] args) {
		System.out.println(longestPalindrome2("ac"));
	}
}
