package leetcode;

public class MinPathSum {
    public int minPathSum(int[][] grid) {
        if(grid==null||grid.length==0) return 0;
        int m=grid.length,n=grid[0].length;
        int[] dp=new int[n];
        dp[0]=grid[0][0];
        for(int i=1;i<n;i++) dp[i]=dp[i-1]+grid[0][i];
        for(int i=1;i<m;i++){
            dp[0]+=grid[i][0];
            for(int j=1;j<n;j++){
                dp[j]=Math.min(dp[j],dp[j-1])+grid[i][j];
            }
        }
        return dp[n-1];
    }
}
