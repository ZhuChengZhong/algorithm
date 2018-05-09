package com.zhu.leetcode;
/**
 *  Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie,"ACE"is a subsequence of"ABCDE"while"AEC"is not).

Here is an example:
S ="rabbbit", T ="rabbit"

Return3. 
 * @author Administrator
 *
 */
public class NumDistinct {
    public int numDistinct(String S, String T) {
    	if ("".equals(S)||"".equals(T)||S==null||T==null) {
    		return 0;
    	}
    	int slen=S.length();
    	int tlen=T.length();
    	
    	int [][]dp=new int[tlen+1][slen+1];
    	for(int i=1;i<=tlen;i++){
    		for(int j=i;j<=slen;j++){
    			if(T.charAt(i-1)==S.charAt(j-1)){
    				if(i==1){
    					dp[1][j]=dp[1][j-1]+1;
    				}else{
    					dp[i][j]=dp[i-1][j-1]+dp[i][j-1];
    				}
    			}
    			else{
    				dp[i][j]=dp[i][j-1];    				
    			}
    		}
    	}
        return dp[tlen][slen];
    }
    public static void main(String[] args) {
		int count=new NumDistinct().numDistinct("rabbbit", "rabbit");
		//int count=new NumDistinct().numDistinct("ddd", "dd");
		System.out.println(count);
	}
}
