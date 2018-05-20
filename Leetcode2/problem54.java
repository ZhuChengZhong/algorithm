package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。

示例 1:

输入:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
输出: [1,2,3,6,9,8,7,4,5]

示例 2:

输入:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
输出: [1,2,3,4,8,12,11,10,9,5,6,7]


 * @author zhu
 *
 */
public class problem54 {
    public static List<Integer> spiralOrder(int[][] matrix) {
    	List<Integer>result=new ArrayList<>();
    	int m=matrix.length;
    	int n=matrix[0].length;
    	int min=m<n?m:n;
    	int count=(min+1)/2;
        for(int i=0;i<count;i++) {
        	int x=i,y=i;
        	int lenR=n-(i*2)-1;
        	int lenC=m-(i*2)-1;
        	if(lenC==0) {
        		for(int j=0;j<=lenR;j++) {
        			result.add(matrix[x][y++]);
        		}
        		return result;
        	}
        	if(lenR==0) {
        		for(int j=0;j<=lenC;j++) {
        			result.add(matrix[x++][y]);
        		}
        		return result;
        	}
        	for(int j=0;j<lenR;j++) {
        		result.add(matrix[x][y]);
        		y++;
        	}
        	for(int j=0;j<lenC;j++) {
        		result.add(matrix[x][y]);
        		x++;
        	}
        	for(int j=0;j<lenR;j++) {
        		result.add(matrix[x][y]);
        		y--;
        	}
        	for(int j=0;j<lenC;j++) {
        		result.add(matrix[x][y]);
        		x--;
        	}
        }
        return result;
    }
    public static void main(String[] args) {
		/*int[][]matrix= {
				{ 1, 2, 3 },
				{ 4, 5, 6 },
				{ 7, 8, 9 }
		};*/
		/*int[][]matrix= {
				{1, 2, 3, 4},
				  {5, 6, 7, 8},
				  {9,10,11,12}
		};*/
    	int[][]matrix= {
    			{1,2}
		};
		System.out.println(spiralOrder(matrix));
	}
}
