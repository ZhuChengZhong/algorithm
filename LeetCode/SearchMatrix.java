package leetcode;

public class SearchMatrix {
	   public boolean searchMatrix(int[][] matrix, int target) {
	        if(matrix==null||matrix.length==0) return false;
	        int m=matrix.length,n=matrix[0].length;
	        int left=0,right=m*n-1;
	        while(left<right){
	            int mid=(left+right)>>1;
	            int row=mid/n;
	            int col=mid%n;
	            if(matrix[row][col]==target){
	                return true;
	            }else if(matrix[row][col]<target){
	                left=mid+1;
	            }else {
	                right=right-1;
	            }
	        }
	        return matrix[left/n][left%n]==target;
	    }
}
