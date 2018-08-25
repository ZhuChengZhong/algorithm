package leetcode;

import java.util.Arrays;

public class Rotate {
    public void rotate(int[][] matrix) {
        if(matrix==null&&matrix.length==0){
            return ;
        }
        int n=matrix.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i;j++){
                int t=matrix[i][j];
                matrix[i][j]=matrix[n-j-1][n-i-1];
                matrix[n-j-1][n-i-1]=t;
            }
        }
        for(int i=0;i<n/2;i++){
            for(int j=0;j<n;j++){
                int t=matrix[i][j];
                matrix[i][j]=matrix[n-1-i][j];
                matrix[n-1-i][j]=t;
            }
        }
    }
    public static void main(String[] args) {
		int[][]matrix={
				{1,2},
				{3,4}
		};
		new Rotate().rotate(matrix);
		for(int i=0;i<matrix.length;i++){
			System.out.println(Arrays.toString(matrix[i]));
		}
	}
}
