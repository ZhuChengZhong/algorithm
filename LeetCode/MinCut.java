package com.zhu.leetcode;
/**
 *  Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s ="aab",
Return1since the palindrome partitioning["aa","b"]could be produced using 1 cut. 
 * @author Administrator
 *
 */
public class MinCut {
    public int minCut(String s) {
        int len=s.length();
        boolean p[][]=new boolean[len][len];
        int [] dp=new int[len+1];
        dp[len]=-1;
        for(int i=len-1;i>=0;i--)
        	dp[i]=len-i-1;
        for(int i=len-1;i>=0;i--){
        	for(int j=i;j<len;j++){
        		if(s.charAt(i)==s.charAt(j)&&(j-i<=2||p[i+1][j-1])){
        			p[i][j]=true;
        			dp[i]=min(dp[i],dp[j+1]+1);
        		}
        	}
        }
        return dp[0];
    }
    private int min(int x,int y){
    	return x<y?x:y;
    }
    public static void main(String[] args) {
		String s="abbab";
		int cut=new MinCut().minCut(s);
		System.out.println(cut);
	}
}
