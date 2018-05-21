package leetcode;
/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

说明：每次只能向下或者向右移动一步。

示例:

输入:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 7
解释: 因为路径 1→3→1→1→1 的总和最小。


 * @author zhu
 *
 */
public class problem64 {
    public static int minPathSum(int[][] grid) {
    	if(grid==null||grid[0].length==0) {
    		return 0;
    	}
    	int m=grid.length;
    	int n=grid[0].length;
    	  int [][]dp=new int[m][n];
          dp[0][0]=grid[0][0];
          for(int i=0;i<m;i++) {
          	for(int j=0;j<n;j++) {
          		if(i-1>=0&&j-1>=0) {
          			dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
          		}else if(i-1>=0) {
          			dp[i][j]=dp[i-1][j]+grid[i][j];
          		}else if(j-1>=0) {
          			dp[i][j]=dp[i][j-1]+grid[i][j];
          		}
          	}
          }
          return dp[m-1][n-1];
    }
    public static void main(String[] args) {
		int [][]grid= {
				 {1,3,1},
				  {1,5,1},
				  {4,2,1}
		};
		System.out.println(minPathSum(grid));
	}
}
