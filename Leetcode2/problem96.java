package leetcode;
/**
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？

示例:

输入: 3
输出: 5
解释:
给定 n = 3, 一共有 5 种不同结构的二叉搜索树:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3


 * @author zhu
 *
 */
public class problem96 {
/*    public static int numTrees(int n) {
        if(n<=0) {
        	return 0;
        }
        return numTrees(1,n);
    }
    public static int numTrees(int l,int r) {
    	if(l>=r) {
    		return 1;
    	}
    	int sum=0;
        for(int i=l;i<=r;i++) {
        	sum+=numTrees(l,i-1)*numTrees(i+1,r);
        }
        return sum;
    }*/
    
    public static int numTrees(int n) {
        int[] dp=new int[n+1];
        dp[1]=1;
        dp[0]=1;
        for(int i=2;i<=n;i++) {
        	for(int j=1;j<=i;j++) {
        		dp[i]=dp[i]+dp[j-1]*dp[i-j];
        	}
        }
        return dp[n];
    }
    public static void main(String[] args) {
		System.out.println(numTrees(3));
	}
}
