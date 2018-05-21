package leetcode;
/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：

    每行中的整数从左到右按升序排列。
    每行的第一个整数大于前一行的最后一个整数。

示例 1:

输入:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
输出: true

示例 2:

输入:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
输出: false


 * @author zhu
 *
 */
public class problem74 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0||matrix[0].length==0) {
        	return false;
        }
    	int col=matrix[0].length-1;
    	int left=0,right=matrix.length-1;
    	int x, y;
    	while(left<right) {
    		int mid=(left+right)/2;
    		if(matrix[mid][col]==target) {
    			return true;
    		}
    		if(matrix[mid][col]<target) {
    			left=mid+1;
    		}else {
    			right=mid;
    		}
    	}
    	x=left;
    	
    	int row=left;
    	left=0;
    	right=matrix[0].length-1;
    	while(left<right) {
    		int mid=(left+right)/2;
    		if(matrix[row][mid]==target) {
    			return true;
    		}
    		if(matrix[row][mid]<target) {
    			left=mid+1;
    		}else {
    			right=mid;
    		}
    	}
    	y=left;
    	if(matrix[x][y]==target) {
    		return true;
    	}
    	return false;
    }
    public static void main(String[] args) {
		/*int[][]matrix = {
		                 {1,   3,  5,  7},
		                 {10, 11, 16, 20},
		                 {23, 30, 34, 50}
			};*/
    	int[][]matrix={{}};
		System.out.println(searchMatrix(matrix, 1));
	}
}
