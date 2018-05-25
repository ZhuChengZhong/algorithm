package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。

例如，给定三角形：

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]

自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。

说明：

如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。

 * @author zhu
 *
 */
public class problem120 {
    public static int minimumTotal(List<List<Integer>> triangle) {
    	int m=triangle.size();
        int [][]dp=new int[m+1][m+1];
        for(int i=1;i<=m;i++) {
        	for(int j=1;j<=i;j++) {
        		if(j==1) {
        			dp[i][j]=dp[i-1][j]+triangle.get(i-1).get(j-1);
        		}else if(j==i) {
        			dp[i][j]=dp[i-1][j-1]+triangle.get(i-1).get(j-1);
        		}else {
        			dp[i][j]=Math.min(dp[i-1][j], dp[i-1][j-1])+triangle.get(i-1).get(j-1);
        		}
        	}
        }
        int min=dp[m][1];
        for(int i=1;i<=m;i++) {
        	min=Math.min(dp[m][i],min);
        }
        return min;
    }
    public static void main(String[] args) {
    	List<Integer> list=new ArrayList<>();
    	list.add(2);
    	List<Integer> list1=new ArrayList<>();
    	list1.add(5);
    	list1.add(4);
    	List<List<Integer>> triangle=new ArrayList<>();
    	triangle.add(list);
    	triangle.add(list1);
    	System.out.println(minimumTotal(triangle));
	}
}
