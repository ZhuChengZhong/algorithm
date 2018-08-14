package leetcode;

public class problem72 {
    public static int minDistance(String word1, String word2) {
        int m=word1.length(),n=word2.length();
        int[][] dp=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
        	dp[i][0]=i;
        }
        for(int i=0;i<=n;i++){
        	dp[0][i]=i;
        }
        for(int i=1;i<=m;i++){
        	for(int j=1;j<=n;j++){
        		char a=word1.charAt(i-1);
        		char b=word2.charAt(j-1);
        		int min=dp[i-1][j-1];
        		if(a!=b){
        			min++;
        		}
        		min=Math.min(min, dp[i-1][j]+1);
        		min=Math.min(min, dp[i][j-1]+1);
        		dp[i][j]=min;
        	}
        }
        return dp[m][n];
    }
    public static void main(String[] args) {
    	String word1="intention";
    	String word2="execution";
		int min=minDistance(word1, word2);
		System.out.println(min);
	}
}
