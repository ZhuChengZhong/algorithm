package leetcode;

import java.util.Arrays;

/**
 * 给定一个 n × n 的二维矩阵表示一个图像。

将图像顺时针旋转 90 度。

说明：

你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。

示例 1:

给定 matrix = 
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

原地旋转输入矩阵，使其变为:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]

示例 2:

给定 matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
], 

原地旋转输入矩阵，使其变为:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]


 * @author zhu
 *
 */
public class problem48 {
    public static void rotate(int[][] matrix) {
        if(matrix==null||matrix[0].length==0) {
        	return ;
        }
        int n=matrix[0].length-1;
        for(int i=0;i<(n+1)/2;i++) {
        	for(int l=0;l<n-(i*2);l++) {
        		int x=i;
        		int y=i+l;
        		int temp=matrix[x][y];
        		for(int j=0;j<3;j++) {
        			matrix[x][y]=matrix[n-y][x];
        			int t=x;
        			x=n-y;
        			y=t;
        		}
        		matrix[x][y]=temp;
        	}
        }
    }
    public static void main(String[] args) {
		int [][]matrix =
				{
				  { 5, 1, 9,11},
				  { 2, 4, 8,10},
				  {13, 3, 6, 7},
				  {15,14,12,16}
    			};
		rotate(matrix);
		for(int i=0;i<matrix.length;i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
	}
}
