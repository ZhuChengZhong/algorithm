package leetcode;
/**
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。

示例 1:

输入:
A: [1,2,3,2,1]
B: [3,2,1,4,7]
输出: 3
解释: 
长度最长的公共子数组是 [3, 2, 1]。

说明:

    1 <= len(A), len(B) <= 1000
    0 <= A[i], B[i] < 100


 * @author zhu
 *
 */
public class problem718 {
    public static int findLength1(int[] A, int[] B) {
        int l1=A.length;
        int l2=B.length;
        int[][]dp=new int[l1+1][l2+1];
        for(int i=1;i<=l1;i++) {
        	for(int j=1;j<=l2;j++) {
        		dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
        		if(A[i-1]==B[j-1]) {
        			dp[i][j]=Math.max(dp[i][j],dp[i][j]+1);
        		}
        	}
        }
        return dp[l1][l2];
    }
    public static int findLength(int[] A, int[] B) {
        int l1=A.length;
        int l2=B.length;
        int[][]dp=new int[l1+1][l2+1];
        int max=0;
        for(int i=1;i<=l1;i++) {
        	for(int j=1;j<=l2;j++) {
        		if(A[i-1]==B[j-1]) {
        			dp[i][j]=dp[i-1][j-1]+1;
        		}
        		if(dp[i][j]>max) {
        			max=dp[i][j];
        		}
        	}
        }
        return max;
    }
    public static void main(String[] args) {
		int[] a= {1,2,3,4,5,6};
		int[] b= {1,4,3,8,5,6};
		System.out.println(findLength(a, b));
	}
}
