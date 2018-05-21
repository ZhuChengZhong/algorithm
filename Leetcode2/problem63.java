package leetcode;
/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？

网格中的障碍物和空位置分别用 1 和 0 来表示。

说明：m 和 n 的值均不超过 100。

示例 1:

输入:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
输出: 2
解释:
3x3 网格的正中间有一个障碍物。
从左上角到右下角一共有 2 条不同的路径：
1. 向右 -> 向右 -> 向下 -> 向下
2. 向下 -> 向下 -> 向右 -> 向右


 * @author zhu
 *
 */
public class problem63 {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	if(obstacleGrid==null||obstacleGrid.length==0) {
    		return 0;
    	}
    	int m=obstacleGrid.length;
    	int n=obstacleGrid[0].length;
    	if(obstacleGrid[0][0]==1||obstacleGrid[m-1][n-1]==1) {
    		return 0;
    	}
    	 int [][]dp=new int[m][n];
         dp[0][0]=1;
         for(int i=0;i<m;i++) {
         	for(int j=0;j<n;j++) {
         		if(obstacleGrid[i][j]==1) {
         			continue;
         		}
         		if(i-1>=0) {
         			dp[i][j]+=dp[i-1][j];
         		}
         		if(j-1>=0) {
         			dp[i][j]+=dp[i][j-1];
         		}
         	}
         }
         return dp[m-1][n-1];
    }
    public static void main(String[] args) {
		int[][] obstacleGrid= {
				{0,0,0},
				  {0,1,0},
				  {0,0,1}
		};
		System.out.println(uniquePathsWithObstacles(obstacleGrid));
	}
}
